package sncf.oui.io.kata_mars_rover;

import java.util.HashMap;

public class Rover{

    private int facingDirection;
    private final HashMap<Integer,Character> direction;
    private int xPosition;
    private int yPosition;

    public Rover(){
        facingDirection = 0;

        direction = new HashMap<>();
        direction.put(0,'N');
        direction.put(1,'E');
        direction.put(2,'S');
        direction.put(3,'W');

        xPosition = 0;
        yPosition = 0;
    }

    public Rover(Rover newRover){
        facingDirection = newRover.facingDirection;

        direction = newRover.direction;

        xPosition = newRover.xPosition;
        yPosition = newRover.yPosition;
    }

    public void resetRover(Rover newRover){
        facingDirection = newRover.facingDirection;

        xPosition = newRover.xPosition;
        yPosition = newRover.yPosition;
    }

    public char move(Character movement) {
        if (movement == null)
            return direction.get(facingDirection);

            if(movement == 'L')
                facingDirection--;
            if(movement == 'R')
                facingDirection++;
            if((movement == 'F' && direction.get(facingDirection) == 'N') || (movement == 'B' && direction.get(facingDirection) == 'S'))
                yPosition++;
            if((movement == 'F' && direction.get(facingDirection) == 'E') || (movement == 'B' && direction.get(facingDirection) == 'W'))
                xPosition++;
            if((movement == 'F' && direction.get(facingDirection) == 'S') || (movement == 'B' && direction.get(facingDirection) == 'N'))
                yPosition--;
            if((movement == 'F' && direction.get(facingDirection) == 'W') || (movement == 'B' && direction.get(facingDirection) == 'E'))
                xPosition--;
            if(facingDirection < 0)
                facingDirection = 3;
            if(facingDirection > 3)
                facingDirection = 0;
        return direction.get(facingDirection);
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int newXPosition) {
        xPosition = newXPosition;
    }

    public void setYPosition(int newYPosition) {
        yPosition = newYPosition;
    }
}
