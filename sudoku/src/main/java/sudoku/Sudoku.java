package sudoku;


public class Sudoku 
{
    public static void main( String[] args ) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Board.shuffle(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
