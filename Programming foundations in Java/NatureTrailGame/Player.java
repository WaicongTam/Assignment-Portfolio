/**
 * Player class specifies the attributes and the behaviours of a player.
 *
 * @author Weicong Tan Charles
 * @version 1.0.0 (23 Mar 2019)
 */
public class Player
{
    private String name;//The name of the player
    private int position;//The current position of the player
    private int score;//The cumulative game score
    
    /**
     * Initialises the object with blank name at the starting position and with no score.
     */
    public Player()
    {
        name = "";
        position = 0;
        score = 0;
    }
    
    /**
     * Allows users to initialise the object with a customerised name.
     * 
     * @param newName The customerised name.
     */
    public Player(String newName)
    {
        name = newName;
        position = 0;
        score = 0;
    }
    
    /**
     * Displays the player's status on the terminal.
     */
    public String displayPlayer()
    {
        String playerState = name + " " + position + " " +score;
        return playerState;
    }
    
    /**
     * Return the name (not the identity) of the object.
     * 
     * @return The name of the object.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the current position of the object.
     * 
     * @return The current position of the object.
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Return the current score of the object.
     * 
     * @return The current score of the object.
     */
    public int getScore()
    {
        return score;
    }
        
    /**
     * Move the object's position foward or backward for certain "step(s)",
     * the player won't be moving backwards if it's currently at 0 position.
     * 
     * @param increment The "step(s)" the user wants the object to move.
     */
    public void movePosition(int increment)
    {
        if ((position + increment) < 0)
            position = 0;
        else
            position += increment;        
    }
    
    /**
     * Allows users to directly change the name of the object, the input will be trimmed first;
     * the name will NOT be set if it's not between 1 to 6 characters long. 
     * 
     * @param newName
     * @return Returns true if the name is legal and was properly set.
     */
    public boolean setName(String newName)
    {
        boolean isSet = false;
        
        newName = newName.trim();
        
        if (newName.length() <= 6 && newName.length() >= 1)
        {
            name = newName;
            isSet = true;
        }
        
        return isSet;
    }
    
    /**
     * Directly set the object to a new position.
     * 
     * @param newPosition The new position of the object
     */
    public void setPosition(int newPosition)
    {
        position = newPosition;
    }
    
    /**
     * Add or deduce the score of the object; if the current score is 0, it won't be deduced.
     * 
     * @param increment The increment/decrement of the score.
     */
    public void setScore(int increment)
    {
        if ((score + increment) >=0)
            score += increment;
        else
            score = 0;
    }
}