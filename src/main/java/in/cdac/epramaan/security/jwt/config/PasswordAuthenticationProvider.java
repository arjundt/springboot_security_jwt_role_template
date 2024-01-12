package in.cdac.epramaan.security.jwt.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import in.cdac.epramaan.user.bd.UserBD;
import in.cdac.epramaan.user.model.User;
import in.cdac.epramaan.user.model.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PasswordAuthenticationProvider implements AuthenticationProvider {

    private final UserBD userBD;
    
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // password not null check
        if (password == null || password.isEmpty()) {
            log.error("Password can not be null or empty");
            System.out.println("Password cannot be null or empty");
            throw new AuthenticationServiceException(
                   "Password cannot be empty");
            // return CitizenUITiles.LOGIN.getTile();
        } else {

            // Check for username or adhaar number
            if (name == null) {
                log.error("Use any one value for login either User Name or Aadhaar Number");
                throw new AuthenticationServiceException("Name cannot empty");
                // return CitizenUITiles.LOGIN.getTile();
            } else {
            	System.out.println("Username and password are available");
            	User user = new User();
                user.setUsername(name);
                user.setPassword(password);
                UserResponse userResponse = userBD.authenticateUser(user);

                if (userResponse.getResponse().isStatus()) {
                	 log.info("Authentication successful!");
                    return new UsernamePasswordAuthenticationToken(
                    		userResponse.getUser(), password,
                    		userResponse.getUser().getAuthorities());
                } else {
                	 log.error("Authentication failed.");
                    throw new AuthenticationServiceException(userResponse
                            .getResponse().getError().toString());
                }
            }
        }

	}

	  @Override
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }

}
