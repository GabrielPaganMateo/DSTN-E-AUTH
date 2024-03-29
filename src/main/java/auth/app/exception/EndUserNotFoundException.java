package auth.app.exception;

public class EndUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EndUserNotFoundException() {
		super("Unknown username & password");
	}
	
	public EndUserNotFoundException (String message) {
		super(message);
	}

}
