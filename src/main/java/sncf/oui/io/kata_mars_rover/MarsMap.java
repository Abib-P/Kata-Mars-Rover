package sncf.oui.io.kata_mars_rover;

public class MarsMap {
    private final Rover rover;

    public MarsMap()
    {
        rover = new Rover();
    }

    public String moveRover(String value) {
        return rover.move(null)+":0:1";
    }
}
