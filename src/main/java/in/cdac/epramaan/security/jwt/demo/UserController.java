package in.cdac.epramaan.security.jwt.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.epramaan.util.URIConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.USER)
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class UserController {
	
	@GetMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.TEST)
	@PreAuthorize("hasRole(T(in.cdac.epramaan.user.model.Roles).USER)")
//	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> sayUserHello(){
		log.info("Inside sayHello to user");
		return ResponseEntity.ok("Hello from secured endpoint to user");
	}
}
