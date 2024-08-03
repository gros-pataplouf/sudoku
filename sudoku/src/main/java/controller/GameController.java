package controller;

import model.Board;
import model.Game;
import view.UI;



public class GameController {
    private Game game;
    private UI ui;

    public GameController() {
        this.game = new Game();
       
    }
    public void start() {
        Board board = this.game.board();
        board.fill(0);
        board.initialize();
        this.ui = new UI(this);
        this.ui.createGrid(9, 9, board);
    }
    public boolean guess(int guess, int x, int y) {
        System.out.println("controller guess player");
        return this.game.guessPlayer(x, y, guess);
    }
    public void test(String input) {
        System.out.println(input);
    }
}
