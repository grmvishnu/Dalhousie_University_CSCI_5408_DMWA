import java.sql.*;

public class FirstTransaction extends Thread
{
    String startTrans = "START TRANSACTION";
    String endTrans = "COMMIT";
    String query1 = "Select `TICKETS SOLD` from annualticketsales where YEAR = 2011;";
    String query2 = "Update annualticketsales set `TICKETS SOLD` = 0 where YEAR = 2011;";

    ExtendedReadWriteLock extended = ExtendedReadWriteLock.getInstance();
    Connection connect1;
    ResultSet rs;
    ResultSetMetaData rsmd;
    Statement stat;

    public FirstTransaction(Connection connect1) throws SQLException
    {
        this.connect1 = connect1;
        stat = connect1.createStatement();
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
        boolean i = false;

        if(word.equalsIgnoreCase("read"))
        {
            while(! extended.acquiringReadLock(this));
            i = true;
        }
        else if(word.equalsIgnoreCase("write"))
        {
            while(! extended.upgradingLock(this,"write"));
            i = true;
        }

        return i;
    }

    public void transaction() throws SQLException, InterruptedException
    {
        System.out.println("Transaction1 has started.");

        sleep(100);

        connect1.setAutoCommit(false);

        stat.execute(startTrans);

        acquire_locks("read");

        System.out.println("Read lock has been acquired in T1.");

        rs = stat.executeQuery(query1);

        System.out.println("First query got executed in T1.");

        System.out.println("The result of the query is: ");

        rsmd = rs.getMetaData();
        int columnsNumber1 = rsmd.getColumnCount();
        while(rs.next())
        {
            for (int i = 1; i <= columnsNumber1; i++)
            {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }

        sleep(100);

        acquire_locks("write");

        System.out.println("Read lock has been upgraded to write lock. So, write lock has been acquired in T1.");

        stat.execute(query2);

        System.out.println("Second query got executed in T1.");

        stat.execute(endTrans);

        System.out.println("Transaction1 has been committed.");

        release_locks("write");

        System.out.println("Write lock has been released in T1. There are no locks on the database now.");

        connect1.setAutoCommit(true);
    }

    public boolean release_locks(String word)
    {
        boolean i = false;

        if(word.equalsIgnoreCase("read"))
        {
            while(! extended.releasingReadLock(this));
            i = true;
        }
        else if(word.equalsIgnoreCase("write"))
        {
            while(! extended.releasingWriteLock(this));
            i = true;
        }

        return i;
    }
}
