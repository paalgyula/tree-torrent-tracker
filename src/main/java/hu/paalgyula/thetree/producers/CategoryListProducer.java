package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.Category;
import hu.paalgyula.thetree.repository.CategoryRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by PGYULA on 3/1/14.
 */
@ApplicationScoped
@SuppressWarnings("unused")
public class CategoryListProducer {
    @Named
    @Produces
    private List<Category> categoryList;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private Logger logger;

    @PostConstruct
    public void initCategoryList() {
        logger.info("Initializing category list:");
        this.categoryList = categoryRepository.getCategoryList();
        logger.info(String.format("Initialized category list with %d elements", categoryList.size()));
    }

    public void handleCategoryChange(@Observes Category category) {
        logger.info("Category changed, reloading category list...");
        this.initCategoryList();
    }
}
