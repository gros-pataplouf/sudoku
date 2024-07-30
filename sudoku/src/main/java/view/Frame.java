package view;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import model.Game;
import model.Board;
import model.Cell;



public class Frame extends JFrame {
    GridLayout grid = new GridLayout(9, 9);
    Frame() {
        setTitle("Sukoku");
        setSize(540, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createGrid(int rows, int cols) {
        JPanel panel = new JPanel(new GridLayout(rows, cols));
        Game game = new Game();
        Board board = game.board();
        board.fill(0);
        board.initialize();
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
                int topThickness = i == 0 ? 3 : 1;
                int leftThickness =  j % 3 == 0 ? 3 : 1;
                int bottomThickness = (i + 1) % 3 == 0 ? 3 : 1;
                int rightThickness = j == 8 ? 3 : 1;
                cellField.setBorder(BorderFactory.createMatteBorder(topThickness, leftThickness, bottomThickness, rightThickness, Color.BLACK));
                panel.add(cellField);
            }
        }

        this.add(panel);
    }

      public static void main(String argvs[]) {
        Frame frame = new Frame();
        frame.createGrid(9, 9);
        frame.setVisible(true);
    }
}