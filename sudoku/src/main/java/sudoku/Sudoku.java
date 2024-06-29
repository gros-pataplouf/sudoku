package sudoku;

/**
 * Hello world!
 *
 */
public class Sudoku 
{
    public static void main( String[] args )
    {
        Box box = new Box();
        for(int i = 0; i < box.getCellMatrix().length; i++) {
            System.out.println(box.getCellMatrix()[i]);
            for (int j = 0; j < box.getCellMatrix()[i].length; j++) {
                System.out.println(box.getCellMatrix()[i][j].getValue());
            }
        }
        System.out.println(box.toString());
    }
}
