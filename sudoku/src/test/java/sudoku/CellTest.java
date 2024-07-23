package sudoku;

import static org.junit.Assert.assertTrue;

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
}
