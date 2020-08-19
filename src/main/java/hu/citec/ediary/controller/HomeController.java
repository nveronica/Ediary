package hu.citec.ediary.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController{

    /*@GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }*/
    @GetMapping("/index")
    public String home(Authentication auth, HttpSession session) {
        boolean authenticated = false;
        if (auth!=null) {
           authenticated = auth.isAuthenticated();
        }

        if (session != null && authenticated){
            String loggedInAs = auth.getName();//authentication.getAuthorities().toString();
            //authentication.getAuthorities().stream().findAny()
            return "redirect:/" + loggedInAs;
        }

        return "login";

    }
    @RequestMapping("/index")
    public String home(){
        return "";
    }

}
