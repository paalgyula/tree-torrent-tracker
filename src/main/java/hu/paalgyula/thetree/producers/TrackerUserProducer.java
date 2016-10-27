package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.repository.UserRepository;

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
    private static final Logger LOGGER = Logger.getLogger(TrackerUserProducer.class.getName());

    @Named
    @Produces
    private User trackerUser;

    @Inject
    private UserRepository userRepository;

    private FacesContext facesContext = FacesContext.getCurrentInstance();

    @PostConstruct
    private void setupUser() {
        this.trackerUser = (User) facesContext.getExternalContext().getUserPrincipal();
        if (this.trackerUser == null) {
            LOGGER.info("Loading Fake user instance");
            User user = new User();
            user.setUsername("goofyx");
            user.setPoints(0);
            user.setTitle("Újponc");
            user.setEmail("paalgyula@paalgyula.com");
            user.setPassword("Aa123456");
            user.setDownloaded(152124112);
            user.setUploaded(1511251223);

            userRepository.persistWithEncoding(user);

            this.trackerUser = user;
        }
    }
}
