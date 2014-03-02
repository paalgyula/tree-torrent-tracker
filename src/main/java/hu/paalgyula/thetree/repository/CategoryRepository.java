package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.entity.Category;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by PGYULA on 3/1/14.
 */
@Stateless
public class CategoryRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Event<Category> categoryEventSrc;

    public List<Category> getCategoryList() {
        return entityManager.createQuery("select c from Category c order by c.category asc", Category.class)
                .getResultList();
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void save(Category category) {
        entityManager.persist(category);
        categoryEventSrc.fire(category);
    }
}
