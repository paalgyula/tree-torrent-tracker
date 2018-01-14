package hu.paalgyula.thetree.rest;

import hu.paalgyula.thetree.rest.forms.LoginModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginEndpoint {
    @PostMapping
    public ResponseEntity<?> login(@ModelAttribute LoginModel loginModel) {
        return ResponseEntity.ok("");
    }
}
