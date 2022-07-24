/**
 * BotPlayer class used to obtain input from bot
 * @author Henry Prosser
 */

// BotPlayer class that inherits Player class
public class BotPlayer extends Player {

    /**
     * Constructor
     * @param name
     *       Player name
     * @param counter
     *       Player counter    
     */
    public BotPlayer(String name, char counter) {
        super(name, counter);
    }

    /**
     * Method for obtaining bot input
     * @return Column number
     */
    public String getUserInput() {
        // Generates a random integer between 1 and 7 
        int col = (int)(Math.random() * 7) + 1;
        String userInput = "" + col;
        return userInput;
    }
}
