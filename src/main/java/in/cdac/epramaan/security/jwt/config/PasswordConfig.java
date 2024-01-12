package in.cdac.epramaan.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PasswordConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	/*
	 * ScryptPassword Encoding technique
	 * @Bean public PasswordEncoder passwordEncoder() { int cpuCost = (int)
	 * Math.pow(2, 14); // factor to increase CPU costs int memoryCost = 8; //
	 * factor to increases memory usage int parallelization = 1; // currently nor
	 * supported by Spring Security int keyLength = 32; // key length in bytes int
	 * saltLength = 64; // salt length in bytes
	 * 
	 * return new SCryptPasswordEncoder(cpuCost, memoryCost, parallelization,
	 * keyLength, saltLength); }
	 */
}
