package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.World;

public class AsteroidSplitterImpl implements IAsteroidSplitter {
    public AsteroidSplitterImpl() {
    }

    @Override
    public void createSplitAsteroid(Entity e, World world) {
        double[] entityCoordinates = e.getPolygonCoordinates();
        for (int i = 0; i < entityCoordinates.length; i++) {
            entityCoordinates[i] = entityCoordinates[i] * 0.7;
        }
        double yCoordinate = e.getY();
        double xCoordinate = e.getX();
        double rotation = e.getRotation();
        float radius = e.getRadius();

        if (e.getRadius() <= 10) {
            world.removeEntity(e);
        }else{
            Entity asteroid1 = new Asteroid();
            asteroid1.setPolygonCoordinates(entityCoordinates);
            asteroid1.setY(yCoordinate + 10);
            asteroid1.setX(xCoordinate + 10);
            asteroid1.setRadius((float) entityCoordinates[0]);
            asteroid1.setRotation(rotation + 5);

            Entity asteroid2 = new Asteroid();
            asteroid2.setPolygonCoordinates(entityCoordinates);
            asteroid2.setY(yCoordinate - 10);
            asteroid2.setX(xCoordinate - 10);
            asteroid2.setRadius((float) entityCoordinates[0]);
            asteroid2.setRotation(rotation - 5);

            world.removeEntity(e);
            world.addEntity(asteroid1);
            world.addEntity(asteroid2);
        }
    }
}
