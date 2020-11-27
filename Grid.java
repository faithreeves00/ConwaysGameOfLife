// File/Class Name: Grid.java
// Author: Faith Reeves
// Class Purpose: To be used with "AmazingLife.java" to create grids, 
//                print grids, set cells to dead or alive, count a cell's
//                alive neighbors, return the status of a cell, and simulate
//                the grid's next generation

package amazinglife;

public class Grid {

    // declare data fields for width, height, and a 2D board array
    int width;
    int height;
    int[][] board;

    // Grid object constructor that takes in a width and height
    public Grid(int width, int height) {

        // update the width datafield to the given width
        this.width = width;

        // update the height datafield to the given height
        this.height = height;

        // assign the board's width and height with the new given values
        this.board = new int[width][height];
    }

    // method used to print the grid
    public void printBoard() {

        // print out a dashed line to go above the grid
        System.out.println("---");

        // execute the for loop according the grid's height
        for (int y = 0; y < height; y++) {

            // begin the String with a line for the grid's left border
            String line = "|";

            // execute the for loop according to the grid's width
            for (int x = 0; x < width; x++) {

                // if the cell is dead/0, execute the if statement
                if (this.board[x][y] == 0) {

                    // add a "." to the line String
                    line += ".";
                } // if the cell if alive/1, execute the else statement
                else {

                    // add a "*" to the line String
                    line += "*";
                }
            }

            // end the String with a line for the grid's right border
            line += "|";

            // print out line/row that was just created
            System.out.println(line);
        }

        // print out a dashed line to go below the grid and then a new line
        System.out.println("---\n");
    }

    // method to set a cell to be alive/1
    public void setAlive(int x, int y) {

        // set the given cell to be alive/1
        this.board[x][y] = 1;
    }

    // method to set a cell to be dead/0
    public void setDead(int x, int y) {

        // set the given cell to be dead/0
        this.board[x][y] = 0;
    }

    // method to count how many alive naighbors a cell has
    public int countAliveNeighbors(int x, int y) {

        // declare and initialize the counter variable to 0
        int count = 0;

        // add 1 to the count variable for each alive neighbor the cell has
        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        // return the total number of alive neighbors
        return count;
    }

    // method to return the state (dead or alive) of a cell
    public int getState(int x, int y) {

        // if x is < 0 or x >= the width, execute the if statement
        if (x < 0 || x >= width) {

            // return that the cell is dead
            return 0;
        }

        // if y is < 0 or y is >= the height, execute the if statement
        if (y < 0 || y >= height) {

            // return that the cell is dead
            return 0;
        }

        // return the value of the cell
        return this.board[x][y];
    }

    // mehtod to generate a new grid generation
    public void step() {

        // create a new board of the same width and height
        int[][] newBoard = new int[width][height];

        // iterate through the for loop according to the grid's height
        for (int y = 0; y < height; y++) {

            // iterate through the for loop according to the grid's width
            for (int x = 0; x < width; x++) {

                // store the number of alive neighbors in a variable
                int aliveNeighbors = countAliveNeighbors(x, y);

                // if the cell is alive, execute the if statement
                if (getState(x, y) == 1) {

                    // if there are less than 2 alive neighbors, execute the
                    // if statement
                    if (aliveNeighbors < 2) {

                        // assign the cell's status to 0 (dead)
                        newBoard[x][y] = 0;
                    } // if there are 2 or 3 alive neighbors, execute the else if
                    // statement
                    else if (aliveNeighbors == 2 || aliveNeighbors == 3) {

                        // assign the cell's status to 1 (alive)
                        newBoard[x][y] = 1;
                    } // if there are more than 3 alive neighbors, execute the 
                    // else if statement
                    else if (aliveNeighbors > 3) {

                        // assign the cell's status to 0 (dead)
                        newBoard[x][y] = 0;
                    }
                } // if the cell is dead, execute the else statement
                else {

                    // if the cell has 3 neighbors, execute the if statement
                    if (aliveNeighbors == 3) {

                        // assign the cell's status to 1 (alive)
                        newBoard[x][y] = 1;
                    }
                }
            }
        }

        // replace the old grid with the new grid
        this.board = newBoard;
    }
}
