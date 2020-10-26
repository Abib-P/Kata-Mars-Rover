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

    public char move(String movement) {
        if (movement == null || movement.isEmpty() || movement.isBlank())
            return direction.get(facingDirection);
        for (int i = 0 ; i < movement.length() ; i++) {
            if(movement.charAt(i) == 'L')
                facingDirection--;
            if(movement.charAt(i) == 'R')
                facingDirection++;
            if((movement.charAt(i) == 'F' && direction.get(facingDirection) == 'N') || (movement.charAt(i) == 'B' && direction.get(facingDirection) == 'S'))
                yPosition++;
            if((movement.charAt(i) == 'F' && direction.get(facingDirection) == 'E') || (movement.charAt(i) == 'B' && direction.get(facingDirection) == 'W'))
                xPosition++;
            if((movement.charAt(i) == 'F' && direction.get(facingDirection) == 'S') || (movement.charAt(i) == 'B' && direction.get(facingDirection) == 'N'))
                yPosition--;
            if((movement.charAt(i) == 'F' && direction.get(facingDirection) == 'W') || (movement.charAt(i) == 'B' && direction.get(facingDirection) == 'E'))
                xPosition--;
            if(facingDirection < 0)
                facingDirection = 3;
            if(facingDirection > 3)
                facingDirection = 0;
        }
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
