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

        int numberOfRock = r.nextInt((width * height)/5);
        int numberOfXSlide = r.nextInt((width * height)/5);
        int numberOfYSlide = r.nextInt((width * height)/5);

        int x;
        int y;

        for (int i = 0 ; i < numberOfRock ; i++)
        {
            x = r.nextInt(width);
            y = r.nextInt(height);
            map[x][y] = new MarsObstacleRock();
        }
        for (int i = 0 ; i < numberOfXSlide ; i++)
        {
            x = r.nextInt(width);
            y = r.nextInt(height);
            map[x][y] = new MarsObstacleXSlide(r.nextInt(2));
        }
        for (int i = 0 ; i < numberOfYSlide ; i++)
        {
            x = r.nextInt(width);
            y = r.nextInt(height);
            map[x][y] = new MarsObstacleYSlide(r.nextInt(2));
        }

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

            putBackRover();

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
                putBackRover();

            }while (map[rover.getXPosition()][rover.getYPosition()] != null);

        }
        seeMap();
        return rover.move(null)+":"+ rover.getXPosition()+":"+ rover.getYPosition();
    }

    private void putBackRover() {

        if (rover.getYPosition() >= height)
            rover.setYPosition(rover.getYPosition() - height);
        if (rover.getYPosition() < 0)
            rover.setYPosition(rover.getYPosition() + height);

        if (rover.getXPosition() >= width)
            rover.setXPosition(rover.getXPosition() - width);
        if (rover.getXPosition() < 0)
            rover.setXPosition(rover.getXPosition() + width);

    }

    private void seeMap() {

        System.out.print("╔");
        for(int i = 0 ; i < width ; i++)
        {
            System.out.print("═");
        }
        System.out.print("╗\n");

        for(int y = height-1 ; y >= 0 ; y--){
            System.out.print("║");
            for(int x = 0 ; x < width ; x++){
                if(rover.getXPosition() == x && rover.getYPosition() == y){
                    System.out.print(rover.move(null));
                }
                else if(map[x][y] instanceof MarsObstacleRock){
                    System.out.print("▓");
                }
                else if(map[x][y] instanceof MarsObstacleXSlide){
                    if(((MarsObstacleXSlide) map[x][y]).getSlideDirection() > 0)
                        System.out.print("→");
                    else
                        System.out.print("←");
                }
                else if(map[x][y] instanceof MarsObstacleYSlide){
                    if(((MarsObstacleYSlide) map[x][y]).getSlideDirection() > 0)
                        System.out.print("↑");
                    else
                        System.out.print("↓");
                }
                else{
                    System.out.print("0");
                }

            }
            System.out.print("║\n");
        }
        System.out.print("╚");
        for(int i = 0 ; i < width ; i++)
        {
            System.out.print("═");
        }
        System.out.print("╝\n");

    }

}
