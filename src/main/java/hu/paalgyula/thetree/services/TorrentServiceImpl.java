package hu.paalgyula.thetree.services;

import com.turn.ttorrent.common.Torrent;
import hu.paalgyula.thetree.exceptions.InvalidTorrentException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;

/**
 * Created by paalgyula on 2016.10.27..
 */
@Scope("application")
public class TorrentServiceImpl implements TorrentService {
    private Logger log;

    @Override
    public void checkTorrent(InputStream fileStream) throws InvalidTorrentException {
        File tempFile = null;

        try {
            tempFile = File.createTempFile("thetree", ".torrent");

            // Copy inputstream content to the temp file
            FileOutputStream fos = new FileOutputStream(tempFile);
            IOUtils.copy(fileStream, fos);
            fos.flush();
            fos.close();

            Torrent torrent = Torrent.load(tempFile);
            for (String fileName : torrent.getFilenames()) {
                log.info("File in torrent: " + fileName);
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            throw new InvalidTorrentException(e);
        } finally {
            if (tempFile != null)
                tempFile.delete();
        }
    }
}
