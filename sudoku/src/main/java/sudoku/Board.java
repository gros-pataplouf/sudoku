package sudoku;
import java.util.Arrays;

public class Board {
    private Cell[][] cells;
    public Board() {
        this.cells = new Cell[9][9];
        for (Cell[] cellRow: this.cells) {
            for (int i = 0; i < 9; i++) {
                cellRow[i] = new Cell();
            }
        }
    }

    public Cell[] getRow(int rowNumber) {
        return this.cells[rowNumber / 9];
    }


    public String toString() {
        String output = "";
        for (int i = 0; i < this.cells.length; i++) {
            output += this.getRowString(i);

            output+= "\n";
        } 
        return output;
    }

    public String getRowString(int rowNumber) {
        Cell[] row = this.cells[rowNumber];
        String rowToString = Arrays.toString(row);
        String output = rowToString.substring(0,rowToString.length()); // cut off the last comma
        return output;
    }
}
