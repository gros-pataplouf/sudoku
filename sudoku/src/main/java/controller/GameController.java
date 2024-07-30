package controller;

import model.Board;
import model.Game;
import view.UI;



public class GameController {
    public static void main(String[] args) {
        Game game = new Game();
        Board board = game.board();
        board.fill(0);
        board.initialize();
        UI ui = new UI();
        ui.createGrid(9, 9, board);
    }

}
