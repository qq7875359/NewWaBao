package com.unity.wabao.user.utils;

public enum ResponseCode {
	
	SUCCESS("1","SUCCESS"),
	ERROR("0","ERROR");
	
	
	private final String code;
	private final String desc;
	
	private ResponseCode(String code,String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getDesc(){
		return desc;
	}
}
