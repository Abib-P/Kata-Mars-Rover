package sncf.oui.io.kata_mars_rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarsMap {
    private final Rover rover;
    private final int width;
    private final int height;
    private final boolean map[][];

    public MarsMap()
    {
        rover = new Rover();
        Random r = new Random();
        width = r.nextInt(15 + 1) + 5;
        height = r.nextInt(15 + 1) + 5;
        map = new boolean[width][height];
    }

    public MarsMap(int newWidth, int newHeight, boolean[][] obstacle)
    {
        rover = new Rover();
        width = newWidth;
        height = newHeight;
        map = obstacle;
    }

    public String moveRover(String movement) {

        for(int i = 0 ; i < movement.length() ; i++)
        {
            Rover oldRover = new Rover(rover);
            rover.move(movement.charAt(i));

            if(rover.getYPosition() >= height)
                rover.setYPosition(rover.getYPosition() - height);
            if(rover.getYPosition() < 0)
                rover.setYPosition(rover.getYPosition() + height);

            if(rover.getXPosition() >= width)
                rover.setXPosition(rover.getXPosition() - width);
            if(rover.getXPosition() < 0)
                rover.setXPosition(rover.getXPosition() + width);

            if(map[rover.getXPosition()][rover.getYPosition()])
                rover.resetRover(oldRover);
        }

        return rover.move(null)+":"+ rover.getXPosition()+":"+ rover.getYPosition();
    }
}
