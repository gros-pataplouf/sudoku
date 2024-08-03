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
        System.out.println("guessing " + num + " in game " + cell.getDisplayValue() + " at " + coordX + "/" + coordY);
        if (cell.isShown()) {
            throw new IllegalStateException("Cannot set value for full cell");

        } else {
            cell.setGuess(num);
            if (!this.board.canInsert(num, coordX, coordY)) {
                cell.setValid(false);
            }
        }

    }

    public boolean guessPlayer(int coordX, int coordY, int num) {
        System.out.println("guess player from game");
        Board copyOfBoard = Board.loadFromString(this.board().toStringPublic());
        Cell cell = copyOfBoard.getMatrix()[coordY][coordX];
        System.out.println(copyOfBoard.toString());
        System.out.println("guessing " + num + " in game " + cell.getDisplayValue() + " at " + coordX + "/" + coordY);
        cell.setGuess(num);
        System.out.println(cell.getDisplayValue());
        if (!copyOfBoard.canInsert(num, coordX, coordY)) {
            cell.setValid(false);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
