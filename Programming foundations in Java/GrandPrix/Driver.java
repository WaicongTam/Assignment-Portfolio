/**
 * The Driver class prescribes the attributes of a driver
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (3-May-2019)
 */
public class Driver
{
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulatedScore;
    private int accumulatedTime;
    private String tyre;
    
    /**
     * Initialises a default Driver object.
     */
    public Driver()
    {
        name = "Default Driver";
        ranking = 1;
        specialSkill = "Default Skill";
        eligibleToRace = true;
        accumulatedScore = 0;
        accumulatedTime = 0;
        tyre = "Dry";
    }
    
    /**
     * Initialises a Driver object with customised values.
     * 
     * @param newName The customised name.
     * @param newRanking The new ranking.
     * @param newSpecialSkill The new special skill.
     * @param newEligibleToRace The new eligibility of the driver.
     * @param newAccumulatedScore The new accumulated score.
     * @param newAccumulatedTime The new accumulated time.
     */
    public Driver(String newName, int newRanking, String newSpecialSkill, boolean newEligibleToRace, int newAccumulatedScore, int newAccumulatedTime, String newTyre)
    {
        try    
        {
            validName(newName);
            name = newName;
            
            validRanking(newRanking);
            ranking = newRanking;
            
            validSpecialSkill(newSpecialSkill);
            specialSkill = newSpecialSkill;
           
            eligibleToRace = newEligibleToRace;
            
            validAccumulatedScore(newAccumulatedScore);
            accumulatedScore = newAccumulatedScore;
            
            validAccumulatedTime(newAccumulatedTime);
            accumulatedTime = newAccumulatedTime;
            
            validTyre(newTyre);
            tyre = newTyre;
        }
        catch (IllegalArgumentException e)
        {
            name = "Default Driver";
            ranking = 1;
            specialSkill = "Default Skill";
            eligibleToRace = true;
            accumulatedScore = 0;
            accumulatedTime = 0;
            tyre = "Dry";
        }
    }
    
    /**
     * Displays the state of the object.
     * 
     * @return A String that shows the state of the driver.
     */
    public String displayDriver()
    {
        String stateOfDriver = name + "," + ranking + "," + specialSkill + "," + eligibleToRace + "," + accumulatedScore + "," + accumulatedTime + "," + tyre + System.lineSeparator();
        return stateOfDriver;
    }
    
    /**
     * Accessor of the accumulated score.
     * 
     * @return The accumulated score.
     */
    public int getAccumulatedScore()
    {
        return accumulatedScore;
    }
    
    /**
     * Accessor of the accumulated time.
     * 
     * @return The accumulated time.
     */
    public int getAccumulatedTime()
    {
        return accumulatedTime;
    }
    
    /**
     * Accessor of the driver's eligibility.
     * 
     * @return The driver's eligibility.
     */
    public boolean getEligibleToRace()
    {
        return eligibleToRace;
    }
    
    /**
     * Accessor of the name of the driver.
     * 
     * @return The name of the driver.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor of the ranking od the driver.
     * 
     * @return The ranking of the driver.
     */
    public int getRanking()
    {
        return ranking;
    }
    
    /**
     * Accessor of the special skill of the driver.
     * 
     * @return The special skill of the driver.
     */
    public String getSpecialSkill()
    {
        return specialSkill;
    }
    
    /**
     * Accessor of the tyre.
     *
     * @return The tyre of the driver. 
     */
    public String getTyre()
    {
        return tyre;
    }

    /**
     * Increases the accumulated score, decrease the score if the input is negative.
     * 
     * @param increase The scores increased to the accumulated score.
     */
    public void increaseAccumulatedScore(int increase)
    {
        accumulatedScore += increase;
    }
    
    /**
     * Increases the accumulated time, decrease the time if the input is negative.
     * 
     * @param increase The time increased to the accumulated time.
     */
    public void increaseAccumulatedTime(int increase)
    {
        accumulatedTime += increase;
    }
    
    /**
     * Mutator of the accumulated score.
     * 
     * @param newAccumulatedScore The new accumulated score.
     */
    public boolean setAccumulatedScore(int newAccumulatedScore)
    {
        try
        {
            validAccumulatedScore(newAccumulatedScore);
            accumulatedScore = newAccumulatedScore;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
        
    /**
     * Mutator of the accumulated time.
     * 
     * @param newAccumulatedTime The new accumulated time.
     */
    public boolean setAccumulatedTime(int newAccumulatedTime)
    {
        try
        {
            validAccumulatedTime(newAccumulatedTime);
            accumulatedTime = newAccumulatedTime;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator of the driver's eligibility.
     * 
     * @param newEligibleToRace The new eligibility of of the driver.
     */
    public void setEligibleToRace(boolean newEligibleToRace)
    {
        eligibleToRace = newEligibleToRace;
    }
    
    /**
     * Mutator of the driver's name.
     * 
     * @param newName The new name of the driver.
     */
    public boolean setName(String newName)
    {
        try
        {
            validName(newName);
            name = newName;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator of the driver's ranking.
     * 
     * @param newRanking The new ranking of the driver.
     */
    public boolean setRanking(int newRanking)
    {
        try
        {
            validRanking(newRanking);
            ranking = newRanking;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator of the special skill of the driver.
     * 
     * @param newSpecialSkill The new special skill of the driver.
     */
    public boolean setSpecialSkill(String newSpecialSkill)
    {
        try
        {
            validSpecialSkill(newSpecialSkill);
            specialSkill = newSpecialSkill;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }

    /**
     * Mutator of the driver's tyre.
     *
     * @param newTyre The driver's new tyre.
     * @return true if it is successfully set.
     */
     public boolean setTyre(String newTyre)
     {
         try
         {
            validTyre(newTyre);
            tyre = newTyre;
            return true;
         }
         catch (IllegalArgumentException e)
         {
             return false;
         }
     }
    
     /**
      * Validates the accumulated score.
      *
      * @throws IllegalArgumentException if the accumulated score is smaller than 0.
      */
    private static void validAccumulatedScore(int newAccumulatedScore) throws IllegalArgumentException
    {
        if (newAccumulatedScore < 0)
            throw new IllegalArgumentException("Invalid accumulated score.");
    }
    
    /**
     * Validates the accumulated time.
     * 
     * @throws IllegalArgumentException if the accumulated time is smaller than 0.  
     */
    private static void validAccumulatedTime(int newAccumulatedTime) throws IllegalArgumentException
    {
        if (newAccumulatedTime < 0)
            throw new IllegalArgumentException("Invalid accumulated time.");
    }
    
    /**
     * Validates the new name.
     * 
     * @throws IllegalArgumentException if the length of the name is smaller than 0.
     */
    private static void validName(String newName) throws IllegalArgumentException
    {
        if (newName.length() < 1)
            throw new IllegalArgumentException("Invalid name.");
    }
    
    /**
     * Validates the new name.
     * 
     * @throws IllegalArgumentException if the ranking is smaller than 1.
     */
    private static void validRanking(int newRanking) throws IllegalArgumentException
    {
        if (newRanking < 1)
            throw new IllegalArgumentException("Invalid ranking.");
    }
    
    /**
     * Validates the new skill.
     * 
     * @throws IllegalArgumentException if the skill is none of the following after converted to all lower case: braking, cornering, and overtaking.
     */
    private static void validSpecialSkill(String newSpecialSkill) throws IllegalArgumentException
    {
        if (!newSpecialSkill.toLowerCase().equals("braking") && !newSpecialSkill.toLowerCase().equals("cornering") && !newSpecialSkill.toLowerCase().equals("overtaking"))
            throw new IllegalArgumentException("Invalid special skill.");
    }

    /**
     * Validates the new tyre.
     * 
     * @throws IllegalArgumentException if the tyre is neither wet nor dry after converted to all lower case.
     */
    private static void validTyre(String newTyre) throws IllegalArgumentException
    {
        if (!newTyre.toLowerCase().equals("wet") && !newTyre.toLowerCase().equals("dry"))
            throw new IllegalArgumentException("Invalid tyre.");
    }
}