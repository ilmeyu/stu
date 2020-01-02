package com.ilem.service.impl;

import com.ilem.converter.UserConverter;
import com.ilem.domain.AuthUser;
import com.ilem.dto.input.*;
import com.ilem.dto.input.user.AuthUserAddRpcIn;
import com.ilem.dto.input.user.AuthUserDeleteRpcIn;
import com.ilem.dto.input.user.AuthUserQueryRpcIn;
import com.ilem.dto.input.user.AuthUserUpdateRpcIn;
import com.ilem.dto.output.UserRestOut;
import com.ilem.exception.RestException;
import com.ilem.server.AuthUserService;
import com.ilem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ilme
 * @date 2019/10/28 4:28 下午
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Reference
	private AuthUserService authUserService;

	@Autowired
	UserConverter userConverter;

	@Override
	public List<UserRestOut> list(UserListRestIn rest) {
		AuthUserQueryRpcIn userListRpcIn = userConverter.userListRest2Rpc(rest);

		List<AuthUser> authUsers = authUserService.queryUserList(userListRpcIn);

		if (null == authUsers || authUsers.isEmpty()) {
			return Collections.emptyList();
		}

		List<UserRestOut> userListRest = new ArrayList<>();

		authUsers.forEach((e) -> userListRest.add(userConverter.userRpc2Rest(e)));

		return userListRest;
	}

	@Override
	public Boolean add(UserAddRestIn rest) {
		AuthUserAddRpcIn authUserAddRpcIn = userConverter.userAddRest2Rpc(rest);
		AuthUser userRpcOut = authUserService.userAdd(authUserAddRpcIn);

		if (null == userRpcOut) {
			log.error("用户新增失败！");
			throw new RuntimeException();
		}

		return Boolean.TRUE;
	}

	@Override
	public Boolean del(UserDelRestIn rest) {
		AuthUserDeleteRpcIn userDelRpcIn = userConverter.userDelRest2Rpc(rest);
		Integer result = authUserService.userDelete(userDelRpcIn);

		if (null == result || 0 == result) {
			throw new RestException("用户删除失败！用户该用户似乎不存在！");
		}
		return Boolean.TRUE;
	}

	@Override
	public UserRestOut query(UserQueryById rest) {
		AuthUserQueryRpcIn userQueryRpcIn = userConverter.userQueryRest2Rpc(rest);
		AuthUser userRpcOut = authUserService.userSingleQuery(userQueryRpcIn);
		return userConverter.userQueryRpc2Rest(userRpcOut);
	}

	@Override
	public Boolean update(UserUpdateById rest) {
		AuthUserUpdateRpcIn userUpdateRpcIn = userConverter.userUpdateRest2Rpc(rest);
		Integer result = authUserService.userUpdate(userUpdateRpcIn);

		if (null == result || 0 == result) {
			throw new RestException("用户更新失败！用户该用户似乎不存在！");
		}
		return Boolean.TRUE;
	}
}
