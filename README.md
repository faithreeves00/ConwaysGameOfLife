# ConwaysGameOfLife
This project is a simulation of John Conway’s Game of Life. Conway's simulation begins with an initial configuration of living organisms called the initial generation. This simulation tracks and display the organisms through a specified number of generations. The Game of Life consists of determining the configuration of a series of generations taking place on a rectangular grid where each cell is either empty or occupied by an organism. Whether a cell is occupied in a generation is determined by certain rules related to the occupancy of neighboring cells in the preceding generation. The neighbors of a given cell are the eight cells that border it vertically, horizontally, or diagonally.

The Game of Life rules are:

• If a cell is occupied but has no more than one occupied neighbor, then it is empty in the next generation. • If a cell is occupied and has four or more occupied neighbors, then it is empty in the next generation. • An occupied cell with either two or three occupied neighbors remains occupied in the next generation. • An empty cell is occupied in the next generation if it has exactly three occupied neighbors. • All changes in occupancy take place at the same time, so a cell that will become empty may influence another cell to become occupied.

This program will show how a given initial configuration will change over a series of generations. Each step of the simulation can be displayed (verbose output) or just the first and final generations (silent output).
