package tictactoe;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Driver Class
 */
public class TicTacToe {

    public static void main(String[] args) {

        Game game = new Game();

        try {
            game.start();
        } catch (InterruptedException e) {
            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, "Error: Could not start game");
        }
    }
}