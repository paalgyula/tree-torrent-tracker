package hu.paalgyula.thetree.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: paal.gyula
 * Date: 2012.10.24.
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DashboardController {

    @RequestMapping({"/index.tt", "/", "/Dashboard"})
    public String handleIndex() {
        return "main";
    }
}
