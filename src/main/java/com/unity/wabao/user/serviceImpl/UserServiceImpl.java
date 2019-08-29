package com.unity.wabao.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unity.wabao.user.mapper.UserMapper;
import com.unity.wabao.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public String get(int id){
		return userMapper.get(id);
	}
	
	//校验手机号是否唯一
	public boolean checkTel(String tel){
		int result = userMapper.checkTel(tel);
		if(result==0){
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
}
