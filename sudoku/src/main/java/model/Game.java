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


    public boolean guess(int num, int coordX, int coordY) {
        Cell cell = this.board().getMatrix()[coordY][coordX];
        if (cell.isShown()) {
            throw new IllegalStateException("Cannot set value for full cell");
        }
        Board copyOfBoard = Board.copyFromString(this.board().toString(true));
        cell.setGuess(num);
        if (!copyOfBoard.canInsert(num, coordX, coordY)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
