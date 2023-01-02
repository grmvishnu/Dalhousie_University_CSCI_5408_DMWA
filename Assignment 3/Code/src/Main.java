import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Connection connect1;
            Connection connect2;

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3_dmwa", "root",
                    "Wishhh@2021");
            connect2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3_dmwa", "root",
                    "Wishhh@2021");

            FirstTransaction f = new FirstTransaction(connect1);
            SecondTransaction s = new SecondTransaction(connect2);

            f.setName("ThreadOne");
            s.setName("SecondOne");

            Random rand = new Random();
            int upper = 10;
            int a = rand.nextInt(upper);
            int b = rand.nextInt(upper);
            f.setPriority(a);
            s.setPriority(b);

            f.start();
            s.start();

            if(s.done.equals("DONE"))
            {
                f.stop();
                s.stop();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
