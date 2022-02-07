package tictactoe;

import java.util.Random;

/*
 * Game.java
 * This class controls the game's basic functions
 * Game loop runs until someone wins or the player exits
 */

public class Game {

    // Utility Variables
    private static final Random RANDOM = new Random();

    // Control Variables
    private static Entity[] order;
    private static boolean running;

    /*
     * Determines an order for the game and then calls the game control method
     */
    public void start() throws InterruptedException {

        // Initialize Variables
        boolean first = RANDOM.nextBoolean();
        Player player = new Player();
        Computer comp = new Computer();
        order = new Entity[2];
        running = true;

        // Prints the instructions
        Board.reset();
        Board.printInstructions();

        // Wait 3 seconds for player to read instructions
        Thread.sleep(3000);

        // Determine order
        if (first) {
            order[0] = player;
            order[1] = comp;
            print("You will go first\n");
        } else {
            order[0] = comp;
            order[1] = player;
            print("Computer will go first\n");
        }
        gameControl();
    }

    /*
     * Controls the game loop,
     */
    private void gameControl() {

        // Game loop
        do {

            // First
            if (takeTurn(order[0], Piece.X)) {
                running = false;
                break;
            }

            // Second
            if (takeTurn(order[1], Piece.O)) {
                running = false;
                break;
            }
        } while (running);
        print("Thanks for playing!");
    }

    private boolean takeTurn(Entity e, Piece p) {
        int input = e.takeTurn();
        Board.addPiece(p, input);
        Board.printCurrent();

        if (Board.checkWin(p)) {
            print(e + " has won.\n");
            return true;
        }

        if (Board.isFull()) {
            print("The game is a tie\n");
            return true;
        }
        return false;
    }

    public static void print(String message) {
        System.out.println(message);
    }
}