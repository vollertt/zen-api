package com.zen.util;

public class MesssageException {

	private String message;
	private String error;
	private int status;
	
	public MesssageException() {
	}	

	public MesssageException(int status, String error, String message) {
		this.message = message;
		this.error = error;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	

}
