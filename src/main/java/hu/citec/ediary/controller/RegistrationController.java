package hu.citec.ediary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String registerNewUser(WebRequest request, Model model) {
       // UserDto userDto = new UserDto();
        //model.addAttribute("user", userDto);
        return "registration";
    }

   /* @PostMapping("/register")
    public String submitNewUser(ModelAttribute("user")){
        return "index";
    }*/


}
