package in.cdac.epramaan.mainTest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class GenerateScryptPassword {
	public static void main(String[] args) {
		int cpuCost = (int) Math.pow(2, 14); // factor to increase CPU costs
		int memoryCost = 8; // factor to increases memory usage
		int parallelization = 1; // currently  nor supported by Spring Security
		int keyLength = 32; // key length in bytes
		int saltLength = 64; // salt length in bytes
		PasswordEncoder passwordEncoder = new SCryptPasswordEncoder(cpuCost, memoryCost, parallelization, keyLength, saltLength);

		String password = "1234";
		String encodedPassword = passwordEncoder.encode(password);
//		String encodedPassword = "$e0801$6HC906up46hC7cU/y7HUUcbnTTr97FE6pxQnoOzTG2k1/kMVX345jiI+AgLeK6HQ8tFED4hzMrO2tmYfQlTI0A==$bFSoYSenOqt0r21diwJnrOBuXkOtc9DkBd3T/1Kd6D0=";
		System.out.println(encodedPassword);
		
		String encodedPasswordFromDatabase = "$e0801$92cWzMNe8OxX54Dtlheg+ePGojiiFIRe2F9Xkd2gRSX6gFUvsvr1aPZlYAQHUYEre4/PWj/9aX5XQoIJIcQTBg==$Y2Mos1LknCJRIxdxZVBfJsXTaZRkZA+IB3QQxo5bqEs=";
		boolean matches = passwordEncoder.matches(password, encodedPasswordFromDatabase);
		System.out.println(matches); // prints true if the passwords match, false otherwise
		
	}
}
