package in.cdac.epramaan.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
//@UtilityClass
public final class URIConstants {
	public static final String FORWARD_SLASH="/";
	public static final String QUESTION_MARK="?";
	public static final String STAR_STAR="**";
	
	public static final String SECURITY_OPEN_URL="api/v1/auth";
	public static final String REGISTER="register";
	public static final String AUTHENTICATE="authenticate";
	
	public static final String API="api";
	public static final String ADMIN="admin";
	public static final String USER="user";
	public static final String FIDUCIARY="fiduciary";
	public static final String DATA_PRINCIPLE="dp";
	public static final String TEST="test";
	
}
