package hu.paalgyula.thetree.dao;

import hu.paalgyula.thetree.domain.Users;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 13:09
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface UsersDAO {
    public Users findByEmail( String email );
    public Users findByUsername( String username );
    public Users get( Long id );

    public void update( Users user );
    public void delete( Users user );
    public void save( Users user );
}
