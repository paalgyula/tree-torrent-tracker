package hu.paalgyula.thetree.controller;

import hu.paalgyula.thetree.entity.Torrent;
import hu.paalgyula.thetree.repository.TorrentRepository;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by PGYULA on 3/2/14.
 */
@Model
public class ShowTorrentController {
    @Inject
    private Logger logger;

    @Inject
    private TorrentRepository torrentRepository;

    private long torrentid;

    private Torrent torrent;

    @PostConstruct
    public void initTorrent() {
        this.torrent = this.torrentRepository.findById(this.torrentid);
    }

    public long getTorrentid() {
        return torrentid;
    }

    public void setTorrentid(long torrentid) {
        this.torrentid = torrentid;
    }

    public Torrent getTorrent() {
        return torrent;
    }

    public void setTorrent(Torrent torrent) {
        this.torrent = torrent;
    }
}
