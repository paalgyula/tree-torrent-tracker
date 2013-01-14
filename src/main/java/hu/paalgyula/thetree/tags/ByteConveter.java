package hu.paalgyula.thetree.tags;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class ByteConveter {
    public static String formatBytes( Long bytes ) {
        String[] metrics = new String[]{"B", "KB", "MB", "GB", "TB"};
        int c = 0;

        while ( ( bytes / 1024 ) > 1 ) {
            c++;
            bytes = bytes/1024;
        }

        return (double)(Math.ceil( bytes * 100 ) / 100) + " " + metrics[c];
    }
}
