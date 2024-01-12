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
@Schema(description = "Register User model")
public class RegisterRequest {
	
	@Schema(description = "Username", example = "greatkhali")
	private String username;
	
	@Schema(description = "Password", example = "P@ssword#123")
	private String password;
//	private String firstname;
//	private String lastname;
	
	@Schema(description = "Email", example = "khali@gmail.com")
	private String email;

}
