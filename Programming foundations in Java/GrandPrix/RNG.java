/**
 * A random number generator, an improvement from the previous Dice class of Assignment 1.
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (4-May-2019)
 */
public class RNG
{
    private int maximumValue;
    private int minimumValue;
    
    /**
     * Initialises the object with minimum value of 1 and maximum value of 4.
     */
    public RNG()
    {
        maximumValue = 4;
        minimumValue = 1;
    }
    
    /**
     * Allows user to customises maximum and minimum value while initialising an object.
     * 
     * @param newMaximumValue The new maximum value.
     * @param newMinimumValue The new minimum value.
     */
    public RNG(int newMaximumValue, int newMinimumValue)
    {
        maximumValue = newMaximumValue;
        minimumValue = newMinimumValue;
    }
    
    /**
     * Generates a random between the minimum and the maximum value with both sides inclusively.
     * 
     * @return The random number generated.
     */
    public int generateRandomInteger()
    {
        int random = 0;
                
        random = minimumValue + (int)(Math.random() * (maximumValue - minimumValue + 1));
        
        return random;
    }
    
    /**
     * The accessor of the maximumValue.
     * 
     * @return The maximum value of the dice.
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    /**
     * The accessor of the minimumValue.
     * 
     * @return The minimum value of the dice.
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    /**
     * Allows user to assign a new maximum value.
     * 
     * @param newMaximumValue The new maximum value.
     * @return If the new maximum value has been successfully set, return true.
     */
    public boolean setMaximumValue(int newMaximumValue)
    {
        if (validMaximumValue(newMaximumValue))
        {
            maximumValue = newMaximumValue;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Allows user to assign a new minimum value.
     * 
     * @param newMinimumValue The new minimum value.
     * @return If the new minimum value has been successfully set, return true.
     */
    public boolean setMinimumValue(int newMinimumValue)
    {
        if (validMinimumValue(newMinimumValue))
        {
            minimumValue = newMinimumValue;
            return true;
        }
        else
            return false;
    }
    
    private boolean validMaximumValue(int newMaximumValue)
    {
        return (newMaximumValue > minimumValue ? true : false);
    }
    
    private boolean validMinimumValue(int newMinimumValue)
    {
        return (newMinimumValue < maximumValue ? true : false);
    }
}