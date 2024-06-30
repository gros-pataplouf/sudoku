package sudoku;

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
    public void boardHasHistory() {
        Board board = new Board();
        board.load("[1, 2, 3, 6, 5, 4, 3, 2, 1]\n".repeat(9));
        assertTrue(board.history().now().equals(board.toString()));
    }
    @Test
    public void canGoBackInHistory() {
        Board board = new Board();
        board.load("[1, 2, 3, 4, 5, 6, 7, 8, 9]\n".repeat(9));
        board.load("[1, 2, 3, 6, 5, 4, 3, 2, 1]\n".repeat(9));
        board.back();
        assertTrue(board.history().now().equals(board.toString()));
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

    // @Test continue later
    // public void boardStaysValidAfterFillingForthBox() {
    //     Board board = new Board();
    //     board.fillBox(0, 0);
    //     board.fillBox(1, 1);
    //     board.fillBox(2, 2);
    //     board.fillBox(2,0, true);
    //     System.out.println(board.toString());
    //     assertTrue(board.isValid());
    // }



    // @Test
    // public void one1perRow() {
    //     Board board = new Board();
    //     board.fill();
    //     boolean isValid = true;
    //     int numOfOnes = 0;
    //     for (int i = 0; i < board.getRows().length; i++) {
    //         if (!isValid) {break;}
    //         numOfOnes = 0;
    //         for (int j = 0; j < board.getRows()[i].length; j++) {
    //             if (board.getRows()[i][j].getValue() == 1) {
    //                 numOfOnes++;
    //                 if (numOfOnes > 1) {
    //                     isValid = false;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     try {
    //         assertTrue(isValid);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    //     ;
    // }

    // @Test
    // public void one1PerColumn() {
    //     Board board = new Board();
    //     board.fill();
    //     int numOfOnes = 0;
    //     boolean isValid = true;

    //     for (int i = 0; i < board.getCols().length; i++) {
    //         numOfOnes = 0;
    //         if (!isValid) {break;}
    //         for (int j = 0; j < board.getCols()[i].length; j++) {
    //             if (board.getCols()[i][j].getValue() == 1) {
    //                 numOfOnes++;
    //                 if (numOfOnes > 1) {
    //                     isValid = false;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     try {
    //         assertTrue(isValid);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    //     ;
    // }


}