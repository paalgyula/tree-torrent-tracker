package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.Category;
import hu.paalgyula.thetree.repository.CategoryRepository;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by PGYULA on 3/1/14.
 */
@ApplicationScoped
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
}
