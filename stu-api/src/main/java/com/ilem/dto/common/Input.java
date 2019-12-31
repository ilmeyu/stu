package com.ilem.dto.common;

import com.ilem.exception.InvalidArgRestException;
import com.sun.istack.internal.NotNull;

/**
 * @Author ilem
 * @date 2019/12/31 10:09 上午
 * @since 1.0.0
 **/
public interface Input {

	void doCheck();

	default void check(@NotNull Boolean exp, String msg) {
		if (Boolean.FALSE == exp) {
			throw new InvalidArgRestException(msg);
		}
	}
}