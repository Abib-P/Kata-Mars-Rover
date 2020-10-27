package sncf.oui.io.kata_mars_rover.marsmap;

import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacle;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacleRock;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacleXSlide;
import sncf.oui.io.kata_mars_rover.marsobstacle.MarsObstacleYSlide;
import sncf.oui.io.kata_mars_rover.rover.Rover;

import java.util.Random;

public class MarsMap {
    private final Rover rover;
    private final int width;
    private final int height;
    private final MarsObstacle[][] map;

    public MarsMap()
    {
        rover = new Rover();
        Random r = new Random();
        width = r.nextInt(15 + 1) + 5;
        height = r.nextInt(15 + 1) + 5;
        map = new MarsObstacle[width][height];
    }

    public MarsMap(int newWidth, int newHeight, MarsObstacle[][] obstacle)
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

            do{

            if(map[rover.getXPosition()][rover.getYPosition()] instanceof MarsObstacleRock) {
                rover.resetRover(oldRover);
                break;
            }else if(map[rover.getXPosition()][rover.getYPosition()] instanceof MarsObstacleXSlide) {

                if (((MarsObstacleXSlide) map[rover.getXPosition()][rover.getYPosition()]).getSlideDirection() > 0){
                    oldRover = new Rover(rover);
                    rover.setXPosition(rover.getXPosition() + 1);
                }
                else {
                    oldRover = new Rover(rover);
                    rover.setXPosition(rover.getXPosition() - 1);
                }

            }else if(map[rover.getXPosition()][rover.getYPosition()] instanceof MarsObstacleYSlide){

                if (((MarsObstacleYSlide) map[rover.getXPosition()][rover.getYPosition()]).getSlideDirection() > 0) {
                    oldRover = new Rover(rover);
                    rover.setYPosition(rover.getYPosition() + 1);
                }
                else {
                    oldRover = new Rover(rover);
                    rover.setYPosition(rover.getYPosition() - 1);
                }

            }
                if(rover.getYPosition() >= height)
                    rover.setYPosition(rover.getYPosition() - height);
                if(rover.getYPosition() < 0)
                    rover.setYPosition(rover.getYPosition() + height);

                if(rover.getXPosition() >= width)
                    rover.setXPosition(rover.getXPosition() - width);
                if(rover.getXPosition() < 0)
                    rover.setXPosition(rover.getXPosition() + width);

            }while (map[rover.getXPosition()][rover.getYPosition()] != null);

        }

        return rover.move(null)+":"+ rover.getXPosition()+":"+ rover.getYPosition();
    }
}
