package com.ilem.service;

import com.ilem.dto.input.*;
import com.ilem.dto.output.UserRestOut;

import java.util.List;

/**
 * @author ilme
 * @date 2019/10/28 4:27 下午
 **/
public interface UserService {

	List<UserRestOut> list(UserListRestIn rest);

	Boolean add(UserAddRestIn rest);

	Boolean del(UserDelRestIn rest);

	UserRestOut query(UserQueryById rest);

	Boolean update(UserUpdateById rest);
}
