package com.ilem.dto.input;

import com.ilem.dto.common.Input;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ilme
 * @date 2019/11/13 2:49 下午
 **/
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "新增用户")
public class UserAddRestIn implements Serializable, Input {
	private static final long serialVersionUID = 3337780421417983107L;

	@ApiModelProperty(value = "ID")
	private String id;

	@ApiModelProperty(value = "用户名")
	private String name;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "邮件")
	private String email;

	@ApiModelProperty(value = "手机号")
	private String phone;

	@Override
	public void doCheck() {

	}
}
