package extractionengine;
import java.io.File;
import java.io.FileWriter;

public class FileWriting
{
    public void writeToFiles(int count, String search)
    {
        try
        {
            String fileType = ".json";
            String fileName = "File" + count;
            String filePath = "C:\\Users\\AVuser\\IdeaProjects\\DMWA_Assignment4\\rawdata\\";
            File myFile = new File(filePath + fileName + fileType);
            FileWriter myWriter = new FileWriter(myFile);
            myWriter.write(search);
            myWriter.close();
        }
        catch (Exception e)
        {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
