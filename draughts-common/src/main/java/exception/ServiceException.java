package exception;

import org.springframework.dao.DataAccessException;

/**
 * @author Gladchenko_Tatyana
 *
 *         <p>
 *         Service layer exception
 *         </p>
 *
 */
public class ServiceException extends DataAccessException {

	private static final long serialVersionUID = 1L;
	private Exception hiddenException;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Exception e) {
		super(msg);
		hiddenException = e;
	}

	public Exception getHiddenException() {
		return hiddenException;
	}
}
