/**
 * The Animal class describes the attributes of an animal.
 *
 * @author Weicong Tan Charles
 * @version 1.0.0 (2 Apr 2019)
 */
public class Animal
{
    private String type;
    private int points;
    
    /**
     * Initialises the object with blank name and no points.
     */
    public Animal()
    {
        type = "";
        points = 0;
    }
    
    /**
     * Initialises the object with certain types and points.
     * 
     * @param newType The name of the type of the new Animal-typed object.
     * @param newPoints The points of new Animal-typed object.
     */
    public Animal(String newType, int newPoints)
    {
        type = newType;
        points = newPoints;
    }
    
    /**
     * Returns the points of the object.
     * 
     * @return The points of the object.
     */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Returns the name of the type of the object.
     * 
     * @return The name of the type of the object.
     */
    public String getType()
    {
        return type;
    }

    /**
     * Allows users to set the points of the object.
     * 
     * @param newPoints The points the users wants to set to the object.
     */
    public void setPoints(int newPoints)
    {
        points = newPoints;
    }
    
    /**
     * Allows users to set the name of the type of the object.
     * 
     * @param newType The name of the type of the object the users wants to set to the object.
     */
    public void setType(String newType)
    {
        type = newType;
    }
}