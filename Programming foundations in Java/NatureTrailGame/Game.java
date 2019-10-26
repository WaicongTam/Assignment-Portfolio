import java.util.ArrayList;
/**
 * The Game class contains Player objects and manages game process
 *
 * @author Weicong Tan Charles
 * @version 1.0.0 (23 Mar 2019)
 */
public class Game
{
    private int trailLength;//The length of the nature trail
    private Trail natureTrail;//The natureTrail object
    private Player playerOne;//playerOne, in this case, human player
    private Player playerTwo;//playerTwo, in this case, the computer
    private Animal[] animals;//Animals
    private Input input;//Accept input from the user
    
    /**
     * Initialises a Game object, presets the computer player's name as a default one; all animals will be set as default animals.
     */
    public Game()
    {
        trailLength = 10;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player("Computer Charles");
        input = new Input();
        
        animals = new Animal[10];
        for (int i = 0; i < animals.length; i++)
            animals[i] = new Animal();  
    }
    
    /**
     * Allows user to initialise the object with a customised computer player's name.
     * 
     * @param computerName The computer player's name that the user wants to initialize the object with.
     */
    public Game(String computerName)
    {
        trailLength = 10;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player(computerName);
        input = new Input();
        
        animals = new Animal[10];
        for (int i = 0; i < animals.length; i++)
            animals[i] = new Animal();  
    }
    
    /**
     * Allows users to customise the object when they initialise it.
     * 
     * @param newTrailLength The new length of the trail.
     * @param newTrail The new Trail object.
     * @param newPlayerOne The new playerOne.
     * @param newPlayerTwo The new playerTwo.
     * @param newAnimalsAmount The new length of the animals.
     * @param newAnimal The new Animal object presets to the animals.
     */
    public Game(int newTrailLength, Trail newTrail, Player newPlayerOne, Player newPlayerTwo, int newAnimalsAmount, Animal newAnimal)
    {
        trailLength = newTrailLength;
        natureTrail = newTrail;
        playerOne = newPlayerOne;
        playerTwo = newPlayerTwo;
        input = new Input();
        
        animals = new Animal[newAnimalsAmount];
        for (int i = 0; i < animals.length; i++)
            animals[i] = newAnimal;
    }
    
    /**
     * Allocates nature features' position on the trail for the game.
     * 
     * @param trail The trail with the nature features.
     */
    public void allocateFeatures(Trail trail)
    {
        Dice dice = new Dice((trailLength - 2), 1);
        
        trail.presetFeatures();
        
        ArrayList<Integer> checkDuplicate = new ArrayList<>();
                                
        for (int i = 0; i < trail.getFeatures().length; i++)
        {    
            int onTrailPosition = dice.generateRandomInteger();
                        
            while (checkDuplicate.contains(onTrailPosition))
                onTrailPosition = dice.generateRandomInteger();
            
            checkDuplicate.add(onTrailPosition);
            
            trail.getFeature(i).setFeaturePosition(onTrailPosition);
        }
        
        displayFeaturesAllocation();
        input.continueWithClear("continue");
    }
    
    /**
     * Prepares the animals that the player will run into in the game.
     */
    public void allocateAnimals()
    {
        setAnimal(0, "Koala", 10);
        setAnimal(1, "Emu", 7);
        setAnimal(2, "Wombat", 5);
        setAnimal(3, "Kangaroo", 2);
        setAnimal(4, "Redback spider", -5);
        
        displayAnimalsAllocation();
        input.continueWithClear("continue");
    }
    
    /**
     * Prepares the content to display on the screen which indicates the player's current position.
     * 
     * @param player The player whose position was to visualised on the terminal.
     */
    public String catPlayerPosition(Player player)
    {
        StringBuffer playerStatus = new StringBuffer("");
        
        for (int i = 0; i <= (player.getPosition() - 1); i++)
            playerStatus.append(" ");
        
        playerStatus.append(player.getName().charAt(0));
         
        return playerStatus.toString();
    }
    
    /**
     * Prepares the starting and ending point of the trail to display on the screen.
     */
    public String catTrailFlags()
    {
        StringBuffer firstLine = new StringBuffer("S");
        
        for (int i = 1; i <= (trailLength - 2); i++)
            firstLine.append(" ");
            
        firstLine.append("F");
        
        return firstLine.toString();
    }
    
    /**
     * Prepares the road of the trail to display on the screen.
     */
    public String catTrailRoad()
    {
       StringBuffer bottomLine = new StringBuffer("");
       
       for (int i = 1; i <= trailLength; i++)
            bottomLine.append("_");
       
       return bottomLine.toString();
    }
    
    /**
     * Shows the user that the animals has been prepared for the game.
     */
    public void displayAnimalsAllocation()
    {
        System.out.print("Releasing our cute animals...");
        input.continueWithoutClear("continue");
        System.out.println("Nicely done!");
        System.out.println("Please be nice to them when they move around!");
    }
    
    /**
     * Shows the information of whether the player ran into an animal.
     * 
     * @param hasMet Whether the player ran into an animal.
     * @param player The player.
     * @param index The index in the retrieval process.
     */
    public void displayAnimalSighting(boolean hasMet, Player player, int index)
    {
        System.out.println("Will " + player.getName() + " meet an animal this turn?");
        input.continueWithoutClear("to see");
        
        if (hasMet)
        {
            System.out.println("Oh! " + player.getName() + " met " + animals[index].getType() + "!");
            System.out.println(animals[index].getPoints() + " points to " + player.getName() + "!");
        }
        else
            System.out.println("No no no not this time mate!");    
    }
    
    /**
     * Shows the user that the nature features has been prepared for the game.
     */
    public void displayFeaturesAllocation()
    {
        System.out.print("Setting the nature features along the trail...");
        input.continueWithoutClear("continue");
        System.out.println("Nicely done!"); 
        System.out.println("It would be super fun running into one isn't it?");
    }
    
    /**
     * Shows the user the warning message about the illegal player name he/she just input; the rule or naming is also included.
     */
    public void displayIllegalName()
    {
        System.out.println('\u000C');
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+                                                     +");
        System.out.println("+ Illegal player name!                                +");
        System.out.println("+ Listen, Weary traveller!                            +");
        System.out.println("+ Your name should only be between 1 to 6 characters! +");
        System.out.println("+                                                     +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    /**
     * Shows the user the warning message about the illegal trail length he/she just input; the rule or naming is also included.
     */
    public void displayIllegalTrailLength()
    {
        System.out.println('\u000C');
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+                                         +");
        System.out.println("+ Illegal trail length!                   +");
        System.out.println("+ It should be somehow between 10 and 20! +");
        System.out.println("+                                         +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }
    
    /**
     * Informs the user that the human player's name has been correctly set.
     */
    public void displayLegalName()
    {
        System.out.println("Congratulation, weary traveller! Your name is a legal one!");
        System.out.println("It has been successfully set! Good luck on your journey!");
    }
    
    /**
     * Informs the user that the trail length has been correctly set.
     */
    public void displayLegalTrailLength()
    {
        System.out.println("Well done mate, this is an legal trail length!");
    }
    
    /**
     * Displays the information that whether a player ran into a nature feature.
     * 
     * @param hasMet Whether the player ran into a nature feature.
     * @param player The player.
     * @param trail The trail.
     * @param index The index in the retrieval process.
     */
    public void displayNatureFeatureSighting(boolean hasMet, Player player, Trail trail, int index)
    {
        if (hasMet)
        {
            System.out.println("Oh! " + player.getName() + " ran into " + trail.getFeature(index).getFeatureType() + " this turn!");
            System.out.println(player.getName() + " is moving " + trail.getFeature(index).getSpacePenalty() + "!");
        }
        else
        {   
            System.out.println("What a shame!");
            System.out.println(player.getName() + " didn't run into any nature feature in this turn!");
        }   
    }
    
    /**
     * Displays the message that a player has reached the final point.
     */
    public void displayPlayerReachedTheFinal(Player player)
    {
        System.out.println(player.getName() + " has reached the final point! 10 more scores to " + player.getName() + " !");
    }
        
    /**
     * Displays the result of the game.
     * 
     * @param player1 The player #1 in the game.
     * @param player2 The player #2 in the game.
     */
    public void displayResult(Player player1, Player player2)
    {
        System.out.println("Finally we've come to an end!");
        
        System.out.println(player1.getName() + " gets " + player1.getScore() + " points!");
        System.out.println(player2.getName() + " gets " + player2.getScore() + " points!");
        
        switch (winnerDecision(player1, player2))
        {
            case 1:
                System.out.println(player1.getName() + " is the winner!");
                break;
            case 2:
                System.out.println(player2.getName() + " is the winner!");    
                break;
            case 3:
                System.out.println("Meh! We would call it an even!");
                break;
            default:
                System.out.println(" ");
                break;
        }
    }
    
    /**
     * Displays a player's status after a turn.
     */
    public void displayStatusAfterTurn(Player player)
    {
        System.out.println("After this turn, " + player.getName() + " is in " + (player.getPosition() + 1) + " with " + player.getScore() + " points!");
    }
    
    /**
     * Visualises the position of the two players, and the trail.
     * 
     * @param player1 The player #1 in the game.
     * @param player2 The player #2 in the game.
     */
    public void displayTrail(Player player1, Player player2)
    {      
        System.out.println(catTrailFlags());
        System.out.println(catPlayerPosition(player1));
        System.out.println(catPlayerPosition(player2));
        System.out.println(catTrailRoad());
    }
    
    /**
     * Displays welcome message.
     */
    public void displayWelcome()
    {
        System.out.println('\u000C');
        System.out.println("*********************************");
        System.out.println("*                               *");
        System.out.println("* Welcome to Nature Trail Game! *");
        System.out.println("*                               *");
        System.out.println("*********************************");
        input.continueWithClear("continue");
    }
    
    /**
     * Displays the each player's dice result while deciding who goes first.
     * 
     * @param decisionArray An array that stores the dices' results.
     * @param playerArray An array that stores the players.
     */
    public void displayWhoGoesFirstProcess(int[] decisionArray, Player[] playerArray)
    {
        for (int i = 0; i < decisionArray.length; i++)
            System.out.println(playerArray[i].getName() + " gets " + decisionArray[i] + "!");
    }
    
    /**
     * Displays a prompt to notify user to roll the dice to decide who goes first
     */
    public void displayWhoGoesFirstPrompt()
    {
        System.out.println("Time to decide who goes first!");
        input.continueWithoutClear("roll the dice with the computer");
    }
    
    /**
     * Displays the result of the decision of which player will go first.
     * 
     * @param decisionArray An array that stores the dices' results.
     * @param playerArray An array that stores the players.
     */
    public void displayWhoGoesFirstResult(int[] decisionArray, Player[] playerArray)
    {
        if (decisionArray[0] == decisionArray[1])
        {
            System.out.println("Even! Roll again!");
            input.continueWithoutClear("roll again");
        }
        else if (decisionArray[0] > decisionArray[1])
        {
            System.out.println("You'll be the pioneer, traveller!");
            input.continueWithClear("continue");
        }
        else
        {
            System.out.println("Try to catch up, traveller!");
            input.continueWithClear("continue");
        }
    }
    
    /**
     * Returns a single animal element.
     * 
     * @param index The index of the element, will be checked if it's legal.
     * @return If the index is legal, returns the element, otherwise returns a defaultly constructed Animal-typed object.
     */
    public Animal getAnimal(int index)
    {
        if (index >= 0 && index < animals.length)
            return animals[index];
        else
        {
            Animal outOfBoundReturn = new Animal();
            return outOfBoundReturn;
        }
    }
    
    /**
     * Returns all the animals.
     * 
     * @return The animals array, as a whole.
     */
    public Animal[] getAnimals()
    {
        return animals;
    }
    
    /**
     * Returns the trail length of the game.
     * 
     * @return The trail length of the game.
     */
    public int getTrailLength()
    {
        return trailLength;
    }
    
    /**
     * Allows users to input the name of a player from the console.
     * 
     * @param player The player whose name the user wants to input.
     */
    public void inputPlayerName(Player player)
    {
        String newPlayerName = "";
                
        do
        {
            newPlayerName = input.acceptStringInput("your name");
            
            if (!player.setName(newPlayerName))
                displayIllegalName();
        } while (!player.setName(newPlayerName));
        
        displayLegalName();
        input.continueWithClear("continue");
    }
    
    /**
     * Allows users to input the name of a player from the console.
     */
    public void inputTrailLength()
    {
        int newTrailLength = 0;
                
        do
        {
            newTrailLength = input.acceptIntegerInput("the trail length");
            
            if (newTrailLength < 10 || newTrailLength > 20)
                displayIllegalTrailLength();
        } while (newTrailLength < 10 || newTrailLength > 20);
        
        displayLegalTrailLength();
        input.continueWithClear("continue");
        trailLength = newTrailLength;
    }
    
    /**
     * Player's the behaviour when running into an animal, or when he didn't meet an animal.
     * 
     * @param player The player who runs into an animal, or when he didn't meet an animal.
     */
    public void meetAnimal(Player player)
    {
        Dice dice = new Dice(9, 0);
        int index = dice.generateRandomInteger();
        boolean hasMet = (animals[index].getType().length() != 0);
                    
        if (hasMet)
            player.setScore(animals[index].getPoints());
        
        displayAnimalSighting(hasMet, player, index);
    }
       
    /**
     * Player's the behaviour when running into an nature feature, or when he didn't meet an nature feature.
     * 
     * @param player The player who runs into an nature feature, or when he didn't meet an nature feature.
     * @param trail The trail where the nature features lie.
     */
    public void meetNatureFeature(Player player, Trail trail)
    {
        boolean hasMet = false;
        
        int i = 0;
        while(i < trail.getFeatures().length)
        {
            if (player.getPosition() == trail.getFeature(i).getFeaturePosition())
            {
                player.movePosition(trail.getFeature(i).getSpacePenalty());
                hasMet = true;
                break;
            }
            else
                i++;
        }
        
        displayNatureFeatureSighting(hasMet, player, trail, i);
    }
  
    /**
     * Controls the behaviour of one player in one turn.
     * 
     * @param player The player in the current turn.
     */
    public void playerTakeTurn(Player player)
    {
        Dice dice = new Dice();
        int step = dice.generateRandomInteger();
        
        System.out.println("It's " + player.getName() + "'s turn!");
        
        if (!player.getName().startsWith("Computer"))
            input.continueWithoutClear("roll the dice");
        
        player.movePosition(step);
        System.out.println("Great! " + player.getName() + " is moving forward " + step + " steps!");
        
        if (player.getPosition() < (trailLength - 1))
        {
            meetAnimal(player);
            
            meetNatureFeature(player, natureTrail);
        }
        
        playerReachedTheFinal(player);
        
        displayTrail(playerOne, playerTwo);
        
        displayStatusAfterTurn(player);
        
        input.continueWithClear("continue");
    }
    
    /**
     * A player's behaviour when it has reached the finish line.
     */
    public void playerReachedTheFinal(Player player)
    {
        if (player.getPosition() >= (trailLength - 1))
        {
            player.setScore(10);
            player.setPosition((trailLength - 1));
            displayPlayerReachedTheFinal(player);
        }
    }
    
    
    /**
     * Allows users to change a single animals' element.
     * 
     * @param index The index of the element, will be check if it's legal.
     * @param type The name of type the animal.
     * @param points The points of the animal.
     */
    public void setAnimal(int index, String type, int points)
    {
        if (index >= 0 && index < animals.length)
        {
            animals[index].setType(type);
            animals[index].setPoints(points);
        }
    }
    
    /**
     * Allows the user to change the animals array as a whole.
     * 
     * @param newAnimals The new animals array.
     */
    public void setAnimals(Animal[] newAnimals)
    {
        animals = newAnimals;
    }
    
    /**
     * Allows users to change the trail length.
     * 
     * @param newTrailLength The new trail length.
     */
    public void setTrailLength(int newTrailLength)
    {
        trailLength = newTrailLength;
    }
    
    /**
     * Controls the whole game process.
     */
    public void startGame()
    {
        displayWelcome();
        inputTrailLength();
        inputPlayerName(playerOne);
        allocateAnimals();
        allocateFeatures(natureTrail);
        takingTurns(whoGoesFirst(playerOne, playerTwo), playerOne, playerTwo);      
        displayResult(playerOne, playerTwo);
    }
    
    /**
     * Controls how two players take turns to play.
     * 
     * @param sequence The sequence code, 1 means player #1 goes first, 2 means player #2 goes first.
     * @param player1 The player #1.
     * @param player2 The player #2.
     */
    public void takingTurns(int sequence, Player player1, Player player2)
    {
        if (sequence == 1)
            while (player1.getPosition() < (trailLength - 1) && player2.getPosition() < (trailLength - 1))
            {
                playerTakeTurn(player1);
                
                if (player1.getPosition() == (trailLength - 1))
                    break;
                
                playerTakeTurn(player2);
            }
        else
            while (player1.getPosition() < (trailLength - 1) && player2.getPosition() < (trailLength - 1))
            {
                playerTakeTurn(player2);
                
                if (player2.getPosition() == (trailLength - 1))
                    break;
                
                playerTakeTurn(player1);
            }
    }
    
    /**
     * Decides which player is the winner.
     * 
     * @param player1 Player #1.
     * @param player2 Player #2.
     * @return The result code. 1 stands for player1, 2 stands for player2, 3 stands for an even game.
     */
    public int winnerDecision(Player player1, Player player2)
    {
        if (player1.getScore() > player2.getScore())
            return 1;
        else if ( player1.getScore() < player2.getScore())
            return 2;
        else
            return 3;
    }
    
    
    /**
     * Decides in which sequence the two players play the game.
     * 
     * @return A sequence code, 1 means player #1 goes first, 2 means player #2 goes first.
     */
    public int whoGoesFirst(Player player1, Player player2)
    {
        int[] startDecision = new int[2];
        Player[] playerArray = new Player[2];
        Dice dice = new Dice();        
        playerArray[0] = player1;
        playerArray[1] = player2;
        
        displayWhoGoesFirstPrompt();
        
        do
        {
            for (int i = 0; i < startDecision.length; i++)
            {
                startDecision[i] = dice.generateRandomInteger();
            }
            
            displayWhoGoesFirstProcess(startDecision, playerArray);
            
            displayWhoGoesFirstResult(startDecision, playerArray);
        } while (startDecision[0] == startDecision[1]);
        
        return (startDecision[0] > startDecision[1] ? 1 : 2);
    }   
}