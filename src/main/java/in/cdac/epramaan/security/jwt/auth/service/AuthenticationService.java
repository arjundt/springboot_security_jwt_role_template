package in.cdac.epramaan.security.jwt.auth.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.cdac.epramaan.exception.UserDataNotSavedException;
import in.cdac.epramaan.security.jwt.auth.model.AuthenticateRequest;
import in.cdac.epramaan.security.jwt.auth.model.AuthenticationResponse;
import in.cdac.epramaan.security.jwt.auth.model.RegisterRequest;
import in.cdac.epramaan.security.jwt.config.CustomAuthenticationManager;
//import in.cdac.epramaan.security.jwt.model.Users;
//import in.cdac.epramaan.security.jwt.repository.UserRepository;
import in.cdac.epramaan.security.jwt.service.JwtService;
import in.cdac.epramaan.user.bd.UserBD;
import in.cdac.epramaan.user.model.User;
import in.cdac.epramaan.user.model.UserResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserBD userBD;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final CustomAuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
//				.role(Role.USER)
				.build();
		
		UserResponse userResponse = userBD.addUser(user);
		
		if(userResponse.getResponse().isStatus() == true 
				&& user.equals(userResponse.getUser())) {
			//^TODO: Figure out what to do in this condition
			
		} else {
			System.out.println("User not saved!! Some error occurred");
//			throw new RuntimeException(adminResponse.getResponse().getError().getErrorCode());
			throw new UserDataNotSavedException("User data could not be saved");
		}
		
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticateRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword()));
		
		var user = userBD.getUserByUserName(request.getUsername());
		
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

}
