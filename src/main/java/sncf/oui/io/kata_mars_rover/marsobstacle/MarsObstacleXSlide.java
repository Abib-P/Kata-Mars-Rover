package sncf.oui.io.kata_mars_rover.marsobstacle;

public class MarsObstacleXSlide implements MarsObstacle{
    private final int slideDirection;

    public MarsObstacleXSlide(int newSlideDirection){
        slideDirection = newSlideDirection;
    }

    public int getSlideDirection() {
        return slideDirection;
    }
}
