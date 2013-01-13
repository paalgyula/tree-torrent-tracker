package hu.paalgyula.thetree.dao;

import hu.paalgyula.thetree.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
@Repository("usersDAO")
public class UsersDAOImpl implements UsersDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Users findByEmail(String email) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Users findByUsername(String username) {
        return entityManager.createQuery( "select u from Users u where lower( u.username ) = lower( :username )", Users.class )
                .setParameter( "username", username )
                .getSingleResult();
    }

    @Override
    public Users get(Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Users user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Users user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save(Users user) {
        entityManager.persist( user );
    }
}
