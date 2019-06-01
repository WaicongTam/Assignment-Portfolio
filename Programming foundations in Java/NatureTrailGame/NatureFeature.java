/**
 * The NatureFeature class describes the attributes of the nature feature, 
 * including its position on the trail, its type, 
 * and the penalty will occur when a player runs into one.
 *
 * @author Weicong Tan Charles
 * @version 1.0.0 (23 Mar 2019)
 */
public class NatureFeature
{
    private int featurePosition;
    private String featureType;
    private int spacePenalty;
    
    /**
     * Initialize the new NatureFeature object with int fields as 0 and String fields as blank.
     */
    public NatureFeature()
    {
        featurePosition = 0;
        featureType = "";
        spacePenalty = 0;
    }
    
    /**
     * Construct a NatureFeature object with the customized value of all the fields.
     * 
     * @param newFeaturePosition The customized position of the object.
     * @param newFeatureType The customized type of the object.
     * @param newSpacePenalty The customized space penalty of the object.
     */
    public NatureFeature(int newFeaturePosition, String newFeatureType, int newSpacePenalty)
    {
        featurePosition = newFeaturePosition;
        featureType = newFeatureType;
        spacePenalty = newSpacePenalty;
    }
        
    /**
     * Accessor of current position on the trail of the object.
     * 
     * @return The current position on the trail of the object.
     */
    public int getFeaturePosition()
    {
        return featurePosition;
    }
    
    /**
     * Accessor of the name of the type of the object.
     * 
     * @return The name of the type of the object.
     */
    public String getFeatureType()
    {
        return featureType;
    }
    
    /**
     * Accessor of space penalty when a player runs into the object.
     * 
     * @return The type of the object.
     */
    public int getSpacePenalty()
    {
        return spacePenalty;
    }
    
    /**
     * A mutator that allows the user to directly set the position of the object.
     * 
     * @param newFeaturePosition A value to be set as the feature's position on the trail.
     */
    public void setFeaturePosition(int newFeaturePosition)
    {
        featurePosition = newFeaturePosition;
    }
    
    /**
     * A mutator that allows the user to directly set the type of the object.
     * 
     * @param newFeatureType A value to be set as the feature's name of its type on the trail.
     */
    public void setFeatureType(String newFeatureType)
    {
        featureType = newFeatureType;
    }
    
    /**
     * A mutator that allows the user to directly set the space penalty of the object.
     * 
     * @param newSpacePenalty A value to be set as the space penalty of the object.
     */
    public void setSpacePenalty(int newSpacePenalty)
    {
        spacePenalty = newSpacePenalty;
    }
}