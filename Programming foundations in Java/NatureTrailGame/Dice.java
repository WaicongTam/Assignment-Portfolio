/**
 * The Dice class generates a random number from minimum value to a maximum value.
 *
 * @author Weicong Tan Charles
 * @version 1.0.0 (23 Mar 2019)
 */
public class Dice
{
    private int maximumValue;//Maximum value of the Dice
    private int minimumValue;//Minimum value of the Dice
    
    /**
     * Initialises the object with minimum value of 1 and maximum value of 4.
     */
    public Dice()
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
    public Dice(int newMaximumValue, int newMinimumValue)
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
     * @param newMaximumValue
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }
    
    /**
     * Allows user to assign a new miniimum value.
     * 
     * @param newMaximumValue
     */
    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }
}