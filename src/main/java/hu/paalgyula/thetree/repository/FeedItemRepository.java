package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.Constants;
import hu.paalgyula.thetree.entity.FeedItem;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by PGYULA on 3/2/14.
 */
@Stateless
public class FeedItemRepository {
    @Inject
    private EntityManager entityManager;

    /**
     * Aktualis ujdonsagokat adja vissza
     *
     * @return
     */
    public List<FeedItem> getRecentItems() {
        return entityManager
                .createQuery("select fi from FeedItem fi order by fi.postDate desc", FeedItem.class)
                .setMaxResults(Constants.FEED_ITEMS_PER_PAGE)
                .getResultList();
    }
}
