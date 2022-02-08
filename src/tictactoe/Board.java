package tictactoe;

/**
 * The Board Class.
 */
public class Board {

    private static final Piece[] board = new Piece[9];
    private static final String LINE = "-----------";

    /*
     * Hidden Constructor
     */
    private Board() {
        throw new IllegalStateException("Board.java");
    }

    /*
     * Print Current State of the Board
     */
    public static void printCurrent() {
        Game.print("\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        Game.print(LINE);
        Game.print(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        Game.print(LINE);
        Game.print(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");

        Game.print("\n\n\n");
    }

    /*
     * Demo Board Example
     */
    public static void printInstructions() {
        Game.print("In this game, you will be playing Tic Tac Toe against a computer.\nDuring your turn, you will enter a number 1-9, each corrisponding to a specific slot on the board.\n If the input is not in between 1 and 9 or there is already something in the specific slot, it will ask you to enter a new number.\n");

        Game.print("\n 1 | 2 | 3 \n" + LINE + "\n 4 | 5 | 6 \n" + LINE + "\n 7 | 8 | 9 \n\n");
    }

    /*
     * Checks all possible wins
     * C is the player's symbol
     */
    public static boolean checkWin(Piece c) {

        // Compares slots to check for win
        for (int i = 0; i < 3; i++) {

            // Check for horizontal win at each row
            if (board[i * 3] == board[i * 3 + 1] && board[i * 3] == board[i * 3 + 2] && board[i * 3] == c)
                return true;

            // Check for vertical win at each column
            if (board[i] == board[i + 3] && board[i] == board[i + 6] && board[i] == c)
                return true;
        }

        // Diagonal wins
        if (board[0] == board[4] && board[0] == board[8] && board[0] == c)
            return true;

        return board[2] == board[4] && board[2] == board[6] && board[2] == c;
    }

    /*
     * Board check methods
     */
    public static boolean isFull() {
        for (Piece c : board)
            if (c == Piece.BLANK) return false;
        return true;
    }

    /*
     * Returns true if slot is taken or parameter
     * Returns false is slot is taken or parameter is out of bounds
     */
    public static boolean notValid(int slot) {
        if (slot < 0 || slot > 8)
            return false;
        return board[slot] == Piece.BLANK;
    }

    public static void addPiece(Piece p, int slot) {
        board[slot] = p;
    }

    public static Piece getPiece(int slot) {
        return board[slot];
    }

    public static void reset() {
        for (int i = 0; i < 9; i++)
            board[i] = Piece.BLANK;
    }
}