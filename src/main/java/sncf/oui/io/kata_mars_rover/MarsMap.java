package sncf.oui.io.kata_mars_rover;

public class MarsMap {
    private final Rover rover;

    public MarsMap()
    {
        rover = new Rover();
    }

    public String moveRover(String movement) {
        return rover.move(movement)+":"+ rover.getxPosition()+":"+ rover.getyPosition();
    }
}
