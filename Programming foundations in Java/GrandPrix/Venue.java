/**
 * The Venue class prescribes a venue that hold races.
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (3-May-2019)
 */
public class Venue
{
    private String venueName;
    private int noOfLaps;
    private int averageLapTime;
    private double chanceOfRain;
    
    /**
     * Initialises a venue object with default values.
     */
    public Venue()
    {
        venueName = "Default Name";
        noOfLaps = 5;
        averageLapTime = 70;
        chanceOfRain = 0.2;
    }
    
    /**
     * Initialises a venue with user-customised values.
     */
    public Venue(String newVenueName, int newNoOfLaps, int newAverageLapTime, double newChanceOfRain)
    {
        try
        {
            validVenueName(newVenueName);
            venueName = newVenueName;
            
            validNoOfLaps(newNoOfLaps);
            noOfLaps = newNoOfLaps;
            
            validAverageLapTime(newAverageLapTime);
            averageLapTime = newAverageLapTime;
            
            validChanceOfRain(newChanceOfRain);
            chanceOfRain = newChanceOfRain;
        }
        catch (IllegalArgumentException e)
        {
            venueName = "";
            noOfLaps = 5;
            averageLapTime = 70;
            chanceOfRain = 0.2;
        }
    }
    
    /**
     * Display the state of the venue.
     * 
     * @return A String that shows the state of the venue.
     */
    public String displayVenue()
    {
        String stateOfVenue = venueName + "," + noOfLaps + "," + averageLapTime + "," + chanceOfRain + System.lineSeparator();
        return stateOfVenue;
    }
        
    /**
     * Accessor of the average lap time of the venue.
     * 
     * @return The average lap time of the venue.
     */
    public int getAverageLapTime()
    {
        return averageLapTime;
    }
    
    /**
     * Accessor of the chance of rain of the venue.
     * 
     * @return The chance of rain of the venue.
     */
    public double getChanceOfRain()
    {
        return chanceOfRain;
    }
    
    /**
     * Accessor of the number of laps in a race at the venue.
     * 
     * @return The number of laps in a race
     */
    public int getNoOfLaps()
    {
        return noOfLaps;
    }
    
    /**
     * Accessor of the name of the venue.
     * 
     * @return The name of the venue.
     */
    public String getVenueName()
    {
        return venueName;
    }
    
    /**
     * Mutator of the average lap time.
     * 
     * @param newAverageLapTime The new average lap time.
     * @return Whether the average lap time has been successfully set.
     */
    public boolean setAverageLapTime(int newAverageLapTime)
    {
        try
        {
            validAverageLapTime(newAverageLapTime);
            averageLapTime = newAverageLapTime;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator of the chance of rain.
     * 
     * @param newChanceOfRain The new chance of rain.
     * @return Whether the chance of rain has been successfully set.
     */
    public boolean setChanceOfRain(double newChanceOfRain)
    {
        try
        {
            validChanceOfRain(newChanceOfRain);
            chanceOfRain = newChanceOfRain;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator of the number of laps.
     * 
     * @param newNoOfLaps The new chance of rain.
     */
    public boolean setNoOfLaps(int newNoOfLaps)
    {
        try
        {
            validNoOfLaps(newNoOfLaps);
            noOfLaps = newNoOfLaps;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator of the name of the venue.
     * 
     * @param newVenueName The new name of the venue.
     */
    public boolean setVenueName(String newVenueName)
    {
        try
        {
            validVenueName(newVenueName);
            venueName = newVenueName;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Validates the new average lap time.
     * 
     * @throws IllegalArgumentException when the new lap time is smaller than 60 or larger than 90, both sides exclusively.
     */
    private static void validAverageLapTime(int newAverageLapTime) throws IllegalArgumentException
    {
        if (newAverageLapTime < 60 || newAverageLapTime > 90)
            throw new IllegalArgumentException("Invalid average lap time.");
    }
    
    /**
     * Validates the new average lap time.
     * 
     * @throws IllegalArgumentException when the new chance of rain is smaller than 0 or larger than 0.2, both sides exclusively.
     */
    private static void validChanceOfRain(double newChanceOfRain) throws IllegalArgumentException
    {
        if (newChanceOfRain <= 0 || newChanceOfRain > 0.2)
            throw new IllegalArgumentException("Invalid chance of rain.");
    }
    
    /**
     * Validates the new average lap time.
     * 
     * @throws IllegalArgumentException when the new number of laps is smaller than 0.
     */
    private static void validNoOfLaps(int newNoOfLaps) throws IllegalArgumentException
    {
        if (newNoOfLaps <= 0)
            throw new IllegalArgumentException("Invalid number of laps.");
    }
    
    /**
     * Validates the new name of the venue.
     * 
     * @throws IllegalArgumentException when the new length of the name is smaller than 1.
     */
    private static void validVenueName(String newVenueName) throws IllegalArgumentException
    {
        if (newVenueName.length() < 1)
            throw new IllegalArgumentException("Invalid name of venue.");
    }
}    