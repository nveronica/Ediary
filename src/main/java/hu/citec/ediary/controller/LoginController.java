package hu.citec.ediary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/new_password")
	public String createNewPassword() {
		return "/";
	}
	
	@GetMapping("/404")
	public String notFound() {
		return "error/404";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "error/403";
	}
	
}