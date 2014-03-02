package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.repository.UserRepository;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by PGYULA on 3/1/14.
 */
@SessionScoped
public class TrackerUserProducer implements Serializable {
    @Named
    @Produces
    private User trackerUser;

    @Inject
    private UserRepository userRepository;

    @Inject
    private FacesContext facesContext;

    @Inject
    private Logger logger;

    @PostConstruct
    private void setupUser() {
        this.trackerUser = (User) facesContext.getExternalContext().getUserPrincipal();
        if (this.trackerUser == null) {
            this.logger.info("Loading Fake user instance");
            this.trackerUser = userRepository.findAll().get(0);
        }
    }
}
