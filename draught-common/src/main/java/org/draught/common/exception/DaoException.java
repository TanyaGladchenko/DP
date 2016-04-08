package by.bsuir.rusdraughtstraining.rus_draughts_training;

/**
 * @author Tatyana_Gladchenko
 *
 * 		<p>
 *      	Database layer exception
 *      </p>
 *
 */

public class DaoException extends DraughtsException{

	private static final long serialVersionUID = 1L;
	private Exception hiddenException;  	
	
	public DaoException(String msg) {
		super(msg);
	}
	
	public DaoException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
	public Exception getHiddenException() {
		return hiddenException;
	}
}
