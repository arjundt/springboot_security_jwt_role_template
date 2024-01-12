package in.cdac.epramaan.security.jwt.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Autenticate User model")
public class AuthenticateRequest {
	
	@Schema(description = "Username", example = "greatkhali")
	private String username;
	
	@Schema(description = "Password", example = "AnyTh!ng@123")
	private String password;

}
