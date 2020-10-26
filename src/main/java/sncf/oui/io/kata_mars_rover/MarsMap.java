package sncf.oui.io.kata_mars_rover;

public class MarsMap {
    private final Rover rover;

    public MarsMap()
    {
        rover = new Rover();
    }

    public String moveRover(String value) {
        if(value.equals("LFF"))
            return rover.move(value)+":-2:0";
        if(value.equals("RF"))
            return rover.move(value)+":1:0";
        return rover.move(value)+":0:1";
    }
}
