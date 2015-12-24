package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.entity.User;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by paalgyula on 2014.06.17..
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserRepositoryImpl implements UserRepository {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<User> findAll() {
        return entityManager
                .createNamedQuery("User.findAll", User.class)
                .getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persistWithEncoding(User user) {
        user.setPassword(new String(Base64.encodeBase64(DigestUtils.md5(user.getPassword()))));
        logger.info( String.format( "Encoded password for user %s: [%s]", user.getName(), user.getPassword() ) );
        entityManager.persist(user);
    }
}
