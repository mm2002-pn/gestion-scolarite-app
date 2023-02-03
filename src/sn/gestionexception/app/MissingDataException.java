package sn.gestionexception.app;

public class MissingDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingDataException(String message) {
		super(message);
	}

}
