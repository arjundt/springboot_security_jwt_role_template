package in.cdac.epramaan.util;

import in.cdac.epramaan.common.model.EpError;

public enum EpFieldError implements EpError{
    
    CONFIRM_PASSWORD_NOTMATCH("error.confirmpassword.message"),
    
    NAME_REQUIRED("error.field.required"),
    
    USERNAME_REQUIRED("error.field.required"),
    
    USERNAME_NOT_AVAILABLE("error.username.not.available"),
    
    USERNAME_AVAILABLE("error.username.available"),
    
    OLD_PASSWORD_REQUIRED("error.field.required"),
    
    PASSWORD_REQUIRED("error.field.required"),
    
    PASSWORD_NOTMATCH("error.password.message"),
    
    CONFIRM_PASSWORD_REQUIRED("error.field.required"),
    
    EMAIL_REQUIRED("error.field.required"),
    
    MOBILE_REQUIRED("error.field.required"),
	
	//FIELD ERROR CODE
    REQUIRED_FIELD("error.required_field.message"),
    
    /**  Invalid Captcha. */
    CAPTCHA_INVALID("error.invalid.captcha"),
    
    CAPTCHA_REQUIRED("error.empty.captcha");
    
    
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
    private EpFieldError(String errorCode) {
        this.errorCode = errorCode;
    }
}
