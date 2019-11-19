package com.ilem.service.impl;

import com.ilem.converter.UserConverter;
import com.ilem.domain.AuthUser;
import com.ilem.dto.input.UserAddRestIn;
import com.ilem.dto.input.UserListRestIn;
import com.ilem.dto.input.user.AuthUserListRpcIn;
import com.ilem.dto.output.UserRestOut;
import com.ilem.server.AuthUserService;
import com.ilem.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yuwenkai
 * @date 2019/10/28 4:28 下午
 **/
@Service
public class UserServiceImpl implements UserService {

	@Reference
	private AuthUserService authUserService;

	@Autowired
	UserConverter userConverter;

	@Override
	public List<UserRestOut> list(UserListRestIn rest) {
		AuthUserListRpcIn userListRpcIn = userConverter.userListRest2Rpc(rest);

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
		return null;
	}
}
