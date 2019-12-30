package com.ilem.controller;

import com.ilem.dto.RestResponse;
import com.ilem.dto.input.UserAddRestIn;
import com.ilem.dto.input.UserListRestIn;
import com.ilem.dto.output.UserRestOut;
import com.ilem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuwenkai
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
}
