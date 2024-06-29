package sudoku;

public class Board {
    private Box[][] boxes;
    public Board() {
        this.boxes = new Box[3][3];
    }

    public Box[][] getBoxes() {
        return this.boxes;
    }
    
}
