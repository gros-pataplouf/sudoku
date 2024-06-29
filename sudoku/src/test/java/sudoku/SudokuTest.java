package sudoku;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class SudokuTest
{

    @Test
    public void cellHasDefaultValue()
    {
        Cell cell = new Cell();
        assertTrue(cell.getValue() == 0);
    }

    @Test
    public void rowHas9Cells() {
        Board board = new Board();
        String firstRow = board.getRowString(0);
        System.out.println(firstRow);
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
    public void one1perRow() {
        Board board = new Board();
        board.fill();
        boolean isValid = true;
        int numOfOnes = 0;
        for (int i = 0; i <= board.getRows().length; i++) {
            // check what happened in the previous loop
            if (numOfOnes > 1) {
                isValid = false;
                break;
            }
            if (i > 0 && numOfOnes < 1) {
                isValid = false;
                break;
            }
            if (i == board.getRows().length) {
                break;
            }
            numOfOnes = 0;

            for (int j = 0; j < board.getRows()[i].length; j++) {
                if (board.getRows()[i][j].getValue() == 1) {
                    numOfOnes++;
                }
            }
        }
        try {assertTrue(isValid);} catch(Exception e) {
            System.out.println(e.getMessage());
        };
    }


}