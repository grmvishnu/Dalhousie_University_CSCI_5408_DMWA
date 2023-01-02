package filtrationengine;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

public class MongoConnect
{
    public static void connectToMongo(List<String> fileData)
    {
        try
        {
            String url = "mongodb+srv://dbUser:dbUserPassword@dmwa-assignment-4.ra1xx.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
            MongoClient mongoClient = MongoClients.create(url);
            MongoDatabase db = mongoClient.getDatabase("myMongoTweet");
            MongoCollection<Document> collection = db.getCollection("CleanedData");
            for(String str : fileData)
            {
                collection.insertOne(Document.parse(str));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
