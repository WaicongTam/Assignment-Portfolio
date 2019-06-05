import java.util.ArrayList;
/**
 * The ListOfVenues contains the information of all the venues.
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (4-May-2019)
 */
public class ListOfVenues
{
    private ArrayList<Venue> venues;
    
    /**
     * Initialises the object defaultly.
     */
    public ListOfVenues()
    {
        venues = new ArrayList<>();  
    }
    
    /**
     * Initialises the object with a customised ArrayList.
     * 
     * @param newVenues The customised ArrayList.
     */
    public ListOfVenues(int newInitialSize, Venue newVenue)
    {
        venues = new ArrayList<>(newInitialSize);
    }
    
    /**
     * Adds venue to the ArrayList.
     * 
     * @param newVenueName The new name of the venue.
     * @param newNoOfLaps The new number of laps.
     * @param newAverageLapTime The new average lap time of the venue.
     * @param newChanceOfRain The new chance of rain.
     * 
     * @return true if the object was successfully added.
     */
    public void addVenue(String newVenueName, int newNoOfLaps, int newAverageLapTime, double newChanceOfRain)
        throws IllegalArgumentException
    {
        Venue temp = new Venue();
        
        boolean hasSet = true;
            
        hasSet = hasSet && temp.setAverageLapTime(newAverageLapTime);
        hasSet = hasSet && temp.setChanceOfRain(newChanceOfRain);
        hasSet = hasSet && temp.setNoOfLaps(newNoOfLaps);
        hasSet = hasSet && temp.setVenueName(newVenueName);
        
        if (hasSet)
            venues.add(temp);
        else
            throw new IllegalArgumentException("Illegal argument for an object.");
    }
    
    /**
     * Display the states of the venues.
     */
    public String displayVenues()
    {
        StringBuffer state = new StringBuffer("");
        
        for (Venue ve : venues)
        {
            state.append(ve.displayVenue());
        }
        
        return state.toString();
    }
    
    /**
     * Accessor of a single element of the ArrayList.
     * 
     * @param index The index of the element.
     * @return The element.
     */
    public Venue getVenue(int index)
    {
        try
        {
            return venues.get(index);
        }
        catch (IndexOutOfBoundsException e)
        {
            return new Venue();
        }
        catch (NullPointerException e)
        {
            return new Venue();
        }
    }
    
    /**
     * Accessor of the whole ArrayList.
     * 
     * @return The whole ArrayList.
     */
    public ArrayList<Venue> getVenues()
    {
        return venues;
    }
    
    /**
     * Mutator for a single element of the ArrayList.
     * 
     * @param index The index of the element.
     * @param newVenueName The new name of the venue.
     * @param newNoOfLaps The new number of laps.
     * @param newAverageLapTime The new average lap time of the venue.
     * @param newChanceOfRain The new chance of rain.
     * 
     * @return If the element has been successfully changed for all the attritubutes, return true.
     */
    public boolean setVenue(int index, String newVenueName, int newNoOfLaps, int newAverageLapTime, double newChanceOfRain)
    {
        try
        {
            boolean hasSet = true;
            
            hasSet = hasSet && venues.get(index).setAverageLapTime(newAverageLapTime);
            hasSet = hasSet && venues.get(index).setChanceOfRain(newChanceOfRain);
            hasSet = hasSet && venues.get(index).setNoOfLaps(newNoOfLaps);
            hasSet = hasSet && venues.get(index).setVenueName(newVenueName);
            
            return hasSet;
        }
        catch (IndexOutOfBoundsException e)
        {
            return false;
        }
        catch (NullPointerException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator for the whole ArrayList.
     * 
     * @param newVenues The new ArrayList.
     */
    public void setVenues(ArrayList<Venue> newVenues)
    {
        venues = newVenues;
    }
}