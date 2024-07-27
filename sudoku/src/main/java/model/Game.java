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

    public void guess(int coordX, int coordY, int num) {
        Cell cell = this.board.getMatrix()[coordY][coordX];
        if (cell.isShown()) {
            throw new IllegalStateException("Cannot set value for full cell");

        } else {
            cell.setGuess(num);
        }

    }

    public static void main(String[] args) {
    }
}
