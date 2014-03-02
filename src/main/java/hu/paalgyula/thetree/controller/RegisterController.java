package hu.paalgyula.thetree.controller;

import hu.paalgyula.thetree.entity.User;
import hu.paalgyula.thetree.repository.UserRepository;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by PGYULA on 2/27/14.
 */
@Model
public class RegisterController {

    @Inject
    private UserRepository userRepository;

    @Inject
    private FacesContext facesContext;

    @Inject
    private Logger logger;

    @Inject
    @Named("newUser")
    private User newUser;

    public void register() {

        System.out.println("Megnyomtam a gombot! " + this.newUser.getUsername());
        this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Nem mondom, vagy", "Mondoooooom"));
    }
}
