import java.util.*;
/**
 * The main class of the program.
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (4-May-2019)
 */
public class Championship
{
    private ListOfDrivers drivers;
    private ListOfVenues venues;
    private int noOfRaces;
    
    /**
     * Initialises the object with default values.
     */
    public Championship()
    {
        drivers = new ListOfDrivers();
        venues = new ListOfVenues();
        noOfRaces = 3;
    }
    
    /**
     * Initialises the object with customised values.
     * 
     * @param newDrivers The customised ListOfDrivers.
     * @param newVenues The customised ListOfVenues.
     * @param newNoOfRaces The new number of races in this championship.
     */
    public Championship(ListOfDrivers newDrivers, ListOfVenues newVenues, int newNoOfRaces)
    {
        drivers = newDrivers;
        venues = newVenues;
        noOfRaces = newNoOfRaces;
    }
    
    /**
     * Assign points to the drivers according to their performances in a race.
     */
    private void assignPoints()
    {
        int[] pointList = new int[4];
        pointList[0] = 8;
        pointList[1] = 5;
        pointList[2] = 3;
        pointList[3] = 1;
        
        drivers.sortByAccumulatedTime();

        for (int i = 0; i < 4; i++)
        {
            drivers.getDriver(i).increaseAccumulatedScore(pointList[i]);
        }
    }
    
    /**
     * Displays the state of the championship.
     * 
     * @return Returns the state as a String.
     */
    public String displayChampionship()
    {
        StringBuffer state = new StringBuffer("");
        
        state.append("The number of races in this championship is: ");
        state.append(noOfRaces);
        state.append(System.lineSeparator());
        state.append(venues.displayVenues());
        state.append(drivers.displayDrivers());
        
        System.out.println(state.toString());
        
        return state.toString();
    }   

    /**
     * Displays the lap result for a driver.
     *
     * @param driverIndex The index of the driver.
     */
    private void displayDriverLapResult(int driverIndex, int lapTime)
    {
        System.out.println(drivers.getDriver(driverIndex).getName() + " finishes this lap in " + lapTime + " seconds!");
        System.out.println();
    }
    
    /**
     * Displays the information of recoverable mechanical faults.
     * 
     * @param fault The type of fault.
     */
    private void displayFaultInfo(String fault)
    {
        switch (fault)
        {
            case "minor":
                System.out.println("The major mechanical fault is going to cost him 20 seconds this lap!");
                break;
            case "major":       
                System.out.println("The major mechanical fault is going to cost him 120 seconds this lap!");
                break;
            case "unrecoverable":
                System.out.println("We have to retire the car due to unrecoverable mechanical faults!");
                break;
            default:
                System.out.println("The car is in perfect condition this lap!");
                break;
        }
    }
    
    /**
     * Displays the message that tells the user the noOfRaces is illegal.
     */
    private void displayIllegalNoOfRaces()
    {   
        System.out.println("Oops! ");
        System.out.println("This is an illegal number of races!");
        System.out.println("The number of races should be 3 to 5 inclusively!");
        
        Input.continueWithClear("proceed");
    }
        
    /**
     * Displays the starting prompt of the lap.
     * 
     * @param lapIndex The index of the lap
     * @param driverIndex The index of the leading driver.
     * @param venueIndex The index of the venue.
     */
    private void displayLapEnd(int lapIndex, int venueIndex)
    {
        System.out.println("This is the end of lap " + lapIndex + " of the race.");
        System.out.println("In this race, " + drivers.getDriver(0).getName() + " is leading by far!");
        
        if (lapIndex == venues.getVenue(venueIndex).getNoOfLaps())
            Input.continueWithClear("see the race result");
        else
            Input.continueWithClear("start the next lap");
    }
    
    /**
     * Displays the starting prompt of the lap.
     * 
     * @param lapIndex The index of the lap
     */
    private void displayLapStart(int lapIndex)
    {
        System.out.println("This is the lap " + lapIndex + " of the race.");
        Input.continueWithoutClear("start racing");
    }

    /**
     * Displays the message that tells the user the noOfRaces is legal.
     */
    private void displayLegalNoOfRaces()
    {
        System.out.println("Congragulations! ");
        System.out.println("This is a legal number of races!");
    }
    
    /**
     * Displays rain infomation.
     * 
     * @param isRaining Whether it's raining in this lap.
     */
    private void displayRainInformation(boolean isRaining)
    {
        if (isRaining)
            System.out.println("It is raining in this lap!" + System.lineSeparator());
        else
            System.out.println("The weather looks fine this lap!" + System.lineSeparator());
    }
    
    /**
     * Displays the final result of the race.
     */
    private void displayRaceResult()
    {
        System.out.println("This is the result of the race...");
        for (int i = 0; i <= 3; i++)
            makeTableRow((i + 1), drivers.getDriver(i).getName(), drivers.getDriver(i).getAccumulatedTime());
            
        Input.continueWithClear("proceed to the next race");
    }

    /**
     * Displays when the driver stop for changing tyre due to rain.
     * 
     * @param isRaining If it's raining in this lap.
     * @param isChanging If the 
     */
    private void displayRainStint(boolean isRaining, boolean isChanging)
    {
        if (isRaining && isChanging)
            System.out.println("He decided to change his tyre, costing him 10 seconds!");
            
        if (isRaining && !isChanging)
            System.out.println("His dry tyres in rain cost him 5 seconds this lap!");
    }

    /**
     * Displays the score table of the championship.
     */
    private void displayScoreTable()
    {       
        System.out.println("Here's the current score table!");

        for (int i = 0; i < drivers.getDrivers().size(); i++)
            makeTableRow(drivers.getDriver(i).getRanking(), drivers.getDriver(i).getName(), drivers.getDriver(i).getAccumulatedScore());

        Input.continueWithClear("continue");
    }

    /**
     * Displays skill information.
     * 
     * @param name The name of the driver.
     * @param time The time reduced by the skill.
     * @param lapIndex The index of the lap.
     */
    private void displaySkill(String name, int time, String skill, int lapIndex)
    {
        boolean isOvertaking = skill.equals("overtaking");
        
        if (isOvertaking)
            if (lapIndex % 3 == 1)
                System.out.println(name + " achived a " + time + "-second reduction in laptime, thanks to his " + skill + " skill!");
            else
                System.out.println("His overstaking skill is banned in this lap!");
        else
            System.out.println(name + " achived a " + time + "-second reduction in laptime, thanks to his " + skill + " skill!");
    }

    /**
     * Displays the information of the venue.
     * 
     * @param venueIndex The index of the venue.
     */
    private void displayVenueInformation(int venueIndex)
    {   
        System.out.println("The race No." + (venueIndex + 1) + " of this Championship is held in " + venues.getVenue(venueIndex).getVenueName() + "!");
        System.out.println("The number of laps in this race is " + venues.getVenue(venueIndex).getNoOfLaps() + ".");
        System.out.println("The average lap time is " + venues.getVenue(venueIndex).getAverageLapTime() + ".");
        System.out.println("The chance of rain is "+ (int)(venues.getVenue(venueIndex).getChanceOfRain() * 100) + "%.");
        
        Input.continueWithClear("start the race");
    }
    
    /**
     * Displays the welcome message.
     */    
    private void displayWelcomeMessage()
    {
        System.out.println('\u000C');
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*          Welcome the FIT9131 Grand Prix           *");
        System.out.println("*     Proudly organised by Weicong Tan Charles      *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        
        Input.continueWithClear("continue");
    }
    
    /**
     * Displays WDC of the championship.
     */
    private void displayWDC()
    {
        System.out.println("Let's give " + drivers.getDriver(0).getName() + " big hands for winning the champion this season!");
    }
    
    /**
     * Read a file that contains information of the drivers and set it in to drivers.
     */
    private void fileToDrivers()
    {
        FileIO driverInput = new FileIO("drivers.txt");
        
        ArrayList<String> plainList = driverInput.readingFile();
        
        for (int i = 0; i < plainList.size(); i++)
        {
            if (plainList.get(i).length() > 0)
            {
                String[] splitArray = plainList.get(i).split(",");
                try
                {
                    drivers.addDriver(splitArray[0], Integer.parseInt(splitArray[1]), 
                                      splitArray[2], Boolean.parseBoolean(splitArray[3]), 
                                      Integer.parseInt(splitArray[4]), Integer.parseInt(splitArray[5]),
                                      splitArray[6]);
                }
                catch (IllegalArgumentException | IndexOutOfBoundsException e)
                {
                    System.out.println("Content compromised.");
                    break;
                }
            }
            else
                break;
        }
    }
    
    /**
     * Read a file that contains information of the venues and set it in to venues.
     */
    private void fileToVenues()
    {
        FileIO venueInput = new FileIO("venues.txt");
        
        ArrayList<String> plainList = venueInput.readingFile();
        
        for (int i = 0; i < plainList.size(); i++)
        {
            if (plainList.get(i).length() > 0)
            {
                String[] splitArray = plainList.get(i).split(",");
                try
                {
                    venues.addVenue(splitArray[0], Integer.parseInt(splitArray[1]), 
                                    Integer.parseInt(splitArray[2]), Double.parseDouble(splitArray[3]));
                }
                catch (IllegalArgumentException | IndexOutOfBoundsException e)
                {
                    System.out.println("Content compromised.");
                    break;
                }
            }
        }
    }
        
    /**
     * Prepares the next championship.
     */
    private void finishChampionship()
    {       
        drivers.resetAccumulatedScores();
        
        writeFile();
    }
    
    /**
     * Prepares the race to initial status.
     */
    private void finishRace()
    {       
        drivers.resetAccumulatedTimes();
        drivers.resetEligibility();
        drivers.resetTyre();
    }
    
    /**
     * Accessor of the drivers.
     * 
     * @return The drivers' information.
     */
    public ListOfDrivers getDrivers()
    {
        return drivers;
    }
    
    /**
     * Accessor of the number of races.
     * 
     * @return The number of races.
     */
    public int getNoOfLaps()
    {
        return noOfRaces;
    }
    
    /**
     * Accessor of the venues.
     * 
     * @return The venues' information.
     */
    public ListOfVenues getVenues()
    {
        return venues;
    }
    
    /**
     * Allows users to input the number of races in the championship.
     */
    public void inputNoOfRaces()
    {   
        int newNoOfRaces = 0;
        
        do
        {
            newNoOfRaces = Input.acceptIntegerInput("the number of races");
            
            if (!setNoOfRaces(newNoOfRaces))
                displayIllegalNoOfRaces();
        } while (!setNoOfRaces(newNoOfRaces));
        
        displayLegalNoOfRaces();
        Input.continueWithClear("continue");
    }
    
    /**
     * Makes a row of table.
     * 
     * @param rowNumber The number of the row.
     * @param name The name.
     * @param data The attribute of the driver.
     */
    private void makeTableRow(int rowNumber, String name, int data)
    {
        System.out.print(rowNumber + "     ");
        System.out.printf("%-10s %10s", name, data);
        System.out.printf(System.lineSeparator());
    }

    /**
     * The drivers finished the whole championship.
     */
    private void raceOneChampionship()
    {
        Collections.shuffle(venues.getVenues());

        for (int i = 0; i < noOfRaces; i++)
        {
            displayVenueInformation(i);
            raceOneRace(i);
        }
        displayScoreTable();
        displayWDC();
    }

    /**
     * The drivers race in one lap.
     * 
     * @param lapTime The lap time of the race.
     * @param chanceOfRain The chance of rain in the lap.
     * @param lapIndex The index of the lap.
     */
    private void raceOneLap(int lapTime, double chanceOfRain, int lapIndex)
    {
        boolean isRaining = simulatingRain(chanceOfRain);
        displayLapStart(lapIndex);
        displayRainInformation(isRaining);
        
        for (int i = 0; i < drivers.getDrivers().size(); i++)
        {   
            int actualLapTime = 0;

            if (lapIndex == 0)
                actualLapTime += simulatingGrid(drivers.getDriver(i).getRanking());

            if (drivers.getDriver(i).getEligibleToRace())
            {
                String faultStatus = simulatingMechanicalFaults();
                displayFaultInfo(faultStatus);
                if (faultStatus.equals("unrecoverable"))
                {
                    drivers.getDriver(i).setEligibleToRace(false);
                    continue;
                }
                
                actualLapTime += simulatingFaultPenalty(faultStatus);
                    
                boolean isChanging = simulatingRainDecision(isRaining, drivers.getDriver(i).getTyre().toLowerCase());
                
                if (isRaining && isChanging)
                    drivers.getDriver(i).setTyre("Wet");

                actualLapTime += simulatingTyrePenalty(isRaining, isChanging);
                displayRainStint(isRaining, isChanging);
                
                int skillReduction = simulatingSkill(drivers.getDriver(i).getSpecialSkill().toLowerCase(), lapIndex);
                displaySkill(drivers.getDriver(i).getName(), skillReduction, drivers.getDriver(i).getSpecialSkill().toLowerCase(), lapIndex);
                
                actualLapTime -= skillReduction;
                actualLapTime += lapTime;
                displayDriverLapResult(i, actualLapTime);
            }

            drivers.getDriver(i).increaseAccumulatedTime(actualLapTime);
        }
    }

    /**
     * The drivers race a whole race.
     * 
     * @param venueIndex The index of the venue.
     */
    private void raceOneRace(int venueIndex)
    {
        for (int i = 0; i < drivers.getDrivers().size(); i++)
            simulatingGrid(i);
                
        for (int i = 1; i <= venues.getVenue(venueIndex).getNoOfLaps(); i++)
        {
            raceOneLap(venues.getVenue(venueIndex).getAverageLapTime(), venues.getVenue(venueIndex).getChanceOfRain(), i);
            drivers.sortByAccumulatedTime();
            displayLapEnd(i, venueIndex);
        }
        
        displayRaceResult();
        assignPoints();
        drivers.sortByAccumulatedScore();
        drivers.setRankings();
        displayScoreTable();
        finishRace();
    }
    
    /**
     * Mutator for drivers.
     * 
     * @param newDrivers The new list of drivers.
     */
    public void setDrivers(ListOfDrivers newDrivers)
    {
        drivers = newDrivers;
    }
    
    /**
     * Mutator for the new number of races.
     * 
     * @param newNoOfRaces The new number of races.
     */
    public boolean setNoOfRaces(int newNoOfRaces)
    {
        try
        {
            validNoOfRaces(newNoOfRaces);
            noOfRaces = newNoOfRaces;
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
    
    /**
     * Mutator for venues.
     * 
     * @param newVenues The new list of venues.
     */
    public void setVenues(ListOfVenues newVenues)
    {
        venues = newVenues;
    }
    
    /**
     * Simulates time penalty caused by recoverable mechanical faults.
     * 
     * @param faultType The type of the fault.
     * @return The time penalty.
     */
    private int simulatingFaultPenalty(String faultType)
    {
        switch (faultType)
        {
            case "minor":
                return 20;
            case "major":
                return 120;
            default:
                return 0;
        }
    }
    
    /**
     * Simulates grid position by time penalty.
     * 
     * @param ranking The ranking of the driver.
     * @return The time penalty for the grid position.
     */
    private int simulatingGrid(int ranking)
    {
        switch (ranking)
        {
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 7;
            default:
                return 10;
        }
    }
       
    /**
     * Simulates recoverable mechanical faults that may happen every lap.
     *
     * @return The type of the fault, blank if no fault happened.
     */
    private String simulatingMechanicalFaults()
    {
        RNG rng = new RNG(100, 1);
        int probability = rng.generateRandomInteger();
        
        String faultType = "";

        if (probability >= 1 && probability <= 3)
            faultType = "major";
        else if (probability <= 8)
            faultType = "minor";
        else if (probability  == 9)
            faultType = "unrecoverable";

        return faultType;
    }
     
    /**
     * Simulates the rain according to the chance of rain of the venue.
     * 
     * @param rainOdd The chance of rain.
     * @return true if it rains.
     */
    private boolean simulatingRain(double rainOdd)
    {
        RNG rng = new RNG(100, 1);
        
        if (rng.generateRandomInteger() <= rainOdd * 100)
            return true;
        else
            return false;
    }
    
    /**
     * Simulating the decision-making process on changing tyres in case of rain.
     * 
     * @param tyre The current tyre of the driver.
     * @param isRaining If it is raining in this lap.
     * @return true if the driver decided to change tyres.
     */
    private boolean simulatingRainDecision(boolean isRaining, String tyre)
    {
        RNG rng = new RNG(2, 1);
        int decision = rng.generateRandomInteger();
        boolean isChanging = false;
        
        if (isRaining && decision == 1 && tyre.equals("dry"))
            isChanging = true;

        return isChanging;
    }
        
    /**
     * Simulating the skills of the drivers.
     * 
     * @param skill The skill of the driver.
     * @param lapIndex The index of the lap.
     * 
     * @return The time reducted by the skill.
     */
    private int simulatingSkill(String skill, int lapIndex)
    {
        int timePenalty = 0;
        
        if (skill.equals("cornering") || skill.equals("braking"))
        {
            RNG rng = new RNG(8, 1);
            timePenalty = rng.generateRandomInteger();
        }
        
        if (skill.equals("overtaking") && lapIndex % 3 == 1)
        {
            RNG rng = new RNG(20, 10);
            timePenalty = rng.generateRandomInteger();
        }
        
        return timePenalty;
    }
    
    /**
     * Simulating the time penalty caused by tyres and weather.
     * 
     * @param isRaining if it is raining in this lap.
     * @param isChanging if the driver is changing his tyres.
     * @return The time penalty.
     */
    private int simulatingTyrePenalty(boolean isRaining, boolean isChanging)
    {
        if (isRaining && isChanging)
            return 10;
        else if (isRaining && !isChanging)
            return 5;
        else
            return 0;
    }

    /**
     * Starts the Grand Prix
     */
    public void startGrandPrix()
    {
        displayWelcomeMessage();
        inputNoOfRaces();
        fileToVenues();
        fileToDrivers();
        raceOneChampionship();
        finishChampionship();
    }
    
    /**
     * The validation method of the number of races.
     * 
     * @param newNoOfRaces The new number of races.
     * @throws IllegalArgumentException when the new number of races is larger than 5 or smaller than 3, both sides exclusively.
     */
    private static void validNoOfRaces(int newNoOfRaces)
    {
        if (newNoOfRaces > 5 || newNoOfRaces < 3)
            throw new IllegalArgumentException("Illegal number of races");
    }
    
    /**
     * Writes the drivers to the file to prepare for the next championship.
     */
    public void writeFile()
    {
        FileIO output = new FileIO("drivers.txt");
        
        output.writingFile(drivers.displayDrivers());
    }
}