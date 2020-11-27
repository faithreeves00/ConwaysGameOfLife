// File Name: AmazingLife.java
// Author: Faith Reeves
// Program Purpose: Allows the user to create their own grid and simulate
//                  Conway's "Game of Life"

package amazinglife;

import java.util.*;

public class AmazingLife {
    
    public static void main(String[] args) {

        // variable for users output format
        String outputForm;

        // variable for number of generations to be simulated
        int generations;

        // variable for the number of rows and cols the user wants
        String rowColAnswer;

        // variable for number of rows in grid
        int rows;
        int columns;

        // create a Scanner to read in the user's input
        Scanner input = new Scanner(System.in);

        // prompt the user to choose an output format
        System.out.print("Enter \"v\" for verbose output or \"s\" for silent "
                + "output: ");

        // store the user's answer
        outputForm = input.next();

        // get rid of any accidental whitespace or capitalization
        outputForm = outputForm.trim().toLowerCase();

        // if the user does not enter "v" or "s", execute if statement
        if (!"v".equals(outputForm) && !"s".equals(outputForm)) {

            // output error message
            System.out.println("You did not enter a \"v\" or an \"s\". Exiting "
                    + "Program.");

            // exit program
            System.exit(1);
        }

        // prompt the user for how many generations they want simulated
        System.out.print("How many generations would you like to be simulated?: ");

        // begining of try block
        try {

            // store the user's answer
            generations = input.nextInt();

            // if the user requests to simulate over 100 generations, execute if 
            // statement
            if (generations > 100) {

                // tell the user the issue and that you are exiting the program
                System.out.println("You may not simulate more than 100 generations. "
                        + "Exiting Program.");

                // exit the program
                System.exit(2);
            }

            // read the leftover new line
            input.nextLine();

            // prompt the user for the number of rows and columns in their grid
            System.out.print("Enter the number of rows and number of columns"
                    + " for your grid seperated by a space: ");

            // store the user's answer ISSUE
            rowColAnswer = input.nextLine();

            // trim off any excess whitespace
            rowColAnswer = rowColAnswer.trim();

            // split the string at the space and store in an array
            String[] stringArray = rowColAnswer.split("\\s+");

            // convert element 0 of stringArray to an int and store in rows var
            rows = Integer.parseInt(stringArray[0]);

            // convert element 1 of stringArray to an int and store in columns var
            columns = Integer.parseInt(stringArray[1]);
            
            // if the user's number of rows is not 2 - 20,000
            if (rows < 2 || rows > 20000) {
                
                // output error message
                System.out.println("Number of rows must be from 2 - 20,000. "
                        + "Exiting program.");
                
                // exit program
                System.exit(7);   
            }
            
            // if the user's number of columns is not 2 - 20,000
            if (columns < 2 || columns > 20000) {
                
                // output error message
                System.out.println("Number of columns must be from 2 - 20,000. "
                        + "Exiting program.");
                
                // exit program
                System.exit(8);   
            }

            // create a Grid object with the given row and column sizes
            Grid myGrid = new Grid(columns, rows);

            // interate through the for loop according to the number of rows given
            for (int i = 0; i < rows; i++) {

                // prompt user to enter a row of numbers
                System.out.println("Enter " + columns + " 1's or 0's with no spaces in between: ");

                // store the users input
                String rowAnswer = input.nextLine();

                // get rid of any extra white space on the ends
                rowAnswer = rowAnswer.trim();

                // interate through the for loop according to the number of 
                // columns given
                for (int j = 0; j < columns; j++) {

                    // read in and store the user's input
                    char element = rowAnswer.charAt(j);

                    // convert input to an int
                    int intElement = Character.getNumericValue(element);

                    // if the user entered a 1, execute the if statement
                    if (intElement == 1) {

                        // make the appropriate cell "alive"
                        myGrid.setAlive(j, i);
                    }
                }
            }

            // execute the verbose if statement if the user entered a "v"
            // and print each generation
            if ("v".equals(outputForm)) {

                // execute the for loop according to the number of generations the
                // user requested to simulate
                for (int i = 0; i < generations; i++) {

                    // output the generation number of the next grid
                    System.out.println("Generation " + (i + 1));

                    // print the new grid
                    myGrid.printBoard();

                    // simlate a new grid
                    myGrid.step();
                }
            }

            // execute the silent if statement if the user entered an "s" 
            // and print only the last generation
            if ("s".equals(outputForm)) {

                // output the message for the first/initial generation
                System.out.println("Generation 1");

                // print the initial grid
                myGrid.printBoard();

                // execute the for loop according to the number of generations the
                // user requested to simulate
                for (int j = 0; j < generations; j++) {

                    // if the counter is equal to one less than the number of 
                    // generations, execute the if statement
                    if (j == (generations - 1)) {

                        // output the generation number of the next grid
                        System.out.println("Generation " + (j + 1));

                        // print the new grid
                        myGrid.printBoard();
                    }

                    // simulate a new grid
                    myGrid.step();
                }
            }

        } // end of try block
        
        // if the user entered only 1 character, catch exception
        catch (ArrayIndexOutOfBoundsException ex) {

            // output error message
            System.out.println("You only entered one character. Exiting Program.");

            // exit program
            System.exit(3);
        } 

        // if the user does not enter an int, catch exception
        catch (NumberFormatException ex) {

            // output error message
            System.out.println("You did not enter an Integer. Exiting Program.");

            // exit program
            System.exit(4);
        } 
        
        // if the user enters something of the incorrect data type, catch exception
        catch (InputMismatchException ex) {

            // ouput error message
            System.out.println("You did not enter a valid input. Exiting Program.");

            // exit program
            System.exit(5);
        } 

        // if the users input was too short, catch exception
        catch (StringIndexOutOfBoundsException ex) {

            // output error message
            System.out.println("You did not enter the correct number of characters."
                    + " Exiting Program.");

            // exit program
            System.exit(6);
        }
    }
}
