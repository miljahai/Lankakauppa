package harjoitustyo.lankakauppa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import harjoitustyo.lankakauppa.service.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		return http.authorizeRequests(auth -> {
			
			auth.antMatchers("/h2-console").permitAll();
			
			auth.antMatchers("/yarns/**").hasAuthority("ADMIN");
			
			auth.anyRequest().authenticated();
		})
				.headers().frameOptions().disable().and()
				
				.csrf().ignoringAntMatchers("/h2-console/**").and()
				
				.formLogin().defaultSuccessUrl("/patternlist", true).and()
				
				.logout().permitAll().and()
				
				.httpBasic(Customizer.withDefaults()).build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
