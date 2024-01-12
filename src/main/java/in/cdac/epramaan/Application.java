package in.cdac.epramaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import in.cdac.epramaan.util.URIConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
				title = "User Consent Managment System", 
				version = "1.0", 
				description = "UCMS developed by Cdac as a ePramaan2.0 initiative",
//				termsOfService = "ePramaan2.0",
				contact = @Contact(
			      name = "Cdac Mumbai",
			      email = "epramaan2.0@cdac.in"
			    )
//			    license = @License(
//			      url = "http://www.apache.org/licenses/LICENSE-2.0.html",
//			      name = "Apache 2.0"
//			    )
			)
		)
@SecurityScheme(
	    name = "bearerAuth",
	    scheme = "bearer",
	    bearerFormat = "JWT", 
	    type = SecuritySchemeType.HTTP, 
	    in = SecuritySchemeIn.HEADER
	)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping(value = URIConstants.FORWARD_SLASH)
	public String hello() {
		return"Hello World!";
	}

}
