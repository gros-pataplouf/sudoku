package view;

import javax.swing.JTextField;

import model.Cell;

public class CellField extends JTextField{
    public CellField(Cell cell) {
        String value = String.valueOf(cell.getDisplayValue());
        setText(value);
        setColumns(1);
        
    }

}
