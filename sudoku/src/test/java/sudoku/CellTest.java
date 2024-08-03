package sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import model.Board;
import model.Cell;

public class CellTest {
    @Test
    public void cellHasDefaultValue() {
        Cell cell = new Cell(1, 1);
        assertTrue(cell.getValue() == 0);
    }

    @Test
    public void cellHiddenWhenGenerated() {
        Board board = new Board();
        board.fill(0);
        Cell[] allCells = Board.flatten(board.getMatrix());
        for (int i = 0; i < allCells.length; i++) {
            assertTrue(!allCells[i].isShown());
        }
    }

    @Test
    public void emptyCellAllNumbersPossible() {
        Cell cell = new Cell(1, 1);
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        assertEquals(cell.getPossibles(), nums);
    }

    @Test
    public void cellCanHaveGuess() {
        int myGuess = 3;
        Cell cell = new Cell(1, 1);
        cell.setGuess(myGuess);
        assertTrue(cell.getGuess() == myGuess);
    }

    @Test
    public void hiddenCellDisplaysGuessNotValue() {
        int myGuess = 3;
        Cell cell = new Cell(1, 1);
        cell.setValue(5);
        cell.setShown(false);
        cell.setGuess(myGuess);
        assertTrue(cell.getDisplayValue() == 3);
    }

    @Test
    public void shownCellDisplaysValueNotGuess() {
        int myGuess = 3;
        Cell cell = new Cell(1, 1);
        cell.setValue(5);
        cell.setShown(true);
        cell.setGuess(myGuess);
        assertTrue(cell.getDisplayValue() == 5);
    }
}
