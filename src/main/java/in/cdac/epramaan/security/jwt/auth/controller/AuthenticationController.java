package in.cdac.epramaan.security.jwt.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.epramaan.security.jwt.auth.model.AuthenticateRequest;
import in.cdac.epramaan.security.jwt.auth.model.AuthenticationResponse;
import in.cdac.epramaan.security.jwt.auth.model.RegisterRequest;
import in.cdac.epramaan.security.jwt.auth.service.AuthenticationService;
import in.cdac.epramaan.util.URIConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.SECURITY_OPEN_URL)
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@Tag(name = "Authentication", description = "Getting the JWT Token")
public class AuthenticationController {
	
	private final AuthenticationService authService;
 	
	@Operation(
	      summary = "Register a new User",
	      description = "Registering a new user and get a JWT token",
	      tags = { "Authentication" })
	@PostMapping(value = URIConstants.FORWARD_SLASH + URIConstants.REGISTER)
	public ResponseEntity<AuthenticationResponse> register(
			@Parameter(description = "User details to register") @RequestBody RegisterRequest request){
		log.info("Inside register method");
		log.debug("Username: "+request.getUsername());
		log.debug("Password: "+request.getPassword());
		return ResponseEntity.ok(authService.register(request));
	}
	
	@Operation(
	      summary = "Authenticate a User",
	      description = "Authenticate a user and get a JWT token",
	      tags = { "Authentication" })
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = AuthenticationResponse.class), mediaType = "application/json") }),
	    @ApiResponse(responseCode = "404", description = "The User with given credential was not found.", content = { @Content(schema = @Schema()) })
	  })
	@PostMapping(value = URIConstants.FORWARD_SLASH + URIConstants.AUTHENTICATE)
	public ResponseEntity<AuthenticationResponse> authenticate(
			@Parameter(description = "User Credentials") @RequestBody AuthenticateRequest request){
		log.info("Inside authenticate method");
		log.debug("Username: "+request.getUsername());
		log.debug("Password: "+request.getPassword());
		return ResponseEntity.ok(authService.authenticate(request));
	}

}
