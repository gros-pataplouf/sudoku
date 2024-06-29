# sudoku

Brainstorming: 

UI, maybe with swing => class UserInterface 
Game logic: 
  generate a random sudoku board
  class Board (a 2 dimensional array of cells)
  class Cell (int value, int playerGuess (0 if empty), boolean initiallyDisplayed = false)
  
  from random board, create a solvable sudoku grid to the player by selecting displayed cells
  => define solvable => at each step, there is at least one obvious next step (one obvious number to fill in) => obvious => can be deduced logically from current grid 
  => definition of obvious => if the cell is replaced by any other number, the sudoku board is no longer valid
  => write method validSudoku board 

  
  

