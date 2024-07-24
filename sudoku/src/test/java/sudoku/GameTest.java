package sudoku;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Game;

public class GameTest {

    @Test
    public void gameHasValidBoard() {
        Game game = new Game();
        assertTrue(game.board().isValid());

        
    }

}
