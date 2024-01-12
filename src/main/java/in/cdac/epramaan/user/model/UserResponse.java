package in.cdac.epramaan.user.model;

import in.cdac.epramaan.common.model.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	User user;
	Response response;

}
