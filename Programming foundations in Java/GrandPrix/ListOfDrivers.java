import java.util.*;
/**
 * The ListOfDrivers contains the information of all the drivers.
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (4-May-2019)
 */
public class ListOfDrivers
{
    private ArrayList<Driver> drivers;
    
    /**
     * Initialises the object defaultly.
     */
    public ListOfDrivers()
    {
        drivers = new ArrayList<>();
    }
    
    /**
     * Initialises the object with a customised ArrayList.
     * 
     * @param newDrivers The customised ArrayList.
     */
    public ListOfDrivers(int newInitialSize, Driver newDriver)
    {
        drivers = new ArrayList<>();
    }
    
    /**
     * Adds driver to the ArrayList.
     * 
     * @param newName The new name of the driver.
     * @param newRanking The new ranking of laps.
     * @param newSpecialSkill The new special skill of the driver.
     * @param newElligibleToRace The new eligibility of the driver.
     * @param newAccumulatedScore The new accumulated score of the driver.
     * @param newAccumulatedTime The new accumulated time of the driver.
     * @param newTyre The new tyre of the driver.
     * 
     * @return true if the object was successfully added.
     */
    public void addDriver(String newName, int newRanking, String newSpecialSkill, boolean newEligibleToRace, int newAccumulatedScore, int newAccumulatedTime, String newTyre)
        throws IllegalArgumentException
    {
        drivers.add(new Driver(newName, newRanking, newSpecialSkill, newEligibleToRace, newAccumulatedScore, newAccumulatedTime, newTyre));     
    }
    
    /**
     * Display the states of the drivers.
     */
    public String displayDrivers()
    {
        StringBuffer state = new StringBuffer("");
        
        for (Driver dr : drivers)
        {
            state.append(dr.displayDriver());
        }
        
        return state.toString();
    }
    
    /**
     * Accessor of a single element of the ArrayList.
     * 
     * @param index The index of the element.
     * @return The element.
     */
    public Driver getDriver(int index)
    {
        try
        {
            return drivers.get(index);
        }
        catch (IndexOutOfBoundsException e)
        {
            return new Driver();
        }
        catch (NullPointerException e)
        {
            return new Driver();
        }
    }
    
    /**
     * Accessor of the whole ArrayList.
     * 
     * @return The whole ArrayList.
     */
    public ArrayList<Driver> getDrivers()
    {
        return drivers;
    }

    /**
     * Reset the drivers' accumulated score to 0.
     */
    public void resetAccumulatedScores()
    {
        for (Driver dr : drivers)
            dr.setAccumulatedScore(0);
    }

    /**
     * Reset the drivers' accumulated time to 0.
     */
    public void resetAccumulatedTimes()
    {
        for (Driver dr : drivers)
            dr.setAccumulatedTime(0);
    }

    /**
     * Reset the drivers' eligibility to true.
     */
    public void resetEligibility()
    {
        for (Driver dr : drivers)
            dr.setEligibleToRace(true);
    }

    /**
     * Reset the drivers' tyre to dry.
     */
    public void resetTyre()
    {
        for (Driver dr : drivers)
            dr.setTyre("Dry");
    }

    /**
     * Mutator for a single element of the ArrayList.
     * 
     * @param index The index of the element.
     * @param newName The new name of the driver.
     * @param newRanking The new ranking of laps.
     * @param newSpecialSkill The new special skill of the driver.
     * @param newElligibleToRace The new eligibility of the driver.
     * @param newAccumulatedScore The new accumulated score of the driver.
     * @param newAccumulatedTime The new accumulated time of the driver.
     * @param newTyre The new tyre of the driver.
     * 
     * @return If the element has been successfully changed for all the attritubutes, return true.
     */
    public boolean setDriver(int index, String newName, int newRanking, String newSpecialSkill, boolean newEligibleToRace, int newAccumulatedScore, int newAccumulatedTime, String newTyre)
    {
        try
        {
            boolean hasSet = true;
            
            hasSet = hasSet && drivers.get(index).setName(newName);
            hasSet = hasSet && drivers.get(index).setRanking(newRanking);
            hasSet = hasSet && drivers.get(index).setSpecialSkill(newSpecialSkill);
            drivers.get(index).setEligibleToRace(newEligibleToRace);
            hasSet = hasSet && drivers.get(index).setAccumulatedScore(newAccumulatedScore);
            hasSet = hasSet && drivers.get(index).setAccumulatedTime(newAccumulatedTime);
            hasSet = hasSet && drivers.get(index).setTyre(newTyre);
            
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
     * @param newDrivers The new ArrayList.
     */
    public void setDrivers(ArrayList<Driver> newDrivers)
    {
        drivers = newDrivers;
    }

    /**
     * Set the rankings of the drivers according to the championship's rule.
     */
    public void setRankings()
    {
        for (int i = 0; i < drivers.size(); i++)
            if (i < 4)
                drivers.get(i).setRanking(i + 1);
            else
                drivers.get(i).setRanking(5);          
    }
  
    /**
     * Shuffles drivers with the same points.
     */
    private void shuffleByScore()
    {
        for (int i = 0; i < 3; i++)
        {
            int countDuplicates = 0;
            
            for (int j = i + 1; j < 4; j++)
            {
                if (drivers.get(i).getAccumulatedScore() == drivers.get(j).getAccumulatedScore())
                    countDuplicates++;
                else
                    break;
            }

            if (countDuplicates > 1)
            {
                Collections.shuffle(drivers.subList(i, i + countDuplicates + 1));
                i += countDuplicates;
            }
        }
    }

    /**
     * Shuffles drivers with the same points.
     */
    private void shuffleByTime()
    {
        for (int i = 0; i < 3; i++)
        {
            int countDuplicates = 0;
            
            for (int j = i + 1; j < 4; j++)
            {
                if (drivers.get(i).getAccumulatedTime() == drivers.get(j).getAccumulatedTime())
                    countDuplicates++;
                else
                    break;
            }

            if (countDuplicates > 1)
            {
                Collections.shuffle(drivers.subList(i, i + countDuplicates + 1));
                i += countDuplicates;
            }
        }
    }

    /**
     * Sorts the drivers by accumulated score.
     */
    public void sortByAccumulatedScore()
    {
        for (int i = 0; i < drivers.size() - 1; i++)
        {
            for (int j = 0; j < drivers.size() - i - 1; j++)
            {
                Driver temp = drivers.get(j);
                if (drivers.get(j).getAccumulatedScore() < drivers.get(j + 1).getAccumulatedScore())
                {
                    drivers.set(j, drivers.get(j + 1));
                    drivers.set(j + 1, temp);
                }
            }
        }

        shuffleByScore();
    }

    /**
     * Sorts the drivers by accumulated time.
     */
    public void sortByAccumulatedTime()
    {
        for (int i = 0; i < drivers.size() - 1; i++)
        {
            for (int j = 0; j < drivers.size() - i - 1; j++)
            {
                Driver temp = drivers.get(j);
                if (drivers.get(j).getAccumulatedTime() > drivers.get(j + 1).getAccumulatedTime())
                {
                    drivers.set(j, drivers.get(j + 1));
                    drivers.set(j + 1, temp);
                }
            }
        }

        for (int i = 0 ; i < drivers.size() - 1; i++)
        {
            if (drivers.get(i).getEligibleToRace() == false && drivers.get(i + 1).getEligibleToRace() == true)
            {
                Driver temp = drivers.get(i);
                drivers.add(temp);
                drivers.remove(i);
            }
        }

        shuffleByTime();
    }
}