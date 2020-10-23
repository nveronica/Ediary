package hu.citec.ediary.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hu.citec.ediary.security.CustomSuccessHandler;
import java.util.Collection;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController{
	
	private CustomSuccessHandler customSuccessHandler = new CustomSuccessHandler();
	private String authority = null;
    
    @GetMapping("/index")
    public String home(Authentication auth, HttpSession session) {
        boolean isAuthenticated = false;
        if (auth != null) {
           isAuthenticated = auth.isAuthenticated();
        }

        if (session != null && isAuthenticated){
			Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
			authorities.forEach(s-> {
				authority = s.getAuthority();
			});
			String determineTargetUrl = customSuccessHandler.determineTargetUrl(auth);
			String targetUrl = determineTargetUrl.replace("/","");	
			return "redirect:" + targetUrl; 
        }
        return "index";
    }
    
    @RequestMapping("/index")
    public String home(){
        return "redirect:/" ;
    }

}
