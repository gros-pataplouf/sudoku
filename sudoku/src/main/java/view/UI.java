package view;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import controller.GameController;
import model.Board;
import model.Cell;



public class UI extends JFrame {
    GridLayout grid = new GridLayout(9, 9);
    private GameController gameController;
    public UI(GameController controller) {
        this.gameController = controller;

        setTitle("Sukoku");
        setSize(540, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void createGrid(int rows, int cols, Board board) {
        JPanel panel = new JPanel(new GridLayout(rows, cols));
        System.out.println(board.toStringPublic());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell currentCell = board.getMatrix()[i][j];
                String displayValue = String.valueOf(currentCell.getDisplayValue());
                if (displayValue.equals("0")) {
                    displayValue = "";
                }
                JTextField cellField = new JTextField(displayValue);
                cellField.setFont(new Font("Sans Serif",Font.BOLD,30));
                cellField.setDisabledTextColor(Color.BLACK);
                cellField.setForeground(Color.BLUE);
                cellField.setHorizontalAlignment(JTextField.CENTER);
                if (currentCell.isShown()) {
                    cellField.setEnabled(false);
                }

                cellField.addKeyListener(new KeyListener() {
                    public void keyTyped(KeyEvent e) {
                        e.consume();
                        try {
                            int guess = Integer.valueOf(String.valueOf(e.getKeyChar()));
                            System.out.println("guessing " + currentCell.x() + " " + currentCell.y());
                            cellField.setText(String.valueOf(guess));
                            gameController.test("input testing");
                            System.out.println(gameController);
                            boolean goodGuess = gameController.guess(guess, currentCell.x(), currentCell.y());
                            if (!goodGuess) {
                                System.out.println("bad guess");
                                cellField.setForeground(Color.RED);
                            } else {cellField.setForeground(Color.GREEN);};
                        } catch (Exception exc) {
                            System.out.println(exc);
                        }                    }
                    public void keyPressed(KeyEvent e) {
                    }
                    public void keyReleased(KeyEvent e) {
                    }
                } );
                int topThickness = i == 0 ? 3 : 1;
                int leftThickness =  j % 3 == 0 ? 3 : 1;
                int bottomThickness = (i + 1) % 3 == 0 ? 3 : 1;
                int rightThickness = j == 8 ? 3 : 1;
                cellField.setBorder(BorderFactory.createMatteBorder(topThickness, leftThickness, bottomThickness, rightThickness, Color.BLACK));
                panel.add(cellField);
            }
        }

        this.add(panel);
        this.setVisible(true);
    }

}