package model;

import java.util.Arrays;
import java.lang.Math;

public class Board {
    private Cell[][] rows;

    public Board() {
        this.rows = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.rows[i][j] = new Cell(j, i);
            }
        }
    }

    public Cell[][] getMatrix() {
        return this.rows;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.rows.length; i++) {
            output += this.getRowString(i);
            output += "\n";
        }
        return output;
    }

    public String getRowString(int rowNumber) {
        Cell[] row = this.rows[rowNumber];
        String rowToString = Arrays.toString(row);
        String output = rowToString.substring(0, rowToString.length());
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

    public String toStringPublic() {
        System.out.println("public board");
    String output = "";
    for (int i = 0; i < this.rows.length; i++) {
        Cell[] cells = this.rows[i];
        int[] displayValues = new int[9];
        for (int j = 0; j < 9; j++) {
            displayValues[j] = cells[j].getDisplayValue();
        }
        String displayString = Arrays.toString(displayValues);
        output+= displayString;
        output += "\n";
        }
    return output;
    }

    public Cell[] getCol(int colNumber) {
        Cell[][] columns = new Cell[9][9];
        for (int i = 0; i < this.getMatrix().length; i++) {
            for (int j = 0; j < this.getMatrix()[i].length; j++) {
                columns[j][i] = this.getMatrix()[i][j];
            }
        }
        return columns[colNumber];
    }

    public static boolean findTwice(int searched, Cell[] cells) {
        if (searched == 0) {
            return false;
        }
        int valueCount = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getValue() == searched) {
                valueCount++;
            }
        }
        return (valueCount > 1);
    }

    public static boolean find(int searched, Cell[] cells) {
        if (searched == 0) {
            return false;
        }
        int valueCount = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getValue() == searched) {
                valueCount++;
            }
        }
        return (valueCount > 0);
    }

    public boolean isValid() {
        for (int i = 0; i < this.rows.length; i++) {
            for (int j = 0; j < this.rows[i].length; j++) {
                Cell cell = this.rows[i][j];
                if (Board.findTwice(cell.getValue(), this.rows[i])) {
                    return false;
                }
                if (Board.findTwice(cell.getValue(), this.getCol(j))) {
                    return false;
                }
                Cell[][] currentBox = this.getBox(i / 3, j / 3);
                Cell[] flattenedBox = Board.flatten(currentBox);
                if (Board.findTwice(cell.getValue(), flattenedBox)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canInsert(int number, int coordX, int coordY) {
        System.out.println("can insert initial");
        if (Board.find(number, this.rows[coordY])) {
            return false;
        }
        if (Board.find(number, this.getCol(coordX))) {
            return false;
        }
        Cell[][] currentBox = this.getBox(coordX / 3, coordY / 3);
        Cell[] flattenedBox = Board.flatten(currentBox);
        if (Board.find(number, flattenedBox)) {
            return false;
        }
        return true;
    }


    public boolean canInsertPlayer(int number, int coordX, int coordY) {
        System.out.println("can insertPlayer");
        if (Board.find(number, this.rows[coordY])) {
            return false;
        }
        if (Board.find(number, this.getCol(coordX))) {
            return false;
        }
        Cell[][] currentBox = this.getBox(coordX / 3, coordY / 3);
        Cell[] flattenedBox = Board.flatten(currentBox);
        if (Board.find(number, flattenedBox)) {
            return false;
        }
        return true;
    }


    public static Cell[] flatten(Cell[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        Cell[] output = new Cell[height * width];
        int counter = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                output[counter] = matrix[i][j];
                counter++;
            }
        }
        return output;
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
    }

    public static Board loadFromString(String input) {
        Board myBoard = new Board();
        myBoard.load(input);
        return myBoard;
    }

    public void initialize() {
        int shownCounter = 0;
        Cell[] allCells = Board.flatten(this.getMatrix());
        while (shownCounter < 24) {
            int randomInt = (int) (Math.random() * 81);
            if (!allCells[randomInt].isShown()) {
                allCells[randomInt].setShown(true);
                shownCounter++;            
            }
        }
    }

    public void fill(int globalIdx) {
        if (!this.toString().contains("0")) {
            return;
        }
        int y = globalIdx / 9;
        int x = globalIdx % 9;
        Cell currentCell = this.getMatrix()[y][x];
        while (currentCell.getPossibles().size() > 0) {
            int randomIndex = (int) (Math.random() * currentCell.getPossibles().size());
            int randomNr = currentCell.getPossibles().get(randomIndex);
            if (this.canInsert(randomNr, x, y)) {
                currentCell.setValue(randomNr);
                break;
            } else {
                currentCell.removePossible(randomIndex);
            }
        }
        if (globalIdx > 8 && currentCell.getPossibles().isEmpty()) {
            currentCell.reset();
            this.fill(globalIdx - 1);
        } else {
            this.fill(globalIdx + 1);
        }
    }
}
