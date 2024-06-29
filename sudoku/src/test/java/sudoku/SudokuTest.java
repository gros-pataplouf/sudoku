package sudoku;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class SudokuTest
{

    @Test
    public void CellHasDefaultValue()
    {
        Cell cell = new Cell();
        assertTrue(cell.getValue() == 0);
    }

    @Test
    public void RowHas9Cells() {
        Board board = new Board();
        String firstRow = board.getRowString(0);
        System.out.println(firstRow);
        assertTrue(firstRow.toString().equals("[0, 0, 0, 0, 0, 0, 0, 0, 0]"));
    }

}