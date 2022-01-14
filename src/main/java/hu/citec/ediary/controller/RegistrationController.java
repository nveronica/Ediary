package hu.citec.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import hu.citec.ediary.model.CustomUser;
import hu.citec.ediary.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserService userService;

    @RequestMapping("/register")
    public String registerNewUser(Model model) {
	CustomUser newUser = new CustomUser();

        model.addAttribute("user", newUser);
        return "registration";
    }

   /* @PostMapping("/register")
    public String submitNewUser(ModelAttribute("user")){
        return "index";
    }*/


}
