package hu.paalgyula.thetree.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TorrentsController {
    @GetMapping("/torrents")
    public String torrentsPage() {
        return "torrents/search";
    }
}
