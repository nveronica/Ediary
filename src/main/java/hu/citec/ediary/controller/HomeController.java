package hu.citec.ediary.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /*@GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }*/
    @GetMapping("/index")
    public String home(Authentication authentication) {
        boolean authenticated = authentication.isAuthenticated();
        if (authenticated){
            String loggedInAs = authentication.toString();//authentication.getAuthorities().toString();
            //authentication.getAuthorities().stream().findAny()
            return "redirect:/" + loggedInAs;
        }else {
        return "index";
        }
    }
}
