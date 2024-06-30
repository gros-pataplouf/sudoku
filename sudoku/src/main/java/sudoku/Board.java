package sudoku;
import java.util.Arrays;
import java.lang.Math;;

public class Board {
    private Cell[][] rows;
    private History history;
    public Board() {
        this.rows = new Cell[9][9];
        this.history = new History();
        for (Cell[] cellRow: this.rows) {
            for (int i = 0; i < 9; i++) {
                cellRow[i] = new Cell();
            }
        }
    }

    public Cell[][] getRows() {
        return this.rows;
    }


    public String toString() {
        String output = "";
        for (int i = 0; i < this.rows.length; i++) {
            output += this.getRowString(i);
            output+= "\n";
        } 
        return output;
    }

    public String getRowString(int rowNumber) {
        Cell[] row = this.rows[rowNumber];
        String rowToString = Arrays.toString(row);
        String output = rowToString.substring(0,rowToString.length());
        return output;
    }

    public Cell[][] getBox(int coordX, int coordY) {
        Cell[][] box = new Cell[3][3];
        Cell[] row1 = Arrays.copyOfRange(this.rows[coordY * 3], coordX * 3, coordX * 3 + 3);
        Cell[] row2 = Arrays.copyOfRange(this.rows[coordY * 3 + 1], coordX * 3, coordX * 3 + 3);
        Cell[] row3 = Arrays.copyOfRange(this.rows[coordY * 3 + 2], coordX * 3, coordX * 3 + 3);
        box[0] = row1;
        box[1] = row2;
        box[2] = row3;
        return box;
    }





    public String getBoxString(int coordX, int coordY) {
        Cell[][] box = this.getBox(coordX, coordY);
        String output = "";
        for (int i = 0; i < box.length; i++) {
            String rowToString = Arrays.toString(box[i]);
            output += rowToString;
            output+= "\n";
        } 
        return output;
    }

    
    public void fillBox(int coordX, int coordY) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Board.shuffle(nums);
        for (int i = 0; i < nums.length; i++) {
            Cell currentCell = this.rows[coordX*3 + (i % 3)][coordY*3 + (i / 3)];
            currentCell.setValue(nums[i]);
        }
        history.add(this.toString());
    }


    public Cell[][] getCols() {
        Cell[][] columns = new Cell[9][9];
        for (int i = 0; i < this.getRows().length; i++) {
            for (int j = 0; j < this.getRows().length; j++) {
                columns[j][i] = this.getRows()[i][j];
            }
        }
        return columns;
    }

    public Cell[] getCols(int colNumber) {
        Cell[][] columns = new Cell[9][9];
        for (int i = 0; i < this.getRows().length; i++) {
            for (int j = 0; j < this.getRows().length; j++) {
                columns[j][i] = this.getRows()[i][j];
            }
        }
        return columns[colNumber];
    }

    public static boolean findTwice(int searched, Cell[] cells) {
        int valueCount = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getValue() == searched) {
                valueCount++;
            }
        }
        return (valueCount > 1);
    }

    public boolean isValid() {
        for (int i = 0; i < this.rows.length; i++) {
            for (int j = 0; j < this.rows[i].length; j++) {
                Cell cell = this.rows[i][j];
                if (Board.findTwice(cell.getValue(), this.rows[i])){
                    return false;
                }
                if (Board.findTwice(cell.getValue(), this.getCols(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void shuffle(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int randomIndex = (int) ((Math.random() * (input.length - 1)));
            int currentNumber = input[i];
            input[i] = input[randomIndex];
            input[randomIndex] = currentNumber;
        }
    }

    public void load(String input) {
        String[] splitInput = input.split("]\n");
        for (int i = 0; i < splitInput.length; i++) {
            String cleaned = splitInput[i].substring(1, splitInput[i].length());
            String[] splitRow = cleaned.split(", ");
            for (int j = 0; j < splitRow.length; j++) {
                int number = Integer.valueOf(splitRow[j]);
                this.rows[i][j].setValue(number);
            }
        }
        history.add(this.toString());
    }

    public History history() {
        return this.history;
    }

    public void back() {
        this.history.back();
        this.load(this.history.now());
    }
}
