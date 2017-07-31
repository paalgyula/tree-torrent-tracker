package hu.paalgyula.thetree.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping({"/login"})
    public String loginPage(@RequestParam(name = "error", required = false) Boolean error) {
        return "login";
    }

    @GetMapping({"/register"})
    public String registerPage() {
        return "register";
    }
}
