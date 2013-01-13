package hu.paalgyula.thetree;

import hu.paalgyula.thetree.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class HttpUserService implements UserDetailsService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return usersDAO.findByUsername( s );
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException( s );
        }
    }
}
