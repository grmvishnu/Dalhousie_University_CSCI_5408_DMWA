package semanticanalysis;

import java.io.File;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String[] searchWords = {"weather", "people", "condition"};
        String filePath = "Input.txt";
        List<String> tweets = new ArrayList<>();
        File myFile = new File(filePath);
        Scanner sc = new Scanner(myFile);
        while(sc.hasNextLine())
        {
            String data = sc.nextLine();
            tweets.add(data);
        }

        int noOfTweets = tweets.size();

        for (String searchWord : searchWords)
        {
            Problem3.termFrequency(searchWord, tweets, noOfTweets);
        }

        Problem3.createTfIdfTable(searchWords, noOfTweets);

        Problem3.createSecondTable(tweets, noOfTweets);

        Problem3.highestRelativeFreq();
    }
}
