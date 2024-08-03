package sudoku;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Board;
import model.Cell;
import model.Game;

public class GameTest {

    @Test
    public void gameHasValidBoard() {
        Game game = new Game();
        assertTrue(game.board().isValid());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotGuessNumberForShownField() {
        Game game = new Game();
        Board board = game.board();
        Cell[] allCells = Board.flatten(board.getMatrix());
        int cellIdx = 0;
        for (int i = 0; i < 81; i++) {
            if (allCells[i].isShown()) {
                cellIdx = i;
                game.guess(5, cellIdx%9, cellIdx/9);
                break;
            }
            
        }
    }

    @Test
    public void guessingHiddenCellSetsGuessValue() {
        Game game = new Game();
        Board board = game.board();
        Cell[] allCells = Board.flatten(board.getMatrix());
        int cellIdx = 0;
        for (int i = 0; i < 81; i++) {
            if (!allCells[i].isShown()) {
                cellIdx = i;
                break;
            }
        }
        Cell myCell = allCells[cellIdx];
        game.guess(3, cellIdx%9, cellIdx/9);
        assertTrue(myCell.getGuess() == 3);
    }

    @Test
    public void displayStateOfBoardToPlayer() {
        Game game = new Game();
        Board board = game.board();
        Cell[] allCells = Board.flatten(board.getMatrix());
        Cell someCell = allCells[7];
        someCell.setShown(false);
        game.guess(33, 7, 0);
        assertTrue(board.toString(true).contains("33"));
    }


}
