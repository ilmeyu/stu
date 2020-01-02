package com.ilem.dto.input;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Author ilem
 * @date 2020/1/2 11:18 上午
 * @since 1.0.0
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "更新用户")
public class UserUpdateById extends UserAddRestIn {

	private static final long serialVersionUID = -4767548990779045312L;

	@Override
	public void doCheck() {
		check(null != super.getId(), "id不允许为空！");
	}
}
