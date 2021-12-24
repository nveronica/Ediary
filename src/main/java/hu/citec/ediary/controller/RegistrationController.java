package hu.citec.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import hu.citec.ediary.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserService userService;
	
    @GetMapping("/register")
    public String registerNewUser(WebRequest request, Model model) {
    	CustomU
        model.addAttribute("user", userService);
        return "registration";
    }

   /* @PostMapping("/register")
    public String submitNewUser(ModelAttribute("user")){
        return "index";
    }*/


}
