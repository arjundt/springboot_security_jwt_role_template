package in.cdac.epramaan.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

import in.cdac.epramaan.user.bd.UserBD;
//import in.cdac.epramaan.user.repository.UserRepository;
//import in.cdac.epramaan.security.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfig {
	
	private final UserBD userBD;
		
//	@Bean
	public UserDetailsService userDetailService() {
		return username -> userBD.getUserByUserName(username);
	}
	
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
////		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		CustomAuthenticationManager authProvider = new CustomAuthenticationManager();
////		authProvider.setUserDetailsService(userDetailService());
////		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		log.info("WebSecurityConfig :: returning authenticationManagerBean.");
        return new CustomAuthenticationManager();
//		return config.getAuthenticationManager();
	}
	
}
