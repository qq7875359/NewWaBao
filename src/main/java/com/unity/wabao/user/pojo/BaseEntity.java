package com.unity.wabao.user.pojo;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//id
	protected int id;
	
	//无参构造器
	public BaseEntity(){
		
	}
	
	//有参构造器
	public BaseEntity(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
