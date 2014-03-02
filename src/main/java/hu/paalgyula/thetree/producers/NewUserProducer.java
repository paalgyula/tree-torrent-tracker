package hu.paalgyula.thetree.producers;

import hu.paalgyula.thetree.entity.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * Created by PGYULA on 3/1/14.
 */
@RequestScoped
public class NewUserProducer {
    @Named("newUser")
    @Produces
    private User newUser;

    @PostConstruct
    public void setupNewUser() {
        this.newUser = new User();
    }
}
