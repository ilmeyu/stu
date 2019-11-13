package com.ilem.converter;

import com.ilem.domain.AuthUser;
import com.ilem.dto.input.UserListRestIn;
import com.ilem.dto.input.user.AuthUserListRpcIn;
import com.ilem.dto.output.UserRestOut;
import org.mapstruct.Mapper;

/**
 * @author yuwenkai
 * @date 2019/10/29 7:59 上午
 **/
@Mapper(componentModel = "spring")
public interface UserConverter {

	UserRestOut userRpc2Rest(AuthUser rpc);

	AuthUserListRpcIn userListRest2Rpc(UserListRestIn rest);
}
