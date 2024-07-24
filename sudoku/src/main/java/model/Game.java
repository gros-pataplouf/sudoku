package model;

public class Game {
    private Board board;

    public Game() {
        this.board = new Board();
        board.fill(0);
        board.initialize();
    }

    public Board board() {
        return this.board;
    }

    public static void main(String[] args) {
    }
}
