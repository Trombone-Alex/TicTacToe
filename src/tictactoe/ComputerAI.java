package tictactoe;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * This class determines the computers next move
 * If the computer has a win possibility or a possibility to block the player,
 * this class will override the random method in Computer.takeTurn()
 */
public class ComputerAI{

    // Player and Computer's piece
    public static Piece player = null;
    public static Piece comp = null;

    /*
     * Determines if the computer has a slot to win or block player from winning
     * player and comp must be set before this method is called
     */
    public static int findOverride(){

     try {
         // Computer has a win opportunity
         if (checkCombinations(comp) != -1)
             return checkCombinations(comp);

         // Computer has a block opportunity
         if (checkCombinations(player) !=3 -1)
             return checkCombinations(player);
         return -1;
        } catch(NullPointerException e){
         Logger.getLogger(ComputerAI.class.getName()).log(Level.WARNING, "Computer AI not initialized");
         return -1;
     }
    }

    /*
     * Checks all the computer's win possibilities
     */
    private static int checkCombinations(Piece p){

        int slot;

        // Check for all win possibilities
        for(int i = 0; i < 3; i++){

            // Checks all rows
            if((slot = checkComputerOrder(i*3, i*3+1, i*3+2, p)) != -1)
                return slot;

            // Check all columns
            if((slot = checkComputerOrder(i, i+3, i+6, p)) != -1)
                return slot;
        }

        if((slot = checkComputerOrder(0, 4, 8, p)) != -1)
            return slot;

        if((slot = checkComputerOrder(2, 4, 6, p)) != -1)
            return slot;

        return -1;
    }


    /*
     * Checks if the computer has an opportunity to win/block player from winning
     * To Win: p is the computer's piece
     * To Block: p is the player's piece
     */
    private static int checkComputerOrder(int one, int two, int three, Piece p) {

        // Missing 3rd column/row
        if(Board.getPiece(one) == p && Board.getPiece(two) == p && Board.getPiece(three) == Piece.BLANK)
            return three;

        // Missing 2nd column/row
        if(Board.getPiece(one) == p && Board.getPiece(two) == Piece.BLANK && Board.getPiece(three) == p)
            return two;

        // Missing 1st column/row
        if(Board.getPiece(one) == Piece.BLANK && Board.getPiece(two) == p && Board.getPiece(three) == p)
            return one;

        // No win possibilities found, return -1
        return -1;
    }
}
