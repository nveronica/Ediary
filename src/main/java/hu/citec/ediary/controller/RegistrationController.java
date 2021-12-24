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
	
<<<<<<< HEAD
    @GetMapping("/register")
    public String registerNewUser(WebRequest request, Model model) {
    	CustomU
        model.addAttribute("user", userService);
=======
    @RequestMapping("/register")
    public String registerNewUser(Model model) {
	CustomUser newUser = new CustomUser();
        model.addAttribute("user", newUser);
>>>>>>> be3f7701092397d6108e451112b78692dddc28a9
        return "registration";
    }

   /* @PostMapping("/register")
    public String submitNewUser(ModelAttribute("user")){
        return "index";
    }*/


}
