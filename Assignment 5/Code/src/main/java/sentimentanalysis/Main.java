package sentimentanalysis;

import java.io.File;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String filePath = "Input.txt";
        List<List<String>> tableRows = new ArrayList<>();
        List<String> header = Arrays.asList("Tweets", "Message", "Match", "Polarity");

        File input = new File(filePath);
        Scanner sc = new Scanner(input);
        int tweetNumber = 0;
        tableRows.add(header);
        while (sc.hasNextLine())
        {
            String tweet = sc.nextLine();
            Map<String, Integer> bagWords =  Problem2.bagOfWords(tweet);
            tweetNumber = tweetNumber + 1;
            Problem2.setTableRows(tableRows, tweetNumber, tweet, bagWords);
            bagWords.clear();
        }

        Problem2.printTabularForm(tableRows);
        Problem2.generateOutputFile(tableRows);
    }
}
