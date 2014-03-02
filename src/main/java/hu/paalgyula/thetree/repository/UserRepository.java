package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by PGYULA on 2/27/14.
 */
@ApplicationScoped
public class UserRepository implements Serializable {
    @Inject
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u order by u.id asc", User.class).getResultList();
    }
}
