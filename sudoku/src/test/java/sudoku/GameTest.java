package sudoku;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Game;
import model.Board;
import model.Cell;

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
    // @Test
    // public void guessingHiddenCellSetsGuessValue() {
    //     Game game = new Game();
    //     Board board = game.board();
    //     Cell[] allCells = Board.flatten(board.getMatrix());
    //     int cellIdx = 0;
    //     for (int i = 0; i < 81; i++) {
    //         if (allCells[i].isShown()) {
    //             cellIdx = i;
    //             game.guess(cellIdx%9, cellIdx/9, 5);
    //             break;
    //         }
    //     }
    

    // }


}
