package com.ilem.dto.output;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yuwenkai
 * @date 2019/10/28 4:46 下午
 **/
@Setter
@Getter
@Accessors(chain = true)
@ApiModel(value = "用户信息")
public class UserRestOut implements Serializable {

	private static final long serialVersionUID = 7403838750649947572L;

	/** 用户ID */
	private String id;

	/** 用户代码 */
	private String code;

	/** 用户名 */
	private String name;

	/** 头像 */
	private String avatar;

	/** 机构 */
	private String orgId;

	/** 邮件 */
	private String email;

	/** 手机号 */
	private String phone;

	/** 状态 */
	private String status;
}
