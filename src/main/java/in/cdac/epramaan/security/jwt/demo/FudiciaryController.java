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
@RequestMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.FIDUCIARY)
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class FudiciaryController {
	
	@GetMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.TEST)
	@PreAuthorize("hasRole(T(in.cdac.epramaan.user.model.Roles).FIDUCIARY)")
//	@PreAuthorize("hasRole('FIDUCIARY')")
	public ResponseEntity<String> sayFudiciaryHello(){
		log.info("Inside sayHello to fudiciary");
		return ResponseEntity.ok("Hello from secured endpoint to fudiciary");
	}
}
