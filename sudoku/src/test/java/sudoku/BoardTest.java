package sudoku;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
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

}