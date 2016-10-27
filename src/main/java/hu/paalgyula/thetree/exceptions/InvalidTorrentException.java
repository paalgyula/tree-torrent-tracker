package hu.paalgyula.thetree.exceptions;

/**
 * Created by paalgyula on 2016.10.27..
 */
public class InvalidTorrentException extends Exception {
    public InvalidTorrentException(Exception e) {
        super(e);
    }
}
