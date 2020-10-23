package sncf.oui.io.kata_mars_rover;

import java.util.HashMap;

public class Rover {
    private int facingDirection;
    private final HashMap<Integer,Character> direction;
    public Rover(){
        facingDirection = 0;
        direction = new HashMap<>();
        direction.put(0,'N');
        direction.put(1,'E');
        direction.put(2,'S');
        direction.put(3,'W');
    }

    public char move(String movement) {
        if (movement == null || movement.isEmpty())
            return direction.get(facingDirection);
        for (int i = 0 ; i < movement.length() ; i++) {
            if(movement.toCharArray()[i] == 'L')
                facingDirection--;
            if(movement.toCharArray()[i] == 'R')
                facingDirection++;
            if(facingDirection < 0)
                facingDirection = 3;
            if(facingDirection > 3)
                facingDirection = 0;
        }

        return direction.get(facingDirection);
    }
}
