/**
 * The Trail class stores an array of the nature features on the trail
 *
 * @author Weicong Tan Charles
 * @version 1.0.0 (23 Mar 2019)
 */
public class Trail
{
    private NatureFeature[] features;
    
    /**
     * Initializes the object prescribing the initial size of the array as 4, and initializes each element. 
     */
    public Trail()
    {
        features = new NatureFeature[4];
        
        for (int i = 0; i < features.length; i++)
            features[i] = new NatureFeature();
    }
    
    /**
     * Initializes the object with the user-customized size of the array, also allows user input a customized object to initialize the array.
     * 
     * @param newLength
     * @param newFeature
     */
    public Trail(int newLength, NatureFeature newFeature)
    {
        features = new NatureFeature[newLength];
        
        for (int i = 0; i < newLength; i++)
            features[i] = newFeature;
    }
    
    /**
     * Returns one single element of the array; if the index is not larger or equal to 0 and smaller than the length of the array,
     * returns a default initialized object of type of the element.
     * 
     * @param index The index of the element that the user wants to get access to.
     * @return The particular element with the passed index in the array.
     */
    public NatureFeature getFeature(int index)
    {
        if (index >= 0 && index < features.length)
            return features[index];
        else
        {    
            NatureFeature outOfBoundReturn = new NatureFeature();
            return outOfBoundReturn;
        }
    }
    
    /**
     * Returns the whole array.
     * 
     * @return The whole array.
     */
    public NatureFeature[] getFeatures()
    {
        return features;
    }
    
    /**
     * Presets the array with the features mentioned in the specification.
     */
    public void presetFeatures()
    {
        setFeature(0, 0, "Creek", -2);
        setFeature(1, 0, "Bridge", 4);
        setFeature(2, 0, "Fallen tree", -3);
        setFeature(3, 0, "Landslide", -5);
    }
    
    /**
     * Allows the user to change all the attributes of the a single element of the array; 
     * checks if the index is larger or equal to 0 and smaller than the length of the array.
     * 
     * @param index The index of the element which the user wants to change.
     * @param position The desired position of that element.
     * @param type The desired type of that element.
     * @param penalty The desired penalty of that element.
     */
    public void setFeature(int index, int position, String type, int penalty)
    {
        if (index >= 0 && index < features.length)
        {
            features[index].setFeaturePosition(position);
            features[index].setFeatureType(type);
            features[index].setSpacePenalty(penalty);
        }
    }
    
    /**
     * Allow users to input a whole new array to replace the original one.
     * 
     * @param newFeatures The new array.
     */
    public void setFeatures(NatureFeature[] newFeatures)
    {
        features = newFeatures;
    }
}