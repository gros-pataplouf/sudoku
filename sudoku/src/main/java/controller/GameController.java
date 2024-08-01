package controller;

import model.Board;
import model.Game;
import view.UI;



public class GameController {
    private Game game;
    private UI ui;

    public GameController() {
        this.game = new Game();
        this.ui = new UI(this);
       
    }
    public void start() {
        Board board = this.game.board();
        board.fill(0);
        board.initialize();
        this.ui.createGrid(9, 9, board);
    }
    public void guess(int guess, int x, int y) {
        this.game.guess(guess, x, y);

    }

}
