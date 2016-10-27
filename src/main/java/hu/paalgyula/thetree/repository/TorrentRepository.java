package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.entity.Torrent;

import javax.ejb.*;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static hu.paalgyula.thetree.Constants.TORRENTS_PER_PAGE;

/**
 * Created by PGYULA on 3/1/14.
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class TorrentRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Event<Torrent> torrentEventSrc;

    /**
     * Lehoz {@link hu.paalgyula.thetree.Constants#TORRENTS_PER_PAGE} db torrentet lapsorszam alapjan
     *
     * @param page az aktualis lap
     * @return torrentek listajat adja vissza
     */
    public List<Torrent> getTorrentsByPage(int page) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Torrent> cq = cb.createQuery(Torrent.class);
        Root<Torrent> root = cq.from(Torrent.class);
        cq.orderBy(
                cb.desc(root.get("uploaded"))
        ).select(root);

        return entityManager.createQuery(cq)
                .setMaxResults(TORRENTS_PER_PAGE)
                .setFirstResult(page * TORRENTS_PER_PAGE)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Torrent torrent) {
        entityManager.persist(torrent);
    }

    public Torrent findById(long id) {
        return entityManager.find(Torrent.class, id);
    }
}
