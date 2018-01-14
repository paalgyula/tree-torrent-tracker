package hu.paalgyula.thetree.services;

import com.turn.ttorrent.common.Torrent;
import hu.paalgyula.thetree.exceptions.InvalidTorrentException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by paalgyula on 2016.10.27..
 */
@Service
@Scope("application")
public class TorrentService {
    private Logger log = LoggerFactory.getLogger(TorrentService.class);

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
            log.error(e.getMessage(), e);
            throw new InvalidTorrentException(e);
        } finally {
            if (tempFile != null)
                tempFile.delete();
        }
    }
}
