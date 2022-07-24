import java.io.*;

/**
 * Player class used to obtain input from human
 * @author Henry Prosser
 */

// HumanPlayer class that inherits Player class
public class HumanPlayer extends Player {

    // Instance fields
    private BufferedReader input;

    /**
     * Constructor
     * @param name
     *       Player name
     * @param counter
     *       Player counter      
     */
    public HumanPlayer(String name, char counter) {
        super(name, counter);
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Method for obtaining human input
     * @return Column number
     */
    public String getUserInput() {
        String toReturn = "";
        try{
            toReturn = input.readLine();
        }
        catch(IOException e){
            System.out.println(e);
        }
        return toReturn;
    }

}