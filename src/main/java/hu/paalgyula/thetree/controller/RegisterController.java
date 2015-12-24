package hu.paalgyula.thetree.controller;

import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.repository.UserRepository;
<<<<<<< HEAD
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
=======
>>>>>>> 1c74c1873210f3fda2ff7988a661e2d3183cb1d9

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by PGYULA on 2/27/14.
 */
@Model
@RequestScoped
public class RegisterController {

    @Inject
    private UserRepository userRepository;

    @Inject
    private FacesContext facesContext;

    @Inject
    private Logger logger;

    @Named
    @Produces
    private User newUser;

    @PostConstruct
    public void initNewUser() {
        this.newUser = new User();
    }

    public String register() {
        logger.info(DigestUtils.md5Hex(newUser.getPassword()));
        logger.info("Megnyomtam a gombot! " + this.newUser.getUsername());

        userRepository.persistWithEncoding(newUser);
        initNewUser();

        this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Nem mondom, vagy", "Mondoooooom"));
        return "/register-success";
    }
}
