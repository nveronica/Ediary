package hu.citec.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hu.citec.ediary.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService service;
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("customUser", service.findCustoms());
		return "admin";
	}
	
	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable int userId) {
		service.deleteUserById(userId);
		return "redirect:/admin";
	}
}
