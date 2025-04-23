import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import  dk.sdu.cbse.common.asteroids.IAsteroidSplitter;

module Collision {
    requires Common;
    requires CommonAsteroids;
    provides IPostEntityProcessingService with dk.sdu.cbse.collisionsystem.CollisionDetector;
    uses IAsteroidSplitter;
}