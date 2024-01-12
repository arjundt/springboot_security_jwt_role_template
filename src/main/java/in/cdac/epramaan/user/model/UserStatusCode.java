package in.cdac.epramaan.user.model;

public enum UserStatusCode {

	REGISTERED("R"),
	
	VERIFIED("V"),
	
	ACTIVATED("A"),
	
	DEACTIVATED("D");
	
	private String statusCode;

	public String getStatusCode() {
		return statusCode;
	}

	private UserStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
