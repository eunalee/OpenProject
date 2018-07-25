package service;

public class ServiceException extends Exception {

	public ServiceException(String boardInfo, Throwable cause) {
		super(boardInfo, cause);
	}
}