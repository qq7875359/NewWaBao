package com.unity.wabao.user.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	String get(@Param("id")int id);
}
