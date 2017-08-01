package hu.paalgyula.thetree.tags;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class ByteConveter {
    public static String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static String formatBytes(Long bytes) {
        String[] metrics = new String[]{"B", "KB", "MB", "GB", "TB"};
        int c = 0;

        while ((bytes / 1024) > 1) {
            c++;
            bytes = bytes / 1024;
        }

        return Math.ceil(bytes * 100) / 100 + " " + metrics[c];
    }
}
