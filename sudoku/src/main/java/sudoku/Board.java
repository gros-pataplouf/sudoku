package sudoku;
import java.util.Arrays;

public class Board {
    private Cell[][] rows;
    public Board() {
        this.rows = new Cell[9][9];
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
        Cell[] row1 = Arrays.copyOfRange(this.rows[coordY * 3], coordX, coordX + 3);
        Cell[] row2 = Arrays.copyOfRange(this.rows[coordY * 3 + 1], coordX, coordX + 3);
        Cell[] row3 = Arrays.copyOfRange(this.rows[coordY * 3 + 2], coordX, coordX + 3);
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

    public void fill() {
        for (Cell[] row: this.rows) {
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int i = 0; i < numbers.length; i++) {
                row[i].setValue(numbers[i]);
            }
        }
        System.out.println(this.toString());

        
    }
}
