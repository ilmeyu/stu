package com.ilem.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yuwenkai
 * @date 2019/10/29 11:51 上午
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel(value = "rest响应数据")
public class RestResponse<T> implements Serializable {
	private static final long serialVersionUID = 9046332001579895894L;

	private Integer code;

	private T data;

	private String msg;

	public static <T> RestResponse<T> ok(T t) {
		return
		new RestResponse<T>()
			.setCode(0)
			.setData(t)
			.setMsg("Ok");
	}

}
