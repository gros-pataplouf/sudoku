package sudoku;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

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
    }

    public void fillBox(int coordX, int coordY, boolean check) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Board.shuffle(nums);

        for (int i = 0; i < 9; i++) {
            int cellCoordX = coordX*3 + (i % 3);
            int cellCoordY = coordY*3 + (i / 3);
            Cell currentCell = this.rows[cellCoordY][cellCoordX];
            int loopCounter = 0;
            while (nums.size() > 0) {
                if (this.canInsert(nums.get(loopCounter), cellCoordX, cellCoordY)) {
                    currentCell.setValue(nums.get(loopCounter));
                    System.out.println("inserted " + nums + " " +  nums.get(loopCounter)  + " " +  loopCounter + " at " + cellCoordX + cellCoordY);
                    System.out.println(this.toString());
                    nums.remove(loopCounter);
                    break;
                } else {
                    System.out.println("cannot insert " + nums + " " +  nums.get(loopCounter)  + " " +  loopCounter + "at " + cellCoordX + cellCoordY);
                    loopCounter++;
                }
            }

        }
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
            for (int j = 0; j < this.getRows()[i].length; j++) {
                columns[j][i] = this.getRows()[i][j];
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
                if (Board.findTwice(cell.getValue(), this.rows[i])){
                    return false;
                }
                if (Board.findTwice(cell.getValue(), this.getCols(j))){
                    return false;
                }
                Cell[][] currentBox = this.getBox(i / 3, j / 3);
                Cell[] flattenedBox = Board.flatten(currentBox);
                if (Board.findTwice(cell.getValue(), flattenedBox)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canInsert(int number, int coordX, int coordY) {
        if (Board.find(number, this.rows[coordY])) {
            return false;
        }
        if (Board.find(number, this.getCols(coordX))) {
            return false;
        }
        Cell[][] currentBox = this.getBox(coordX/3,  coordY/3);
        Cell[] flattenedBox = Board.flatten(currentBox);
        if (Board.find(number, flattenedBox)) {
            return false;
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

    public static void shuffle(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int randomIndex = (int) ((Math.random() * (input.size() - 1)));
            int currentNumber = input.get(i);
            input.set(i, input.get(randomIndex));
            input.set(randomIndex, currentNumber);
        }
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

    public void fill() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cell currentCell = this.getRows()[i][j];

                int randomIndex = (int) (Math.random() * currentCell.getPossibles().size());
                int randomNr = currentCell.getPossibles().get(randomIndex);
                if (this.canInsert(randomNr, j, i)) {
                    this.getRows()[i][j].setValue(randomNr);
                }
                currentCell.removePossible(randomIndex);
                currentCell.addTried(randomNr);
            }
        }
    }



}
