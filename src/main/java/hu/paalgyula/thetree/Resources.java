package hu.paalgyula.thetree;

import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by PGYULA on 2/27/14.
 */
@SuppressWarnings("unused")
public class Resources {
    @PersistenceContext(unitName = "thetree")
    private EntityManager entityManager;

    @Produces
    public EntityManager produceEntityManager() {
        return this.entityManager;
    }

    @Produces
    @RequestScoped
    private FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    @Produces
    private Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}
