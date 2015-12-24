package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.Torrent;
import hu.paalgyula.thetree.repository.TorrentRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by PGYULA on 3/1/14.
 */
@RequestScoped
@SuppressWarnings("unused")
public class TorrentListProducer {
    @Named
    @Produces
    private List<Torrent> torrentList;

    @Inject
    private TorrentRepository torrentRepository;

    private int page;

    @PostConstruct
    public void produceTorrentList() {
        this.page = 0;
        this.torrentList = torrentRepository.getTorrentsByPage(page);
    }

    @SuppressWarnings({"unchecked"})
    public void handleTorrentUploadedEvent(@Observes Torrent torrent) {
        this.produceTorrentList();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
