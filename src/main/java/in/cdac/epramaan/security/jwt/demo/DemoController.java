package in.cdac.epramaan.security.jwt.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.epramaan.util.URIConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.API)
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class DemoController {
	
	@GetMapping(value = URIConstants.FORWARD_SLASH +  URIConstants.TEST)
	public ResponseEntity<String> sayHello(){
		log.info("Inside sayHello");
		return ResponseEntity.ok("Hello from secured endpoint");
	}

}
