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
                game.guess(cellIdx%9, cellIdx/9, 5);
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
        game.guess(cellIdx%9, cellIdx/9, 3);
        assertTrue(myCell.getGuess() == 3);
    }

    @Test
    public void displayStateOfBoardToPlayer() {
        Game game = new Game();
        Board board = game.board();
        Cell[] allCells = Board.flatten(board.getMatrix());
        Cell someCell = allCells[7];
        someCell.setShown(false);
        game.guess(7, 0, 33);
        assertTrue(board.toStringPublic().contains("33"));
    }

    @Test
    public void conflictingGuessCellMarkedAdInvalid(){
        Game game = new Game();
        Board board = game.board();
        Cell[] allCells = Board.flatten(board.getMatrix());
        Cell someCell = allCells[7];
        someCell.setShown(false);
        if (someCell.getValue() == 5 ) {
            game.guess(7, 0, 6);
        } else {
            game.guess(7, 0, 5);
        }
        assertTrue(!someCell.isValid());

    }


}
