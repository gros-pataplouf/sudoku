package sudoku;
import java.util.ArrayList;
import java.util.Arrays;


public class Cell {
    private int value;
    private ArrayList<Integer> possibles;
    private ArrayList<Integer> tried;
    public Cell() {
        this.value = 0;
        this.possibles = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.tried = new ArrayList<>();
    }
    public int getValue() {
        return this.value;
    }

    public void removePossible(int idx) {
        this.possibles.remove(idx);

    }

    public void addTried(int number) {
        this.tried.add(number);
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public ArrayList<Integer> getTried() {
        return this.tried;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }
    public ArrayList<Integer> getPossibles() {
        return this.possibles;
    }
}
