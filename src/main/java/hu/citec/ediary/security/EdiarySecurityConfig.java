package hu.citec.ediary.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class EdiarySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authenticationProvider(authProvider())
		.authorizeRequests()
			.antMatchers("/", "/index").permitAll()
			.antMatchers("/admin").hasAuthority("ADMIN")
			.antMatchers("/teacher").hasAnyAuthority("TANAR", "ADMIN")
			.antMatchers("/admin", "/teacher", "/student", "/user").fullyAuthenticated() 
		.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.loginProcessingUrl("/login")
			.successHandler(customSuccessHandler())
		.and()
		.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 
			.logoutSuccessUrl("/login?loggedout")
		.and()
		.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(getpasswordEncoder());
		return authenticationProvider;
	}

	@Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
        auth.jdbcAuthentication()
        	.dataSource(dataSource)
        	.usersByUsernameQuery("SELECT username, user_password, 1 AS ENABLED FROM users WHERE username = ?")
        	.authoritiesByUsernameQuery("Select * from role r LEFT JOIN user_roles ur ON ur.role_id = r.role_id LEFT JOIN users u ON u.user_id = ur.user_id Where u.username =?");

        auth.jdbcAuthentication()
    		.dataSource(dataSource)
    		.usersByUsernameQuery("SELECT email, user_password, 1 AS ENABLED FROM users WHERE email = ?")
    		.authoritiesByUsernameQuery("Select * from role r LEFT JOIN user_roles ur ON ur.role_id = r.role_id LEFT JOIN users u ON u.user_id = ur.user_id Where u.email = ?");
    }
	
	@Bean
	public AuthenticationSuccessHandler customSuccessHandler(){
	    return new CustomSuccessHandler();
	}
	
	  @Bean
	    public PasswordEncoder getpasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
}