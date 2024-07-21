package sudoku;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SudokuTest {

    @Test
    public void cellHasDefaultValue() {
        Cell cell = new Cell();
        assertTrue(cell.getValue() == 0);
    }

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
    public void boardCanPrintBox() {
        Board board = new Board();
        String boxString = board.getBoxString(1, 1);
        assertTrue(boxString.equals("[0, 0, 0]\n".repeat(3)));
    }

    @Test
    public void canLoadBoardFromString() {
        Board board = new Board();
        board.load("[1, 2, 3, 6, 5, 4, 3, 2, 1]\n".repeat(9));
        assertTrue(board.toString().equals("[1, 2, 3, 6, 5, 4, 3, 2, 1]\n".repeat(9)));

    }

    @Test
    public void fillDiagonalBoxesRandomly() {
        Board board = new Board();
        board.load("[0, 0, 0, 0, 0, 0, 0, 0, 0]\n".repeat(9));
        board.fillBox(0, 0);
        board.fillBox(1, 1);
        board.fillBox(2, 2);
        String firstBox = board.getBoxString(0, 0);
        String secondBox = board.getBoxString(1, 1);
        String thirdBox = board.getBoxString(2, 2);

        for (int i = 1; i <= 9; i++) {
            assertTrue(firstBox.contains(String.valueOf(i)));
            assertTrue(secondBox.contains(String.valueOf(i)));
            assertTrue(thirdBox.contains(String.valueOf(i)));
        }
    }

    @Test
    public void invalidBoardTwoSameInRow() {
        Board board = new Board();
        board.load("[2, 3, 4, 1, 8, 5, 6, 7, 4]\n"+"[0, 0, 0, 0, 0, 0, 0, 0, 0]\n".repeat(8));
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
        + "[9, 1, 2, 3, 4, 5, 6, 7, 8]\n"
        );
        assertTrue(!board.isValid());
    }

    @Test
    public void emptyCellAllNumbersPossible() {
        Cell cell = new Cell();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        assertEquals(cell.getPossibles(),nums);
    
    }

    @Test
    public void cellStartsWithNoTriedNums() {
        Cell cell = new Cell();
        assertEquals(cell.getTried(),new ArrayList<>());
    
    }
    @Test
    public void fillFunctionProducesValidBoard(){
        Board board = new Board();
        board.fill();
        System.out.println(board.toString());
        assertTrue(board.isValid());
    }


}