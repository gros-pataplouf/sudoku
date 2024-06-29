package sudoku;


public class Sudoku 
{
    public static void main( String[] args ) {
        Board board = new Board();
        System.out.println(board.toString());
        System.out.println(board.getRowString(0));
    }
}
