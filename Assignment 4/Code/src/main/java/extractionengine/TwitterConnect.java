package extractionengine;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

public class TwitterConnect
{
    public void extractData(String bearerToken) throws IOException, InterruptedException
    {
        FileWriting writeVariable = new FileWriting();
        String url1 = "https://api.twitter.com/2/tweets/search/recent?max_results=100&tweet.fields=referenced_tweets,created_at,author_id,source,lang&place.fields=country,geo&query=mask%20lang%3Aen";
        String url2 = "https://api.twitter.com/2/tweets/search/recent?max_results=100&tweet.fields=referenced_tweets,created_at,author_id,source,lang&place.fields=country,geo&query=cold%20lang%3Aen";
        String url3 = "https://api.twitter.com/2/tweets/search/recent?max_results=100&tweet.fields=referenced_tweets,created_at,author_id,source,lang&place.fields=country,geo&query=immune%20lang%3Aen";
        String url4 = "https://api.twitter.com/2/tweets/search/recent?max_results=100&tweet.fields=referenced_tweets,created_at,author_id,source,lang&place.fields=country,geo&query=vaccine%20lang%3Aen";
        String url5 = "https://api.twitter.com/2/tweets/search/recent?max_results=100&tweet.fields=referenced_tweets,created_at,author_id,source,lang&place.fields=country,geo&query=flu%20lang%3Aen";
        String url6 = "https://api.twitter.com/2/tweets/search/recent?max_results=100&tweet.fields=referenced_tweets,created_at,author_id,source,lang&place.fields=country,geo&query=snow%20lang%3Aen";

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest1 = HttpRequest.newBuilder()
                .uri(URI.create(url1))
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .build();
        HttpRequest httpRequest2 = HttpRequest.newBuilder()
                .uri(URI.create(url2))
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .build();
        HttpRequest httpRequest3 = HttpRequest.newBuilder()
                .uri(URI.create(url3))
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .build();
        HttpRequest httpRequest4 = HttpRequest.newBuilder()
                .uri(URI.create(url4))
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .build();
        HttpRequest httpRequest5 = HttpRequest.newBuilder()
                .uri(URI.create(url5))
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .build();
        HttpRequest httpRequest6 = HttpRequest.newBuilder()
                .uri(URI.create(url6))
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", bearerToken))
                .build();

        for(int i = 1; i <= 7; i++)
        {
            HttpResponse<String> response = httpClient.send(httpRequest1, HttpResponse.BodyHandlers.ofString());
            writeVariable.writeToFiles(i, response.body());
        }

        for(int i = 8; i <= 14; i++)
        {
            HttpResponse<String> response = httpClient.send(httpRequest2, HttpResponse.BodyHandlers.ofString());
            writeVariable.writeToFiles(i, response.body());
        }

        for(int i = 15; i <= 21; i++)
        {
            HttpResponse<String> response = httpClient.send(httpRequest3, HttpResponse.BodyHandlers.ofString());
            writeVariable.writeToFiles(i, response.body());
        }

        for(int i = 22; i <= 28; i++)
        {
            HttpResponse<String> response = httpClient.send(httpRequest4, HttpResponse.BodyHandlers.ofString());
            writeVariable.writeToFiles(i, response.body());
        }

        for(int i = 29; i <= 35; i++)
        {
            HttpResponse<String> response = httpClient.send(httpRequest5, HttpResponse.BodyHandlers.ofString());
            writeVariable.writeToFiles(i, response.body());
        }

        for(int i = 36; i <= 42; i++)
        {
            HttpResponse<String> response = httpClient.send(httpRequest6, HttpResponse.BodyHandlers.ofString());
            writeVariable.writeToFiles(i, response.body());
        }
    }
}
