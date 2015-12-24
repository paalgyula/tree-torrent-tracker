package hu.paalgyula.thetree.controller;

import hu.paalgyula.thetree.entity.Torrent;
import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.repository.TorrentRepository;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by PGYULA on 3/2/14.
 */
@Model
public class TorrentUploadController {
    @Named
    @Produces
    private UploadedFile uploadedFile;

    @Named
    @Produces
    private Torrent newTorrent;

    @Named
    @Inject
    private User trackerUser;

    @Inject
    private TorrentRepository torrentRepository;

    @Inject
    private Logger logger;

    @PostConstruct
    public void initUpload() {
        this.newTorrent = new Torrent();
    }

    public String upload() {
        logger.info("Persisting new torrent: " + newTorrent.getName());
        this.newTorrent.setUploader(this.trackerUser);
        this.torrentRepository.save(this.newTorrent);

        return "/torrents/show?faces-redirect=true&torrentid=" + this.newTorrent.getId();
    }
}
