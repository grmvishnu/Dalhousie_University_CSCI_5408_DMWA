import java.sql.*;

public class SecondTransaction extends Thread
{
    String startTrans = "START TRANSACTION";
    String endTrans = "COMMIT";
    String query1 = "Update annualticketsales set `TICKETS SOLD` = 0 where YEAR = 2011;";
    String query2 = "Select `TICKETS SOLD` from annualticketsales where YEAR = 2011;";

    ExtendedReadWriteLock extended = ExtendedReadWriteLock.getInstance();
    String done = "";
    Connection connect2;
    ResultSet rs;
    ResultSetMetaData rsmd;
    Statement stat;

    public SecondTransaction(Connection connect2) throws SQLException
    {
        this.connect2 = connect2;
        stat = connect2.createStatement();
    }

    @Override
    public void run()
    {
        try
        {
            transaction();
        }
        catch (SQLException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public boolean acquire_locks(String word)
    {
        boolean j = false;

        if(word.equalsIgnoreCase("read"))
        {
            while(! extended.downgradingLock(this, "read"));
            j = true;
        }
        else if(word.equalsIgnoreCase("write"))
        {
            while(! extended.acquiringWriteLock(this));
            j = true;
        }

        return j;
    }

    public void transaction() throws SQLException, InterruptedException
    {
        System.out.println("Transaction2 has started.");

        sleep(200);

        connect2.setAutoCommit(false);

        stat.execute(startTrans);

        acquire_locks("write");

        System.out.println("Write lock has been acquired in T2.");

        stat.execute(query1);

        System.out.println("First query got executed in T2.");

        acquire_locks("read");

        System.out.println("Write lock has been downgraded to read lock. So, read lock has been acquired in T2.");

        rs = stat.executeQuery(query2);

        System.out.println("Second query got executed in T2.");

        System.out.println("The result of the query is:");

        rsmd = rs.getMetaData();
        int columnsNumber2 = rsmd.getColumnCount();
        while(rs.next())
        {
            for (int i = 1; i <= columnsNumber2; i++)
            {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }

        stat.execute(endTrans);

        sleep(100);

        System.out.println("Transaction2 has been committed.");

        release_locks("read");

        System.out.println("Read lock has been released in T2. There are no locks on the database anymore.");

        connect2.setAutoCommit(true);
    }

    public boolean release_locks(String word)
    {
        boolean j = false;

        if(word.equalsIgnoreCase("read"))
        {
            while(! extended.releasingReadLock(this));
            j = true;
        }
        else if(word.equalsIgnoreCase("write"))
        {
            while(! extended.releasingWriteLock(this));
            j = true;
        }

        return j;
    }
}
