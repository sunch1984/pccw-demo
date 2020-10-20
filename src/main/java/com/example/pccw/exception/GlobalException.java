package com.example.pccw.exception;

public class GlobalException extends Throwable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2503338270799910844L;
	private String status;
	private String message;

	public GlobalException(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
