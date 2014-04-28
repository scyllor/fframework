package me.scylla.fframework.utils.Exception;

public class SignonException extends AbstractModuleException {
	private static final long serialVersionUID = 8479576962389396867L;

	public SignonException() {
		super();
	}

	public SignonException(String message, Throwable cause) {
		super(message, cause);
	}

	public SignonException(String message) {
		super(message);
	}

	public SignonException(Throwable cause) {
		super(cause);
	}
}
