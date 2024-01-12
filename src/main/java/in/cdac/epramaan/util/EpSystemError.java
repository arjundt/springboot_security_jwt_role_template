/*
 * 
 */
package in.cdac.epramaan.util;

import in.cdac.epramaan.common.model.EpError;

/**
 * The Enum SystemError.
 */
public enum EpSystemError implements EpError {

	//USER ERROR CODES
	/** The invalid user. */
	INVALID_USER("U001"),
	
	/** The no user in session. */
	NO_USER_IN_SESSION("U002"),
	
	/** The user locked. */
	USER_LOCKED("U003"),
	
	USER_ACCESS_DENIED("U004"),
	
	USER_SESSION_EXPIRED("U005"),
	
	NO_MASTER_TABLE_SELECTED("U006"),
	
	USER_FOUND_IN_SESSION("U007"),
	
	EMAIL_VERIFICATION_CODE_INVALID("U008"),
	
	EMAIL_VERIFICATION_LINK_EXPIRED("U009"),
	
	EMAIL_VERIFICATION_INVALID_REQUEST("U010"),
	
	SET_PASSWORD_VERIFICATION_CODE_INVALID("U011"),
	
	VERIFIED_EMAIL_NOT_PRESENT("U012"),
	
	MOBILE_VERIFICATION_CODE_INVALID("U013"),
	
	MOBILE_VERIFICATION_TIME_EXPIRED("U014"),
	
	PASSWORD_VERIFICATION_LINK_EXPIRED("U015"),
	
	USER_CREATION_EMAIL_VERIFICATION("U016"),
	
	EMAIL_AND_VEMAIL_SAME("U017"),
	
	MOBILE_AND_VMOBILE_SAME("U018"),
	
	
	//DB ERROR CODES
	
	NO_RECORD_FOUND("DB001"),
	
	DUPLICATE_RECORD("DB002"),
	
	DB_EXCEPTION("DB003"),
	
	
	//SYSTEM ERROR CODES
	
	/** The system internal error. */
	SYSTEM_INTERNAL_ERROR("SYS001"),
	
	/** The http error. */
	HTTP_ERROR("SYS002"),
	
	/**   QUEUEING EXCEPTION. */
    QUEUEING_EXCEPTION("SYS006"),
	
    /** The fail to refresh master cache. */
    FAIL_TO_REFRESH_MASTER_CACHE("SYS007"),
    
    SP_SEARCH_ERROR("SP001"),
    
    SERVICE_SEARCH_ERROR("SP002"),
	
	USER_SEARCH_ERROR("USR001");
	
    /** The error code. */
	private final String errorCode;
	
	

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Instantiates a new error codes.
	 *
	 * @param errorCode the error code
	 */
	private EpSystemError(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
