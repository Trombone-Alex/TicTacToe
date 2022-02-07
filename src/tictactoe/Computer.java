package tictactoe;

import java.util.Random;

public class Computer implements Entity {

    private static final Random random = new Random();

    /*
     * Returns valid slot for computer's turn
     */
    public int takeTurn() {

        int slot = Board.findOveride();

        if(slot != -1)
            return slot;

        do {
            slot = random.nextInt(9);
        } while (!Board.isValid(slot));

        return slot;
    }

    public String toString(){
        return "Computer";
    }

}
