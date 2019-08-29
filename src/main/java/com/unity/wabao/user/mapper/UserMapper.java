package com.unity.wabao.user.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	//查询手机号为tel的个数，一般情况下是0或者1，当前业务当为0的时候说名数据库中无该手机号，登录失败，返回1正确。
	int checkTel(@Param("tel")String tel);
	
	String get(int id);
}
