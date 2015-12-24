package hu.paalgyula.thetree;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

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
<<<<<<< HEAD
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
=======
        return Logger.getLogger(injectionPoint.getBean().getBeanClass().getName());
>>>>>>> 1c74c1873210f3fda2ff7988a661e2d3183cb1d9
    }
}
