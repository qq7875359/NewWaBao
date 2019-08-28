package com.unity.wabao.user.pojo;

import java.sql.Date;

public class UserEntity<T> extends BaseEntity<T>{

	//创建时间
	protected Date createTime;
	
	//修改时间
	protected Date updateTime;
	
	//无参构造器
	public UserEntity(){
		
	}
	//有参无参构造器
	public UserEntity(int id){
		super(id);
	}
	
	
}
