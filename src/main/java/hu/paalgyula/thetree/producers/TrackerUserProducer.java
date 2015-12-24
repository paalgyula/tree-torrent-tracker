package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.repository.UserRepository;
<<<<<<< HEAD
import java.util.logging.Logger;
=======
>>>>>>> 1c74c1873210f3fda2ff7988a661e2d3183cb1d9

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

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
            //this.trackerUser = userRepository.findAll().get(0);
            this.trackerUser = new User();
        }
    }
}
