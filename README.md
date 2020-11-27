# Conway's Game Of Life
This project is a simulation of John Conway’s Game of Life. Conway's simulation begins with an initial configuration of living organisms called the initial generation. This simulation tracks and display the organisms through a specified number of generations. The Game of Life consists of determining the configuration of a series of generations taking place on a rectangular grid where each cell is either empty or occupied by an organism. Whether a cell is occupied in a generation is determined by certain rules related to the occupancy of neighboring cells in the preceding generation. The neighbors of a given cell are the eight cells that border it vertically, horizontally, or diagonally.

The Game of Life rules are:

• If a cell is occupied but has no more than one occupied neighbor, then it is empty in the next generation. 

• If a cell is occupied and has four or more occupied neighbors, then it is empty in the next generation. 

• An occupied cell with either two or three occupied neighbors remains occupied in the next generation.

• An empty cell is occupied in the next generation if it has exactly three occupied neighbors. 

• All changes in occupancy take place at the same time, so a cell that will become empty may influence another cell to become occupied.

# This program will show how a given initial configuration will change over a series of generations.

# Input
The first input line is a single character either v or s, indicating verbose or silent output. The second line will be the number of generations to be simulated. The
following line is a pair of numbers separated by a space defining the dimensions of the rectangular grid as the number of rows, r, and columns, c. The following r lines, one for each row, will contain c characters from the set {0, 1} with no separating white space ('1' is occupied and '0' is empty). The example input below corresponds to the initial configuration on the right.

v
20
10 8
00000001
00001000
00100000
00001100
01001101
01011000
00000000
00010100
01000110
00000000

The number of rows and columns range from two to 20,000. The maximum number of generations is 100.

# Output
The program will display the configuration of the final generation. If the input specifies verbose mode, display each generation; otherwise only the initial (generation #1) and final generation will be shown.
