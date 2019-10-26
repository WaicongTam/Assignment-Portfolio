import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * The FileIO class handles all the file reading and wrting.
 * 
 * @author Weicong Tan Charles
 * @version 1.0 (19-May-2019)
 */
public class FileIO
{
    private String fileName;

    /**
     * Initialises a FileIO object with default file name.
     */
    public FileIO()
    {
        fileName = "default.txt";
    }

    /**
     * Initialises a FileIO object with customised file name.
     * 
     * @param newFileName The customised file name.
     */
    public FileIO(String newFileName)
    {
        fileName = newFileName;
    }

    /**
     * Accessor of the file name.
     * 
     * @return The name of the file.
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * Read file to an ArrayList.
     * 
     * @return The list of the information.
     */    
    public ArrayList<String> readingFile()
    {
        ArrayList<String> list = new ArrayList<>();
        
        try
        {
            FileReader fr = new FileReader(fileName);
            try
            {
                Scanner parser = new Scanner(fr);
                
                while (parser.hasNextLine())
                {
                    String item = parser.nextLine();
                    list.add(item);
                }
            }
            finally
            {
                fr.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName + "not found!");
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O exception happened! Aborting...");
        }
        
        return list;
    }

    /**
     * Mutator of the file name.
     * 
     * @param newFileName The new file name.
     * @return true if the file name was successfully set.
     */
    public boolean setFileName(String newFileName)
    {
        try
        {
            validFileName(newFileName);
            fileName = newFileName;
            return true;    
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }

    /**
     * Validates the new file name
     * 
     * @param newFileName The new file name.
     * @throws IllegalArgumentException when the new file name is blank or does not have an txt extension.
     */
    private static void validFileName(String newFileName) throws IllegalArgumentException
    {
        if (newFileName.length() < 1 || !newFileName.endsWith(".txt"))
            throw new IllegalArgumentException("Illegal file name.");
    }

    /**
     * Writes content to a file.
     * 
     * @param fileName The name of the file.
     * @param content The content to be written to the file.
     */
    public void writingFile(String content)
    {
        try
        {
            PrintWriter output = new PrintWriter(fileName);
            output.println(content);
            output.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
}