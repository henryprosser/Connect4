/**
 * Player class used to define characteristics of players
 * @author Henry Prosser
 */

// Abstract class
public abstract class Player {

    // Instance fields
    protected String name;
    protected char counter;

    /**
     * Constructor
     * @param name
     *       Player name
     * @param counter
     *       Player counter     
     */
    public Player(String name, char counter) {
        this.name = name;
        this.counter = counter;
    }

    /**
     * Accessor method
     * 
     * @return Name of player 
     */
    public String getPlayerName() {
        return this.name;
    }

    /**
     * Accessor method
     * 
     * @return Player counter 
     */
    public char getPlayerCounter() {
        return this.counter;
    }

    // Abstract method used to be inherited
    public abstract String getUserInput();

}