package semanticanalysis;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Problem3
{
    static Map<String, Integer> wordFrequency = new HashMap<>();
    static List<Double> logValues = new ArrayList<>();
    static HashMap<String, Double> relativeFrequency = new HashMap<>();

    public Problem3() {}

    public static void termFrequency(String searchWord, List<String> tweets, int noOfTweets)
    {
        for(int i = 0; i < noOfTweets; i++)
        {
            String[] lineSplit = tweets.get(i).split("\\W+");
            for(String word : lineSplit)
            {
                if(word.equals(searchWord))
                {
                    if(wordFrequency.containsKey(searchWord))
                    {
                        int count = wordFrequency.get(searchWord);
                        wordFrequency.replace(searchWord, count + 1);
                    }
                    else
                    {
                        wordFrequency.put(searchWord, 1);
                    }
                }
            }
        }
    }

    public static void createTfIdfTable(String[] searchWords, int noOfTweets)
    {
        Formatter fmt1 = new Formatter();
        System.out.println();
        fmt1.format("Below is the tf-idf table:\n");
        fmt1.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        fmt1.format("%15s %9s\n", "Total Documents", noOfTweets);
        fmt1.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        fmt1.format("%15s %30s %20s %30s\n","Search Query","Documents having term(df)","N/df","Log10(N/df)");
        fmt1.format("-------------------------------------------------------------------------------------------------" +
                "----\n");

        logValues.add(0, Math.log10((double) noOfTweets / wordFrequency.get("weather")));
        logValues.add(1, Math.log10((double) noOfTweets / wordFrequency.get("people")));
        logValues.add(2, Math.log10((double) noOfTweets / wordFrequency.get("condition")));

        fmt1.format("%15s %30s %20s %30s\n", searchWords[0], wordFrequency.get("weather"), noOfTweets+"/"+
                wordFrequency.get("weather"), logValues.get(0));
        fmt1.format("%15s %30s %20s %30s\n", searchWords[1], wordFrequency.get("people"), noOfTweets+"/"+
                wordFrequency.get("people"), logValues.get(1));
        fmt1.format("%15s %30s %20s %30s\n", searchWords[2], wordFrequency.get("condition"), noOfTweets+"/"+
                wordFrequency.get("condition"), logValues.get(2));
        fmt1.format("-------------------------------------------------------------------------------------------------" +
                "----\n");

        System.out.println(fmt1);
        generateOutputFile(fmt1);
    }

    public static void createSecondTable(List<String> tweets, int noOfTweets)
    {
        Formatter fmt2 = new Formatter();
        HashMap<String, Integer> unsortedWeatherTweets = new HashMap<>();
        HashMap<String, Integer> sortedTweetsList = new HashMap<>();
        boolean descending = false;

        for(int i = 0; i < noOfTweets; i++)
        {
            String[] lineSplit = tweets.get(i).split("\\W+");
            for(String word : lineSplit)
            {
                if(word.toLowerCase(Locale.ROOT).equals("weather"))
                {
                    if(!unsortedWeatherTweets.containsKey(tweets.get(i)))
                    {
                        unsortedWeatherTweets.put(tweets.get(i), 1);
                    }
                    else if(unsortedWeatherTweets.containsKey(tweets.get(i)))
                    {
                        int weatherWords = unsortedWeatherTweets.get(tweets.get(i));
                        unsortedWeatherTweets.replace(tweets.get(i), weatherWords + 1);
                    }
                }
            }
        }

        System.out.println();
        System.out.println();
        fmt2.format("\nBelow is the term frequency table:\n");
        fmt2.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        fmt2.format("%4s %54s\n", "Term", "weather");
        fmt2.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        fmt2.format("%10s %18s %50s\n", "Total words(m)", "Frequency(f)", "Weather appeared in " +
                unsortedWeatherTweets.size() + " documents");
        fmt2.format("-------------------------------------------------------------------------------------------------" +
                "----\n");

        sortedTweetsList = sortByValue(unsortedWeatherTweets, descending);

        final int count = 0;
        sortedTweetsList.forEach((key, value) -> {
            String[] words = key.split("\\W+");
            double freq = ((double) value) / ((double) words.length);
            relativeFrequency.put(key, freq);
            fmt2.format("%10s %25s %30s\n", words.length, value + "          ", key);
                }
        );

        fmt2.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        System.out.println(fmt2);
        generateOutputFile(fmt2);
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsortedList, boolean desc)
    {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(unsortedList.entrySet());

        entryList.sort((object1, object2) -> desc ? object1.getValue().compareTo(object2.getValue()) == 0
                ? object1.getKey().compareTo(object2.getKey())
                : object1.getValue().compareTo(object2.getValue()) : object2.getValue().compareTo(object1.getValue())
                == 0 ? object2.getKey().compareTo(object1.getKey()) : object2.getValue().compareTo(object1.getValue()));

        return entryList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (x, y) -> y, LinkedHashMap::new));
    }

    public static void generateOutputFile(Formatter fmt)
    {
        try
        {
            File outputFile = new File("C:\\Users\\AVuser\\IdeaProjects\\DMWA_Assignment5\\Problem3_Output.txt");
            FileWriter writer = new FileWriter(outputFile, true);
            writer.write(String.valueOf(fmt));
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void highestRelativeFreq()
    {
        Formatter fmt3 = new Formatter();
        HashMap<String, Double> temp = sortByDouble(relativeFrequency, false);
        Map.Entry<String, Double> entry = temp.entrySet().iterator().next();

        System.out.println();
        fmt3.format("\nBelow is the tweet which has the highest relative frequency (f/m):\n");
        fmt3.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        fmt3.format("Tweet: " + entry.getKey() + "\n");
        fmt3.format("Relative Frequency: " + entry.getValue() + "\n");
        fmt3.format("-------------------------------------------------------------------------------------------------" +
                "----\n");
        System.out.println(fmt3);
        generateOutputFile(fmt3);
    }

    public static HashMap<String, Double> sortByDouble(HashMap<String, Double> unsortedList, boolean ans)
    {
        List<Map.Entry<String, Double>> entryList = new LinkedList<>(unsortedList.entrySet());

        entryList.sort((object1, object2) -> ans ? object1.getValue().compareTo(object2.getValue()) == 0
                ? object1.getKey().compareTo(object2.getKey())
                : object1.getValue().compareTo(object2.getValue()) : object2.getValue().compareTo(object1.getValue())
                == 0 ? object2.getKey().compareTo(object1.getKey()) : object2.getValue().compareTo(object1.getValue()));

        return entryList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (x, y) -> y, LinkedHashMap::new));
    }
}
