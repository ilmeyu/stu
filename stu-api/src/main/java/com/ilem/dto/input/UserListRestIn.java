package com.ilem.dto.input;

import com.ilem.dto.RestPageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author yuwenkai
 * @date 2019/10/28 7:16 下午
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel(value = "用户列表检索条件")
public class UserListRestIn extends RestPageRequest {

	private static final long serialVersionUID = 6694842473634899713L;


	@ApiModelProperty(value = "用户名")
	private String name;

	@ApiModelProperty(value = "状态")
	private String status;

}
