package com.ilem.converter;

import com.ilem.domain.AuthUser;
import com.ilem.dto.input.*;
import com.ilem.dto.input.user.AuthUserAddRpcIn;
import com.ilem.dto.input.user.AuthUserDeleteRpcIn;
import com.ilem.dto.input.user.AuthUserQueryRpcIn;
import com.ilem.dto.input.user.AuthUserUpdateRpcIn;
import com.ilem.dto.output.UserRestOut;
import org.mapstruct.Mapper;

/**
 * @author ilme
 * @date 2019/10/29 7:59 上午
 **/
@Mapper(componentModel = "spring")
public interface UserConverter {

	UserRestOut userRpc2Rest(AuthUser rpc);

	AuthUserQueryRpcIn userListRest2Rpc(UserListRestIn rest);

	AuthUserAddRpcIn userAddRest2Rpc(UserAddRestIn rest);

	AuthUserDeleteRpcIn userDelRest2Rpc(UserDelRestIn rest);

	AuthUserQueryRpcIn userQueryRest2Rpc(UserQueryById rest);

	UserRestOut userQueryRpc2Rest(AuthUser rpc);

	AuthUserUpdateRpcIn userUpdateRest2Rpc(UserUpdateById rest);
}
