import java.util.*;
import java.io.*;
/**
 * The Input class takes input from the user and outputs to a file; 
 *
 * @author Weicong Tan Charles
 * @version 1.0 (13-May-2019)
 */
public class Input
{
    /**
     * Constructor for objects of class UserIO
     */
    public Input()
    {
        
    }
    
    /**
     * Accepts player's input of int values, 
     * also concatenate's the value passed into the method with certain words to display a prompt.
     * 
     * @param displayMessage The information the user desires to be concatenated into the prompt.
     * @return The integer that the user inputs.
     */
    public static int acceptIntegerInput(String displayMessage)
    {
        String value = "";
        int int_value = 0;
        Scanner console = new Scanner(System.in);
        
        do
        {
            System.out.print("Please input " + displayMessage + ": ");
            value = console.nextLine();
            
            if (!isInteger(value))
                System.out.println("This is not even a integer!");
            
        } while (value.length() == 0 || !isInteger(value));
        
        int_value = Integer.parseInt(value);
        
        return int_value;
    }
    
    /**
     * Accepts player's input of String values, 
     * also concatenate's the value passed into the method with certain words to display a prompt.
     * 
     * @param displayMessage The information the user desires to be concatenated into the prompt.
     * @return The String that the user inputs.
     */
    public static String acceptStringInput(String displayMessage)
    {
        String value = " ";
        Scanner console = new Scanner(System.in);
        
        System.out.print("Please input " + displayMessage + ": ");
        value = console.nextLine();
        
        return value;
    }
        
    /**
     * Allow user to interact with the program by pressing enter; 
     * after doing so, the terminal will be cleared.
     * 
     * @param displayMessage The information the user desires to be concatenated into the prompt.
     */
    public static void continueWithClear(String displayMessage)
    {
        Scanner console = new Scanner(System.in);        
        
        System.out.println("Press enter to " + displayMessage + " ...");
        console.nextLine();
        System.out.println('\u000C');
    }
    
    /**
     * Allow user to interact with the program by pressing enter without clearing the terminal. 
     * 
     * @param displayMessage The information the user desires to be concatenated into the prompt.
     */
    public static void continueWithoutClear(String displayMessage)
    {
        Scanner console = new Scanner(System.in);        
        
        System.out.println("Press enter to " + displayMessage + " ...");
        console.nextLine();
    }
    
    private static boolean isInteger(String input)
    {
        boolean validation = true;
        int dotCounter = 0;
        if (input.length() != 0 && (input.charAt(0) == '-' || Character.isDigit(input.charAt(0))))
            for (int i = 1; i < input.length(); i++)
            {
                if (!Character.isDigit(input.charAt(i)))
                {
                        validation = false;
                        break;
                }
            }
        else
            validation = false;   

        return validation;
    }  
}
