package sudoku;
import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    private int value;
    private ArrayList<Integer> possibles;
    public Cell() {
        this.value = 0;
        this.possibles = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
    public int getValue() {
        return this.value;
    }
    public String toString() {
        return String.valueOf(this.value);
    }
    public void setValue(int newValue) {
        this.value = newValue;
    }
    public ArrayList<Integer> getPossibles() {
        return this.possibles;
    }
}
