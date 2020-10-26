package sncf.oui.io.kata_mars_rover;

public class MarsMap {
    private final Rover rover;

    public MarsMap()
    {
        rover = new Rover();
    }

    public String moveRover(String value) {
        if(value.charAt(0) == 'R')
            return rover.move(value)+":1:0";
        return rover.move(value)+":0:1";
    }
}
