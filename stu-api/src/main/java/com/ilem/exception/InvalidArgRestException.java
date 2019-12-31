package com.ilem.exception;

/**
 * @Author ilem
 * @date 2019/12/31 11:00 上午
 * @since 1.0.0
 **/
public class InvalidArgRestException extends RuntimeException {
	private static final long serialVersionUID = -5065549290154985412L;

	public InvalidArgRestException(String message) {
		super(message);
	}

	public InvalidArgRestException(String message, Throwable ex) {
		super(message, ex);
	}
}
