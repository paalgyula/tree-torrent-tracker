package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.FeedItem;
import hu.paalgyula.thetree.repository.FeedItemRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by PGYULA on 3/2/14.
 */
@RequestScoped
public class FeedProducer {
    @Named
    @Produces
    private List<FeedItem> feedItemList;

    @Inject
    private FeedItemRepository feedItemRepository;

    @PostConstruct
    public void initFeedItemList() {
        this.feedItemList = this.feedItemRepository.getRecentItems();
    }
}
