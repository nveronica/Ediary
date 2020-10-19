package hu.citec.ediary.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import hu.citec.ediary.security.CustomSuccessHandler;

import java.util.Collection;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController{
	
	CustomSuccessHandler customSuccessHandler = new CustomSuccessHandler();
	
    String authority = null;
    @GetMapping("/index")
    public String home(Authentication auth, HttpSession session) {
        boolean authenticated = false;
        if (auth != null) {
           authenticated = auth.isAuthenticated();
        }

        if (session != null && authenticated){
            String loggedInAs = auth.getName();//authentication.getAuthorities().toString();
            //authentication.getAuthorities().stream().findAny()
            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
           
            session= attr.getRequest().getSession(true); // true == allow create
             Object principal = auth.getPrincipal();
           
			Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
			authorities.forEach(s-> {
				authority = s.getAuthority();
				
			});
			
			String determineTargetUrl = customSuccessHandler.determineTargetUrl(auth);

			//			authorities.forEach(s -> {
//				if (s.getAuthority().contains("ADMIN")) {
//					return "redirect:/" + "admin";
//				}
//				//s.getAuthority().equals(auth.getAuthorities()
//			});
//			
        	//System.out.println(session.getAttribute(loggedInAs).toString());
        	
			return "redirect:/" + determineTargetUrl; 
        }

        return "index";

    }
    @RequestMapping("/index")
    public String home(){
        return "";
    }

}
