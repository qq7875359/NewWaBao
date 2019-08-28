package com.unity.wabao.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unity.wabao.user.mapper.UserMapper;
import com.unity.wabao.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public String getUsername(int id){
		return userMapper.get(id);
	}
}
