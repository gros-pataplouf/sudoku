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
        String output = rowToString.substring(0,rowToString.length());
        return output;
    }

    public Cell[][] getBox(int coordX, int coordY) { //boxes are numbered starting with 0, from left to right, and from top to bottom
        Cell[][] box = new Cell[3][3];
        Cell[] row1 = Arrays.copyOfRange(this.cells[coordY * 3], coordX, coordX+3);
        Cell[] row2 = Arrays.copyOfRange(this.cells[coordY * 3 + 1], coordX, coordX+3);
        Cell[] row3 = Arrays.copyOfRange(this.cells[coordY * 3 + 2], coordX, coordX+3);
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
}
