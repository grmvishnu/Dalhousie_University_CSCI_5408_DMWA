package extractionengine;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        String bearerToken = "AAAAAAAAAAAAAAAAAAAAANIuZwEAAAAAsQtOcCykZKSAaIjL3irqz0p0ztg%3DcLnaRW8O35wu9Bo" +
                "WZKDw8CKYZ9OgrMqcHQPjmnzgRw7th19i6d";
        TwitterConnect connect = new TwitterConnect();

        if (bearerToken != null && bearerToken.length() != 0)
        {
            connect.extractData(bearerToken);
        }
        else
        {
            System.out.println("There was a problem getting you bearer token. " +
                    "Please make sure the BEARER TOKEN is correct");
        }
    }
}
