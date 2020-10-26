package sncf.oui.io.kata_mars_rover;

import java.util.Random;

public class MarsMap {
    private final Rover rover;
    private final int width;
    private final int height;

    public MarsMap()
    {
        rover = new Rover();
        Random r = new Random();
        width = r.nextInt(15 + 1) + 5;
        height = r.nextInt(15 + 1) + 5;
    }

    public MarsMap(int newWidth,int newHeight)
    {
        rover = new Rover();
        width = newWidth;
        height = newHeight;
    }

    public String moveRover(String movement) {
        rover.move(movement);
        rover.setYPosition(width+ rover.getYPosition());


        return rover.move(null)+":"+ rover.getXPosition()+":"+ rover.getYPosition();
    }
}
