package com.unity.wabao.user.pojo;

public class User extends UserEntity<User>{
	
	private String username;	//账号	
	private String password;	//密码
	private String tel;			//手机号
	
	//无参构造器
	public User(){
		
	}
	//有参构造器
	public User(int id){
		super(id);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
