import javax.swing.*;
import java.awt.Rectangle;

public class GameTest {
    // main method for testing purposes
    public static void main(String[] args) throws Exception {
        // Getting the dimensions for the window
        int width = getIntInput("What should the width of the field be?");
        int height = getIntInput("What should the height of the field be?");

        // Creating a new game using those dimensions
        WackAMole game1 = new WackAMole(new Rectangle(width, height));
        game1.startGame(); // Start the game

        // View the different objects interacting inside the WackAMole class.
    }

    /**
     * Get a user input and parse as integer
     * @param message The question to ask to the user
     * @return Parsed input
     */
    public static int getIntInput(String message) {
        String input;
        int parsedInput;

        while (true) { // Loop through until told to break
            input = JOptionPane.showInputDialog(message); // Get user input
            try {
                parsedInput = Integer.parseInt(input); // Try to parse as int
                break; // Break out of loop if possible
            } catch(NumberFormatException e) {
                e.printStackTrace(); // Print error if the user input is not numerical
            }
        }

        return parsedInput; // Return the parsed input
    }
}
