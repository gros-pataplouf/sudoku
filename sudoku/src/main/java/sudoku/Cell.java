package sudoku;

public class Cell {
    private int value;
    public Cell() {
        this.value = 0;
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
}
