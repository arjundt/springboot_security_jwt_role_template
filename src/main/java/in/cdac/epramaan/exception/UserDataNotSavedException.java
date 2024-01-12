package in.cdac.epramaan.exception;

public class UserDataNotSavedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDataNotSavedException() {
        super("User data could not be saved.");
    }

    public UserDataNotSavedException(String message) {
        super(message);
    }


}
