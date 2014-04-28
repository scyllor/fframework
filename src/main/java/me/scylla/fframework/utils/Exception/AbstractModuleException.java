package me.scylla.fframework.utils.Exception;

public abstract class AbstractModuleException extends Exception {
	private static final long serialVersionUID = -3058080782031561490L;

	public AbstractModuleException() {
		super();
	}

	public AbstractModuleException(String message, Throwable cause) {
		super(message, cause);
	}

	public AbstractModuleException(String message) {
		super(message);
	}

	public AbstractModuleException(Throwable cause) {
		super(cause);
	}

}