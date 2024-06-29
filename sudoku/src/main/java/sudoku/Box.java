package sudoku;
import java.util.Arrays;


public class Box {
    private Cell[][] cellMatrix;
    public Box() {
        Cell[] cells = new Cell[9];
        for (int i = 0; i < 9; i++) {
            Cell newCell = new Cell(i+1);
            cells[i] = newCell;

        }
        Cell[][] cellMatrix = new Cell[3][3];
        cellMatrix[0] = Arrays.copyOfRange(cells, 0,3);
        cellMatrix[1] = Arrays.copyOfRange(cells, 3,6);
        cellMatrix[2] = Arrays.copyOfRange(cells, 6,9);
        this.cellMatrix = cellMatrix;
    }


    public Cell[] getRow(int index) {
        return this.cellMatrix[index];       
    }
    public String toString() {
        String output = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                output += "|"+ this.cellMatrix[i][j].getValue();

            }
            output += "|\n";
        }
        return output;
    }

    public Cell[][] getCellMatrix() {
        return this.cellMatrix;
    }

    
}
