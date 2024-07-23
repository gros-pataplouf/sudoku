package sudoku;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Board;

public class GameTest {
    @Test
    public void invalidBoardTwoSameInRow() {
        Board board = new Board();
        board.load("[2, 3, 4, 1, 8, 5, 6, 7, 4]\n" + "[0, 0, 0, 0, 0, 0, 0, 0, 0]\n".repeat(8));
        assertTrue(!board.isValid());
    }

    @Test
    public void invalidBoardTwoSameInColumn() {
        Board board = new Board();
        board.load("[1, 2, 3, 4, 5, 6, 7, 8, 9]\n".repeat(9));
        assertTrue(!board.isValid());
    }

    @Test
    public void invalidBoardTwoSameInBox() {
        Board board = new Board();
        board.load(
                "[1, 2, 3, 4, 5, 6, 7, 8, 9]\n"
                        + "[2, 3, 4, 5, 6, 7, 8, 9, 1]\n"
                        + "[3, 4, 5, 6, 7, 8, 9, 1, 2]\n"
                        + "[4, 5, 6, 7, 8, 9, 1, 2, 3]\n"
                        + "[5, 6, 7, 8, 9, 1, 2, 3, 4]\n"
                        + "[6, 7, 8, 9, 1, 2, 3, 4, 5]\n"
                        + "[7, 8, 9, 1, 2, 3, 4, 5, 6]\n"
                        + "[8, 9, 1, 2, 3, 4, 5, 6, 7]\n"
                        + "[9, 1, 2, 3, 4, 5, 6, 7, 8]\n");
        assertTrue(!board.isValid());
    }

}
