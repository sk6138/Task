

package com.Task.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {



	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = createNewUser("sahil kumar","kumar");
		UserDetails user1 = createNewUser("aman","kumar");

		return new InMemoryUserDetailsManager(user,user1);
	}

	private UserDetails createNewUser(String username,String password) {
		
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username(username)
				.password(password)
				.roles("USER")
				.build();
		return user;
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}
