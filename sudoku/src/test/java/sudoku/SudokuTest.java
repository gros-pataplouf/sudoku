package sudoku;

import java.util.HashMap;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class SudokuTest
{

    @Test
    public void CellHasValue()
    {
        Cell cell = new Cell(2);

        assertTrue(cell.getValue() == 2);
    }

    @Test
    public void BoxRowThreeCells() {
        Box box = new Box();
        Cell[] boxRow1 = box.getRow(0);
        Cell[] boxRow2 = box.getRow(1);
        Cell[] boxRow3 = box.getRow(2);
        assertTrue(boxRow1.length == 3); 
        assertTrue(boxRow2.length == 3); 
        assertTrue(boxRow3.length == 3); 

    }
    @Test
    public void BoardHas3Rows() {
        Board board = new Board();
        assertTrue(board.getBoxes().length == 3);

    }


}