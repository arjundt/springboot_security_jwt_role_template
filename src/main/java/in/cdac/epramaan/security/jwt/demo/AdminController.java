package in.cdac.epramaan.security.jwt.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.epramaan.user.model.Roles;
import in.cdac.epramaan.util.URIConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.ADMIN)
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class AdminController {
	
//	@Secured(Roles.ADMIN)
//	@PreAuthorize("hasRole('INSERT')")
	@PreAuthorize("hasRole(T(in.cdac.epramaan.user.model.Roles).ADMIN)")
	@GetMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.TEST)
	public ResponseEntity<String> sayAdminHello(){
		log.info("Inside sayHello to admin");
		log.debug("sss"+"T(in.cdac.epramaan.user.model.Roles).ADMIN)");
		return ResponseEntity.ok("Hello from secured endpoint to admin");
	}
}
