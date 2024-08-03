package sudoku;


import static org.junit.Assert.assertTrue;
import org.junit.Test;

import model.Board;
import model.Cell;

public class BoardTest {

    @Test
    public void rowHas9Cells() {
        Board board = new Board();
        String firstRow = board.getRowString(0);
        assertTrue(firstRow.toString().equals("[0, 0, 0, 0, 0, 0, 0, 0, 0]"));
    }

    @Test
    public void boardHas9RowsOf9Cells() {
        Board board = new Board();
        String boardString = board.toString();
        assertTrue(boardString.equals("[0, 0, 0, 0, 0, 0, 0, 0, 0]\n".repeat(9)));
    }

    @Test
    public void canLoadBoardFromString() {
        Board board = new Board();
        board.load("[1, 2, 3, 6, 5, 4, 3, 2, 1]\n".repeat(9));
        assertTrue(board.toString().equals("[1, 2, 3, 6, 5, 4, 3, 2, 1]\n".repeat(9)));
    }

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

    @Test
    public void fillFunctionProducesValidBoard() {
        Board board = new Board();
        board.fill(0);
        assertTrue(board.isValid());
    }

    @Test
    public void generatedBoardComplete() {
        Board board = new Board();
        long startTime = System.nanoTime();
        board.fill(0);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
        assertTrue(!board.toString().contains("0"));
    }

    @Test
    public void showRandomly24Cells() {
        Board board = new Board();
        board.fill(0);
        board.initialize();
        Cell[] allCells = Board.flatten(board.getMatrix());
        int countShown = 0;
        for (int i = 0; i < allCells.length; i++) {
            if (allCells[i].isShown()) {
                countShown++;
            }
        }
        assertTrue(countShown == 24);
    }

    @Test
    public void cellKnowsItsCoordinates() {
        Board board = new Board();
        board.fill(0);
        board.initialize();
        Cell someCell = board.getMatrix()[4][5];
        assertTrue(someCell.x() == 5);
        assertTrue(someCell.y() == 4);
    }



    

}