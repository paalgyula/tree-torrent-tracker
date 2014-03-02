package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.entity.Torrent;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.transaction.*;
import java.util.List;

import static hu.paalgyula.thetree.Constants.TORRENTS_PER_PAGE;

/**
 * Created by PGYULA on 3/1/14.
 */
@ApplicationScoped
public class TorrentRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Event<Torrent> torrentEventSrc;

    @Resource
    private UserTransaction userTransaction;

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

    public void save(Torrent torrent) {
        try {
            userTransaction.begin();
            entityManager.persist(torrent);
            userTransaction.commit();

            // Fire event
            torrentEventSrc.fire(torrent);
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        }

    }
}
