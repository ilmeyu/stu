package com.ilem.exception;

/**
 * @Author ilem
 * @date 2019/12/31 11:48 上午
 * @since 1.0.0
 **/
public class RestException extends RuntimeException {

	private static final long serialVersionUID = -5970399266242246983L;

	public RestException() {
		super();
	}

	public RestException(String message) {
		super(message);
	}

	public RestException(String message, Throwable ex) {
		super(message, ex);
	}

}
