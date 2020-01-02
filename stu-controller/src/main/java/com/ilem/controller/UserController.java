package com.ilem.controller;

import com.ilem.dto.common.RestResponse;
import com.ilem.dto.input.*;
import com.ilem.dto.output.UserRestOut;
import com.ilem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ilme
 * @date 2019/10/28 5:03 下午
 **/
@Api(value = "用户管理")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "用户列表")
	@PostMapping(value = "/list")
	public RestResponse<List<UserRestOut>> list(@RequestBody UserListRestIn request) {
		return RestResponse.ok(userService.list(request));
	}

	@ApiOperation(value = "新增用户")
	@PostMapping(value = "/add")
	public RestResponse<Boolean> add(@RequestBody UserAddRestIn request) {
		return RestResponse.ok(userService.add(request));
	}

	@ApiOperation(value = "通过id删除用户")
	@PostMapping(value = "/delById")
	public RestResponse<Boolean> add(@RequestBody UserDelRestIn request) {
		return RestResponse.ok(userService.del(request));
	}

	@ApiOperation(value = "通过id查询用户")
	@PostMapping(value = "/QueryById")
	public RestResponse<UserRestOut> add(@RequestBody UserQueryById request) {
		return RestResponse.ok(userService.query(request));
	}

	@ApiOperation(value = "通过id更新用户")
	@PostMapping(value = "/updateById")
	public RestResponse<Boolean> add(@RequestBody UserUpdateById request) {
		return RestResponse.ok(userService.update(request));
	}
}
