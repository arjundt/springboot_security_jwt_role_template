package in.cdac.epramaan.mainTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GenerateBCryptPassword {
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "1234";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println(encodedPassword);
		
		boolean matches = passwordEncoder.matches(password, encodedPassword);
		System.out.println(matches); // prints true if the passwords match, false otherwise
	}

}
