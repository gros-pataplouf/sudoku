# SUDOKU GENERATOR - WORK IN PROGRESS - Developing with TDD.

This project implements a Sudoku board and provides various methods for manipulating and validating the board.
- checking the validity of any given board. 
- generating a fresh valid Sudoku board.
- checking whether a board is solvable.

## Features

- Create an empty 9x9 Sudoku board
- Validate the board for correctness
- Generate a valid Sudoku board

### Board

The main class that represents a Sudoku board. It contains the following methods:

- `isValid()`: Check if the current board state is valid
- `fill(int globalIdx)`: Recursively fill the board with valid numbers by backtracking.


## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven

### Running the Project with Maven

