package hu.paalgyula.thetree.dao;

import hu.paalgyula.thetree.domain.Torrents;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface TorrentsDAO {
    public List<Torrents> list();
    public List<Torrents> search( String orderColumn, String order, String queryString, Integer page );
    public Long resultCount( String orderColumn, String order, String queryString );
}
