package tictactoe;

import java.util.Scanner;

/*
 * Player.java
 * Reads Player input and returns it to Game.java
 */
public class Player implements Entity {

    private static final Scanner SCANNER = new Scanner(System.in);

    /*
     * Reads an input and compares it with the board
     * Returns the player's input if the input is valid
     */
    public int takeTurn() {
        int input = -1;

        do {
            Game.print("Please enter a number:\n");
            input = SCANNER.nextInt() - 1; // Convert from [1-9] to [0-8]

            if (input < 0 || input > 8) {
                Game.print("The number must be between 1 and 9\n");
                input = -1;
            } else if (!Board.isValid(input)) {
                Game.print("There is already a piece there\n");
                input = -1;
            }

        } while (input == -1);
        return input;
    }

    public String toString() {
        return "Player";
    }
}