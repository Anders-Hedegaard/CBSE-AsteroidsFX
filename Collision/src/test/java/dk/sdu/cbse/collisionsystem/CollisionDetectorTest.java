package dk.sdu.cbse.collisionsystem;

import dk.sdu.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.cbse.common.data.Entity;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;


public class CollisionDetectorTest {
    // Mock IAsteroidSplitter
    IAsteroidSplitter mockSplitter = Mockito.mock(IAsteroidSplitter.class);
    private final CollisionDetector collisionDetector = new CollisionDetector(mockSplitter);

    @Test
    void testCollisionDetectionAtSamePosition() {
        // Create two entities with positions and sizes
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();

        // Set the positions of the entities
        entity1.setX(10.0);
        entity1.setY(20.0);
        entity1.setRadius(5.0F);
        entity2.setX(10.0);
        entity2.setY(20.0);
        entity2.setRadius(5.0F);
        // Check if the entities collide
        boolean collision = collisionDetector.collides(entity1, entity2);

        // Assert that the entities collide
        Assertions.assertTrue(collision);
    }
    @Test
    void testNoCollisionDetection() {
        // Create two entities with positions and sizes
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();

        // Set the positions of the entities
        entity1.setX(10.0);
        entity1.setY(20.0);
        entity1.setRadius(5.0F);
        entity2.setX(100.0);
        entity2.setY(200.0);
        entity2.setRadius(5.0F);
        // Check if the entities collide
        boolean collision = collisionDetector.collides(entity1, entity2);

        // Assert that the entities do not collide
        Assertions.assertFalse(collision);
    }
    @Test
    void testCollisionDetectionWithDifferentSizes() {
        // Create two entities with positions and sizes
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();

        // Set the positions of the entities
        entity1.setX(10.0);
        entity1.setY(20.0);
        entity1.setRadius(5.0F);
        entity2.setX(10.0);
        entity2.setY(20.0);
        entity2.setRadius(10.0F);
        // Check if the entities collide
        boolean collision = collisionDetector.collides(entity1, entity2);

        // Assert that the entities collide
        Assertions.assertTrue(collision);
    }
    @Test
    void testCollisionDetectionWithDifferentPositions() {
        // Create two entities with positions and sizes
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();

        // Set the positions of the entities
        entity1.setX(10.0);
        entity1.setY(20.0);
        entity1.setRadius(5.0F);
        entity2.setX(20.0);
        entity2.setY(30.0);
        entity2.setRadius(5.0F);
        // Check if the entities collide
        boolean collision = collisionDetector.collides(entity1, entity2);

        // Assert that the entities do not collide
        Assertions.assertFalse(collision);
    }
}
