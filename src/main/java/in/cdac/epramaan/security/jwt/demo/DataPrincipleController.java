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
@RequestMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.DATA_PRINCIPLE)
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class DataPrincipleController {
	
	@GetMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.TEST)
//	@PreAuthorize("hasRole('DATA_PRINCIPLE')")
	@PreAuthorize("hasRole(T(in.cdac.epramaan.user.model.Roles).DATA_PRINCIPLE)")
	public ResponseEntity<String> sayDataPrincipleHello(){
		log.info("Inside sayHello to DATA_PRINCIPLE");
		return ResponseEntity.ok("Hello from secured endpoint to DATA_PRINCIPLE");
	}
}
