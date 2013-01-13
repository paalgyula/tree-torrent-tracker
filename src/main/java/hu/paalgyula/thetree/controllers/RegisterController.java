package hu.paalgyula.thetree.controllers;

import hu.paalgyula.thetree.dao.UsersDAO;
import hu.paalgyula.thetree.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2013.01.13.
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
@Scope("request")
@Controller
public class RegisterController {
    @Autowired private UsersDAO usersDAO;
    
    @ModelAttribute("user")
    public Users usersModel() {
        return new Users();
    }

    @InitBinder("user")
    public void userBinder( WebDataBinder binder ) {
        binder.setValidator( new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return aClass.isAssignableFrom( Users.class );
            }

            @Override
            public void validate(Object o, Errors errors) {
                ValidationUtils.rejectIfEmptyOrWhitespace( errors, "username", "notblank" );
                ValidationUtils.rejectIfEmptyOrWhitespace( errors, "email", "notblank" );

                Users user = (Users)o;
                if ( !user.getPassword().equals( user.getPassword2() ) ) {
                    errors.rejectValue( "password", "notmatch" );
                    errors.rejectValue( "password2", "notmatch" );
                }
            }
        });
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String showRegister() { return "register"; }
    
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String doRegister( @Valid @ModelAttribute("user") Users user, BindingResult result, Model model ) {
        if ( result.hasErrors() )
            return "register";

        try {
            usersDAO.save( user );
        } catch (Exception e) {
            e.printStackTrace();
            return "register";
        }

        return "redirect:/Login";
    }
}
