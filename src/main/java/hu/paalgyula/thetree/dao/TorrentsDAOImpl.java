package hu.paalgyula.thetree.dao;

import hu.paalgyula.thetree.domain.Torrents;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
@Repository("torrentsDAO")
public class TorrentsDAOImpl implements TorrentsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Torrents> list() {
        return search( "uploaded", "desc", "", 1 );
    }

    @Override
    public List<Torrents> search( String orderColumn, String order, String queryString, Integer page ) {
        Session session = (Session)entityManager.getDelegate();
        Criteria criteria = session.createCriteria(Torrents.class);

        Disjunction disjunction = Restrictions.disjunction();
        Conjunction conjunction = Restrictions.conjunction();

        for ( String critStr : queryString.toLowerCase().split( " " ) ) {
            conjunction.add( Restrictions.ilike( "name", critStr, MatchMode.ANYWHERE ) );
        }

        disjunction.add( conjunction );
        criteria.add( disjunction );

        switch ( orderColumn.toLowerCase() ){
            case "name":
            case "category":
            case "uploaded":
            case "size":
            case "downloaded":
            case "seeders":
            case "leechers":
                break;
            default:
                orderColumn = "uploaded";
        }

        if ( order.equalsIgnoreCase("asc") )
            criteria.addOrder( Order.asc( orderColumn ) );
        else
            criteria.addOrder( Order.desc( orderColumn ) );

        criteria.setFirstResult( (page - 1) * 25 );
        criteria.setMaxResults(25);

        return (List<Torrents>)criteria.list();
    }

    @Override
    public Long resultCount( String orderColumn, String order, String queryString ) {
        Session session = (Session)entityManager.getDelegate();
        Criteria criteria = session.createCriteria(Torrents.class);

        Disjunction disjunction = Restrictions.disjunction();
        Conjunction conjunction = Restrictions.conjunction();

        for ( String critStr : queryString.toLowerCase().split( " " ) ) {
            conjunction.add( Restrictions.ilike( "name", critStr, MatchMode.ANYWHERE ) );
        }

        disjunction.add( conjunction );
        criteria.add( disjunction );

        switch ( orderColumn.toLowerCase() ){
            case "name":
            case "category":
            case "uploaded":
            case "size":
            case "downloaded":
            case "seeders":
            case "leechers":
                break;
            default:
                orderColumn = "uploaded";
        }

        if ( order.equalsIgnoreCase("asc") )
            criteria.addOrder( Order.asc( orderColumn ) );
        else
            criteria.addOrder( Order.desc( orderColumn ) );
        criteria.setProjection( Projections.count( "name" ) );

        return (Long)criteria.uniqueResult();
    }
}
