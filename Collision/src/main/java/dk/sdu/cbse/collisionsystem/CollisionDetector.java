package dk.sdu.cbse.collisionsystem;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import java.util.ServiceLoader;


public class CollisionDetector implements IPostEntityProcessingService {
    private IAsteroidSplitter asteroidSplitter;

    public CollisionDetector() {
        ServiceLoader<IAsteroidSplitter> loader = ServiceLoader.load(IAsteroidSplitter.class);
        asteroidSplitter = loader.findFirst()
                .orElseThrow(() -> new RuntimeException("No AsteroidSplitter implementation found"));
    }


    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    if (entity1 instanceof Asteroid) {
                        if (entity2 instanceof Asteroid) {
                        // If both entities are asteroids, nothing happens
                        }
                        else {
                            // If entity 1 is an asteroid, it splits, and the other disappears
                            asteroidSplitter.createSplitAsteroid(entity1, world);
                            world.removeEntity(entity2);
                        }
                    } else if (entity2 instanceof Asteroid) {
                        // If entity 2 is an asteroid, it splits, and the other disappears
                        asteroidSplitter.createSplitAsteroid(entity2, world);
                        world.removeEntity(entity1);
                    } else {
                        // If neither entities are asteroids, they both disappear
                        world.removeEntity(entity1);
                        world.removeEntity(entity2);
                    }
                }
            }
        }
    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

}
