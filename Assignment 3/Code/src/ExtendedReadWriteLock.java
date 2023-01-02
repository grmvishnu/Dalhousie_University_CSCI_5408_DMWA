public class ExtendedReadWriteLock
{
    enum rwl
        {
            READ,
            WRITE,
            NONE
        };

    private static ExtendedReadWriteLock extended = new ExtendedReadWriteLock();
    rwl dbLock = rwl.NONE;
    String[] status = {"", ""};

    public static ExtendedReadWriteLock getInstance()
    {
        return extended;
    }

    public boolean acquiringReadLock(Thread transaction)
    {
        boolean locked = false;
        if(transaction.getName().equals("ThreadOne"))
        {
            if(status[0].equalsIgnoreCase("") && status[1].equalsIgnoreCase(""))
            {
                dbLock = rwl.READ;
                locked = true;
                status[0] = "T1";
                status[1] = "READ";
            }
        }
        else if(transaction.getName().equals("SecondOne"))
        {
            if(status[0].equalsIgnoreCase("") && status[1].equalsIgnoreCase(""))
            {
                dbLock = rwl.READ;
                locked = true;
                status[0] = "T2";
                status[1] = "READ";
            }
        }
        return locked;
    }

    public boolean acquiringWriteLock(Thread transaction)
    {
        boolean locked = false;
        if(transaction.getName().equals("ThreadOne"))
        {
            if(status[0].equalsIgnoreCase("") && status[1].equalsIgnoreCase(""))
            {
                dbLock = rwl.WRITE;
                locked = true;
                status[0] = "T1";
                status[1] = "WRITE";
            }
        }
        else if(transaction.getName().equals("SecondOne"))
        {
            if(status[0].equalsIgnoreCase("") && status[1].equalsIgnoreCase(""))
            {
                dbLock = rwl.WRITE;
                locked = true;
                status[0] = "T2";
                status[1] = "WRITE";
            }
        }
        return locked;
    }

    public boolean upgradingLock(Thread transaction, String call)
    {
        boolean locked = false;
        if(transaction.getName().equals("ThreadOne"))
        {
            if(status[0].equalsIgnoreCase("T1") && status[1].equalsIgnoreCase("READ") &&
                    call.equalsIgnoreCase("write"))
            {
                dbLock = rwl.WRITE;
                locked = true;
                status[0] = "T1";
                status[1] = "WRITE";
            }
        }
        else if(transaction.getName().equals("SecondOne"))
        {
            if(status[0].equalsIgnoreCase("T2") && status[1].equalsIgnoreCase("READ") &&
                    call.equalsIgnoreCase("write"))
            {
                dbLock = rwl.WRITE;
                locked = true;
                status[0] = "T2";
                status[1] = "WRITE";
            }
        }
        return locked;
    }

    public boolean downgradingLock(Thread transaction, String call)
    {
        boolean locked = false;
        if(transaction.getName().equals("ThreadOne"))
        {
            if(status[0].equalsIgnoreCase("T1") && status[1].equalsIgnoreCase("WRITE") &&
                    call.equalsIgnoreCase("read"))
            {
                dbLock = rwl.READ;
                locked = true;
                status[0] = "T1";
                status[1] = "READ";
            }
        }
        else if(transaction.getName().equals("SecondOne"))
        {
            if(status[0].equalsIgnoreCase("T2") && status[1].equalsIgnoreCase("WRITE") &&
                    call.equalsIgnoreCase("read"))
            {
                dbLock = rwl.READ;
                locked = true;
                status[0] = "T2";
                status[1] = "READ";
            }
        }
        return locked;
    }

    public boolean releasingReadLock(Thread transaction)
    {
        boolean locked = false;
        if(transaction.getName().equals("ThreadOne"))
        {
            if(status[0].equalsIgnoreCase("T1") && status[1].equalsIgnoreCase("READ"))
            {
                dbLock = rwl.NONE;
                locked = true;
                status[0] = "";
                status[1] = "";
            }
        }
        else if(transaction.getName().equals("SecondOne"))
        {
            if(status[0].equalsIgnoreCase("T2") && status[1].equalsIgnoreCase("READ"))
            {
                dbLock = rwl.NONE;
                locked = true;
                status[0] = "";
                status[1] = "";
            }
        }
        return locked;
    }

    public boolean releasingWriteLock(Thread transaction)
    {
        boolean locked = false;
        if(transaction.getName().equals("ThreadOne"))
        {
            if(status[0].equalsIgnoreCase("T1") && status[1].equalsIgnoreCase("WRITE"))
            {
                dbLock = rwl.NONE;
                locked = true;
                status[0] = "";
                status[1] = "";
            }
        }
        else if(transaction.getName().equals("SecondOne"))
        {
            if(status[0].equalsIgnoreCase("T2") && status[1].equalsIgnoreCase("WRITE"))
            {
                dbLock = rwl.NONE;
                locked = true;
                status[0] = "";
                status[1] = "";
            }
        }
        return locked;
    }
}
