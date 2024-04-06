package auth.app.exception;

public class EndUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EndUserException() {
		super("Unknown username & password");
	}
	
	public EndUserException (String message) {
		super(message);
	}

}
