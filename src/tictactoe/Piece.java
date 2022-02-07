package tictactoe;

public enum Piece {
    X('X'), O('O'), BLANK(' ');

    private char symbol;

    Piece(char c) {
        symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }

    public String toString() {
        return symbol + "";
    }
}
