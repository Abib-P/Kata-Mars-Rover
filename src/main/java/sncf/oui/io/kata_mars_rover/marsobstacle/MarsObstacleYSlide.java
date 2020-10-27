package sncf.oui.io.kata_mars_rover.marsobstacle;

public class MarsObstacleYSlide implements MarsObstacle{
    private final int slideDirection;

    public MarsObstacleYSlide(int newSlideDirection){
        slideDirection = newSlideDirection;
    }

    public int getSlideDirection() {
        return slideDirection;
    }
}
