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

        while(rover.getYPosition() >= height)
            rover.setYPosition(rover.getYPosition() - height);
        while(rover.getYPosition() < 0)
            rover.setYPosition(rover.getYPosition() + height);

        while(rover.getXPosition() >= width)
            rover.setXPosition(rover.getXPosition() - width);
        while(rover.getXPosition() < 0)
            rover.setXPosition(rover.getXPosition() + width);

        return rover.move(null)+":"+ rover.getXPosition()+":"+ rover.getYPosition();
    }
}
