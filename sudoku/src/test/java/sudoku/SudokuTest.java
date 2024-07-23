package sudoku;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import model.Board;
import model.Cell;

public class SudokuTest {



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
    public void emptyCellAllNumbersPossible() {
        Cell cell = new Cell();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        assertEquals(cell.getPossibles(), nums);

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
        System.out.println(board.toString());
        assertTrue(countShown == 24);
    }
}