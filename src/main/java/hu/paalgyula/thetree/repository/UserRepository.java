package hu.paalgyula.thetree.repository;

import hu.paalgyula.thetree.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by PGYULA on 2/27/14.
 */
@Local
public interface UserRepository extends Serializable {

    List<User> findAll();

    void persistWithEncoding(User user);
}
