package hu.paalgyula.thetree.controller;

import hu.paalgyula.thetree.entity.Torrent;
import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.exceptions.InvalidTorrentException;
import hu.paalgyula.thetree.repository.TorrentRepository;
import hu.paalgyula.thetree.services.TorrentService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by PGYULA on 3/2/14.
 */
@Model
public class TorrentUploadController {
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

    @Inject
    private TorrentService torrentService;

    @Inject
    private FacesContext facesContext;

    @Inject
    private Validator validator;

    @PostConstruct
    public void initUpload() {
        this.newTorrent = new Torrent();
    }

    public String upload() {
        logger.info("Uploaded file name: " + newTorrent.getFile().getSubmittedFileName());
        logger.info("Persisting new torrent: " + newTorrent.getName());

        validator.validate(newTorrent);

        try {
            torrentService.checkTorrent(newTorrent.getFile().getInputStream());
        } catch (InvalidTorrentException e) {
            facesContext.addMessage("torrentFile", new FacesMessage("Invalid torrent file! Check your upload again!"));
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.newTorrent.setUploader(this.trackerUser);
        this.torrentRepository.save(this.newTorrent);

        return "/torrents/show?faces-redirect=true&torrentid=" + this.newTorrent.getId();
    }
}
