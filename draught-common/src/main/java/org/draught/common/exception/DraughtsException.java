package by.bsuir.rusdraughtstraining.rus_draughts_training;

public class DraughtsException extends Exception {

/**
 * @author Tatyana_Gladchenko
 *		<p>
 *      	High level project exception
 *      </p>
 */
	private static final long serialVersionUID = 1L;
	private Exception hiddenException;
	
	public DraughtsException(String msg, Exception e) {
		super(msg, e);
		this.hiddenException = e;
	}
	public DraughtsException(String msg) {
		super(msg);
	}
	public DraughtsException(Throwable cause) {
		super(cause);
	}
	public Exception getHiddenException() {
		return hiddenException;
	}	
}
