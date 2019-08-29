package com.unity.wabao.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unity.wabao.user.mobilecheck.MoblieCheckUtil;
import com.unity.wabao.user.service.UserService;
import com.unity.wabao.user.utils.ResponseCode;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	
/*	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String TEL		 = "tel";
	private static final String CODE     = "code";*/
	
	
	@Autowired
	private UserService userService;
	/**
	 * 
	 * 账号密码登录接口
	 * @return
	 */
	
	@RequestMapping(value="index")
	public String index(String tel,String code){
		System.out.println(tel);
		System.out.println(code);
		return "userLogin/upLogin";
	}
	
	@RequestMapping(value="get_upLogin")
	public String toUpLogin(){
		return "userLogin/telLogin";
	}

/*	
	
	/**
	 * 
	 * 生成验证码接口
	 * @param tel
	 * @return
	 */
	
	@RequestMapping(value="telcode_generate",method=RequestMethod.GET)
	public void telCodeGenerate(String tel){
		//apache.common下面的判断非空方法.1、空格参数 isEmpty没有忽略空格参数，是以是否为空和是否存在为判断依据。而isBlank忽略了空格参数。 2、层次 isBlank 是在isEmpty的基础上进行了为空（字符串都为空格、制表符、tab 的情况）的判断。因此isBlank层次更高
		if(StringUtils.isNotBlank(tel)){
			if(userService.checkTel(tel)){
				System.out.println("-------");
				 MoblieCheckUtil.getRequest2(tel); 
			}
		}
		 
	}
	
	/**
	 * 短信验证接口，这里有一些欠缺，因为和前台数据交互是用的ajax.
	 * 所以return的返回值是被ajax的success方法接收了.
	 * 所以并不能进行页面的跳转
	 * 所以当ajax和springMVC一起使用的时候，在需要页面跳转的时候还是不要用ajax比较好。
	 * 这个接口只是返回了一个成功
	 * @return
	 */
	@RequestMapping(value="tel_login",method=RequestMethod.GET)
	@ResponseBody
	 public String tellogin(String tel,String code){
		//为什么使用StringUtils和上面同理
		if(StringUtils.isNotBlank(tel) && StringUtils.isNotBlank(code)){
			if(userService.checkTel(tel)){
				if(code.equals(MoblieCheckUtil.getRandomCode())){
					return ResponseCode.SUCCESS.getCode();
				}else{
					return ResponseCode.ERROR.getCode();
				}
			}
		}
		return ResponseCode.ERROR.getCode();
	}

/**
 * 这里可能有一些欠缺,因为前面的是用Ajax提交的,然后想要后台登录,所以在ajax的success里面放置接口的调用
 * 短信登录成功接口
 */
	@RequestMapping(value="tel_login_success",method=RequestMethod.GET)
	public String loginSuccess(){
		return "index";
	}
}