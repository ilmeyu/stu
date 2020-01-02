package com.ilem.dto.input;

import com.ilem.dto.common.RestInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Author ilem
 * @date 2020/1/2 11:17 上午
 * @since 1.0.0
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "删除用户")
public class UserDelRestIn implements RestInput {

	private static final long serialVersionUID = 3684043569443131052L;

	@ApiModelProperty(value = "ID")
	private String id;

	@Override
	public void doCheck() {
		check(null != id, "id不允许为空！");
	}
}
