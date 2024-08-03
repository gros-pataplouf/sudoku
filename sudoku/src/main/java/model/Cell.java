package model;
import java.util.ArrayList;
import java.util.Arrays;


public class Cell {
    private int value;
    private int guess;
    private boolean isShown;
    private boolean isValid;
    private ArrayList<Integer> possibles;
    private int x;
    private int y;
    public Cell(int x, int y) {
        this.value = 0;
        this.possibles = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.isShown = false;
        this.isValid = true;
        this.x = x;
        this.y = y;
        this.guess = 0;

    }
    public int getValue() {
        return this.value;
    }

    public int x() {
        return this.x;
    }
    public int y() {
        return this.y;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    } 

    public void setValid(boolean newBool) {
        this.isValid = newBool;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void removePossible(int idx) {
        this.possibles.remove(idx);

    }
    public void setGuess(int guess) {
        this.guess = guess;
    }
    public int getGuess() {
        return this.guess;
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
    public void setShown(boolean newValue) {
        this.isShown = newValue;
    }
    public int getDisplayValue() {
        if (this.isShown) {
            return this.value;
        } else {
            return this.guess;
        }
    }
}
