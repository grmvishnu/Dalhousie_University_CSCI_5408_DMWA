package filtrationengine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Cleaning
{
    static List<String> fileData;
    static List<String> tempData;

    public static void replace(String emojis, String urls, String neededchar)
    {
        tempData = new ArrayList<>();
        fileData = new ArrayList<>();

        try
        {
            for(int i = 1; i <= 42; i++)
            {
                BufferedReader bw = new BufferedReader(new FileReader
                        ("C:\\Users\\AVuser\\IdeaProjects\\DMWA_Assignment4\\rawdata\\File" + i + ".json"));
                while(bw.ready())
                {
                    tempData.add(bw.readLine());
                }
            }

            for(String each : tempData)
            {
                each = each.replaceAll(emojis, "");

                each = each.replaceAll(urls, "");

                each = each.replaceAll("[\\\\] + [r]", "");

                each = each.replaceAll("[\\\\] + [b]", "");

                each = each.replaceAll("[\\\\] + [t]", "");

                each = each.replaceAll("[\\\\] + [n]", "");

                each = each.replaceAll(neededchar, "");

                fileData.add(each.trim());
            }

            MongoConnect.connectToMongo(fileData);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
