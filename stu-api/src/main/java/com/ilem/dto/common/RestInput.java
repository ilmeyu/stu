package com.ilem.dto.common;

import com.ilem.exception.InvalidArgRestException;

import java.io.Serializable;

/**
 * @Author ilem
 * @date 2019/12/31 10:09 上午
 * @since 1.0.0
 **/
public interface RestInput extends Serializable {

	void doCheck();

	default void check(Boolean except, String msg) {
		if (!except) {
			throw new InvalidArgRestException(msg);
		}
	}
}
