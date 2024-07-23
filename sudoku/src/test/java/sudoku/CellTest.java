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
        Cell cell = new Cell();
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
        Cell cell = new Cell();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        assertEquals(cell.getPossibles(), nums);
    }

}
