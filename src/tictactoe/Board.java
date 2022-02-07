package tictactoe;

/**
 * The Board Class.
 */
public class Board {

    private static Piece[] board = new Piece[9];
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
        Game.print("In this game, you will be playing Tic Tac Toe against a computer.\n"
                + "\nDuring your turn, you will enter a number 1-9, each corrisponding to a specific slot on the board."
                + "\nIf the input is not in between 1 and 9 or there is already something in the specific slot, it will ask you to enter a new number.\n");

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
     * Determines if the computer has a slot to win or block player from winning
     */
    public static int findOveride() {

        // Compares slots at each row/column
        for (int i = 0; i < 3; i++) {

            // ROWS

            // If left and middle are the same, return right
            if (board[i * 3] != Piece.BLANK && board[i * 3] == board[i * 3 + 1] && board[i * 3] != board[i * 3 + 2]
                    && isValid(i * 3 + 2))
                return (i * 3) + 2;

            // If left and right are the same, return midde
            if (board[i * 3] != Piece.BLANK && board[i * 3] != board[i * 3 + 1] && board[i * 3] == board[i * 3 + 2]
                    && isValid(i * 3 + 1))
                return (i * 3) + 1;

            // If middle and right are the same, return left
            if (board[i * 3 + 1] != Piece.BLANK && board[i * 3] != board[i * 3 + 1]
                    && board[i * 3 + 1] == board[i * 3 + 2] && isValid(i * 3))
                return (i * 3);

            // COLUMNS

            // If top and middle are the same, return bottom
            if (board[i] != Piece.BLANK && board[i] == board[i + 3] && board[i] != board[i + 6] && isValid(i + 6))
                return i + 6;

            // If top and bottom are the same, return bottom
            if (board[i] != Piece.BLANK && board[i] != board[i + 3] && board[i] == board[i + 6] && isValid(i + 3))
                return i + 3;

            // If middle and bottom are the same, return top
            if (board[i + 3] != Piece.BLANK && board[i] != board[i + 3] && board[i + 3] == board[i + 6] && isValid(i))
                return i;
        }

        // DIAGONAL

        // Missing bottom corners
        if (board[0] != Piece.BLANK && board[0] == board[4] && board[0] != board[8] && isValid(8))
            return 8;

        if (board[2] != Piece.BLANK && board[2] == board[4] && board[2] != board[6] && isValid(6))
            return 6;

        // Missing top corners
        if (board[4] != Piece.BLANK && board[4] == board[8] && board[4] != board[0] && isValid(0))
            return 0;

        if (board[4] != Piece.BLANK && board[4] == board[6] && board[4] != board[2] && isValid(2))
            return 2;

        // Missing middle
        if (board[0] != Piece.BLANK && board[0] == board[8] && board[0] != board[4] && isValid(4))
            return 4;

        if (board[2] != Piece.BLANK && board[2] == board[6] && board[2] != board[4] && isValid(4))
            return 4;

        return -1;
    }

    /*
     * Board check methods
     */
    public static boolean isFull() {
        for (Enum<Piece> c : board) {
            if (c == Piece.BLANK)
                return false;
        }
        return true;
    }

    /*
     * Returns true if slot is blank
     * Returns false is slot is taken or parameter is out of bounds
     */
    public static boolean isValid(int slot) {
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