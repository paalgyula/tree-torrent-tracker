package hu.paalgyula.thetree.services;

import hu.paalgyula.thetree.exceptions.InvalidTorrentException;

import java.io.InputStream;

/**
 * Created by paalgyula on 2016.10.27..
 */
public interface TorrentService {
    void checkTorrent(InputStream fileStream) throws InvalidTorrentException;
}
