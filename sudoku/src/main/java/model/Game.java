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
            if (!this.board.canInsert(num, coordX, coordY)) {
                cell.setValid(false);
            }
        }

    }

    public boolean guessPlayer( int num, int coordX, int coordY) {
        System.out.println("guess Player" + coordX + coordY + num);
        Board copyOfBoard = Board.loadFromString(this.board().toStringPublic());
        Cell cell = this.board().getMatrix()[coordY][coordX];
        cell.setGuess(num);
        System.out.println("guess set to " + num);
        System.out.println("getting guess updated " + cell.getGuess());
        if (!copyOfBoard.canInsert(num, coordX, coordY)) {
            cell.setValid(false);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
