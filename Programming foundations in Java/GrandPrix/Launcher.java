/**
 * The Launcher launches the Grand Prix.
 * 
 * @author Weicong Tan Charles
 * @version 1.0.0 (22-May-2019)
 */
public class Launcher
{
    public Launcher()
    {
        
    }
    
    /**
     * Launches the Grand Prix.
     */
    public static void main(String[] args)
    {
        Championship champ = new Championship();
        champ.startGrandPrix();
    }
}