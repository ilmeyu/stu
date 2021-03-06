package com.ilem.dto.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ilme
 * @date 2019/11/1 11:51 上午
 **/
public abstract class RestPageRequest implements RestInput {
	private static final long serialVersionUID = 5762291504971259278L;

	@ApiModelProperty(value = "记录条数", required = true)
	private Integer limit;

	@ApiModelProperty(value = "页码", required = true)
	private Integer page;

	@Override
	public void doCheck() {
		check(null != limit, "记录条数不允许为空");
		check(null != page, "页码不允许为空");
		check(1000 < limit || 0 > limit, "记录条数不能小于0或者大于1000");
		check(0 < page, "页码不能小于0");
	}
}
