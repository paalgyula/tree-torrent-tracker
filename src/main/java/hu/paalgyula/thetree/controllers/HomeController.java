package hu.paalgyula.thetree.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping({"/", "/Home"})
	public String homePage() {
		return "index";
	}
}