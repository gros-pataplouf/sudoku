package view;

import javax.swing.JTextField;
import model.Cell;

public class CellField extends JTextField {
    private int x;
    private int y;
    public CellField(Cell cell) {
        this.x = cell.x();
        this.y = cell.y();
        String value = String.valueOf(cell.getDisplayValue());
        setText(value);
        setColumns(1);
    }
    public int x() {
        return this.x;
    }
    public int y() {
        return this.y;
    }

}
