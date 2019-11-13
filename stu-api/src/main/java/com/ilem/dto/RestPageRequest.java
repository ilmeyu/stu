package com.ilem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yuwenkai
 * @date 2019/11/1 11:51 上午
 **/
@Getter
@Setter
public class RestPageRequest implements Serializable {
	private static final long serialVersionUID = 5762291504971259278L;

	@ApiModelProperty(value = "记录条数", required = true)
	private Integer limit;

	@ApiModelProperty(value = "页码", required = true)
	private Integer page;
}
