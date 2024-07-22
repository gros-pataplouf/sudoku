package sudoku;
import java.util.ArrayList;
import java.util.Arrays;


public class Cell {
    private int value;
    private boolean isShown;
    private ArrayList<Integer> possibles;
    public Cell() {
        this.value = 0;
        this.possibles = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.isShown = false;
    }
    public int getValue() {
        return this.value;
    }

    public void removePossible(int idx) {
        this.possibles.remove(idx);

    }

    public void reset() {
        this.possibles = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));;
        this.value = 0;
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
    public boolean isShown() {
        return this.isShown;
    }
}
