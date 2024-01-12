package in.cdac.epramaan.util;

public enum EpMessage {

	MSG_FOR_SUCCESS_REFRESH_MASTER_CACHE(
			"msg.system.refresh.mastercache.success"),

	MSG_FOR_SUCCESSFUL_USER_VALIDATION("msg.validate.user.success"),

	MSG_FOR_SUCCESSFUL_LOG_OUT("msg.user.success.logout"),
	
	MSG_FOR_PSW_CPSW_NOT_MATCH("msg.user.pswandcpsw.notmatch"),
	
	MSG_FOR_PSW_OLDPSW_NOT_MATCH("msg.user.pswandopsw.notmatch"),
	
	
	//Admin user related messages//	
	USER_REGISTER_SUCCESS("msg.user.register.success"),
    
    USER_REGISTER_FAILED("msg.user.register.failed"),
    
    SMTP_EMAILVERIFICATIONSUBJECT("smtp.emailverificationsubject"),    
    SMTP_EMAILVERIFICATIONCONTENT1("smtp.emailverificationcontent1"),    
    SMTP_EMAILVERIFICATIONCONTENT2("smtp.emailverificationcontent2"),    
    SMTP_EMAILVERIFICATIONCONTENT3("smtp.emailverificationcontent3"),
    
    
    SMTP_SETPASSWORDSUBJECT("smtp.setpasswordsubject"),    
    SMTP_SETPASSWORDCONTENT1("smtp.setpasswordcontent1"),    
    SMTP_SETPASSWORDCONTENT2("smtp.setpasswordcontent2"),    
    SMTP_SETPASSWORDCONTENT3("smtp.setpasswordcontent3"),
    
    SMS_MOBILE_VERIFICATION_CONTENT("sms.verify.user.mobile"),
    

	/**----------------------------- EMAIL MESSAGE KEYS -------------------------------------------*/
	SMTP_ALERT_MOU_RENEWAL_SUBJECT("smtp.alert.mourenewalsubject"),
	SMTP_ALERT_MOU_RENEWAL_CONTENT1("smtp.alert.mourenewalcontent1"),
	SMTP_ALERT_MOU_RENEWAL_CONTENT2("smtp.alert.mourenewalcontent2"),
	SMTP_ALERT_MOU_RENEWAL_CONTENT3("smtp.alert.mourenewalcontent3"),
	SMTP_ALERT_MOU_RENEWAL_CONTENT4("smtp.alert.mourenewalcontent4"),
	
	SMTP_ALERT_SP_ACTIVATED_SUBJECT("smtp.alert.activationsubject"),
	SMTP_ALERT_SP_ACTIVATED_CONTENT1("smtp.alert.activationcontent1"),
	SMTP_ALERT_SP_ACTIVATED_CONTENT2("smtp.alert.activationcontent2"),
	SMTP_ALERT_SP_ACTIVATED_CONTENT3("smtp.alert.activationcontent3"),
	SMTP_ALERT_SP_ACTIVATED_CONTENT4("smtp.alert.activationcontent4"),
	
	SMTP_ALERT_SERVICE_ACTIVATED_SUBJECT("smtp.alert.service.activationsubject"),
	SMTP_ALERT_SERVICE_ACTIVATED_CONTENT1("smtp.alert.service.activationcontent1"),
	SMTP_ALERT_SERVICE_ACTIVATED_CONTENT2("smtp.alert.service.activationcontent2"),
	SMTP_ALERT_SERVICE_ACTIVATED_CONTENT3("smtp.alert.service.activationcontent3"),
    
	SMTP_ALERT_SERVICE_EDITABLE_SUBJECT("smtp.alert.service.editablesubject"),
	SMTP_ALERT_SERVICE_EDITABLE_CONTENT1("smtp.alert.service.editablecontent1"),
	SMTP_ALERT_SERVICE_EDITABLE_CONTENT2("smtp.alert.service.editablecontent2"),
	SMTP_ALERT_SERVICE_EDITABLE_CONTENT3("smtp.alert.service.editablecontent3"),
	
	/*------------------------email verification for service------------------------------*/
	
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT1("smtp.email.spuser.service.content1"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT2("smtp.email.spuser.service.content2"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT3("smtp.email.spuser.service.content3"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT4("smtp.email.spuser.service.content4"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT5("smtp.email.spuser.service.content5"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT6("smtp.email.spuser.service.content6"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT7("smtp.email.spuser.service.content7"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT8("smtp.email.spuser.service.content8"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT9("smtp.email.spuser.service.content9"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT10("smtp.email.spuser.service.content10"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT11("smtp.email.spuser.service.content11"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT12("smtp.email.spuser.service.content12"),
	SMTP_EMAIL_SPUSER_SERVICE_CONTENT13("smtp.email.spuser.service.content13"),
	
	/*for email verifdication*/
	SMTP_SERVICE_EMAIL_ACTIVATION_CONTENT1("smtp.service.email.activation.content1"),
	
    ;

	/** The error code. */
	private final String msgCode;

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getMsgCode() {
		return msgCode;
	}

	/**
	 * Instantiates a new error codes.
	 * 
	 * @param errorCode
	 *            the error code
	 */
	private EpMessage(String msgCode) {
		this.msgCode = msgCode;
	}

}
