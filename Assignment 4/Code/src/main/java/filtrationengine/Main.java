package filtrationengine;

public class Main
{
    public static void main(String[] args)
    {
        String emojis = "\\\\u[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789]+";
        String urls = "(http|https|ftp):\\/\\/([<>~^!@#$*a-z./?=%3A%2F&A-Z0-9-_]+)";
        String neededchar = "[^{}\"\\[]a-zA-Z0-9\s':,_@.]+";

        Cleaning.replace(emojis, urls, neededchar);
    }
}
