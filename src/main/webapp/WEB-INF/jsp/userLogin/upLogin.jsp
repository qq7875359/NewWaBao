<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

		<script type="text/javascript" src="js/upLogin/script.js"></script>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10,IE=11,edge" />
<!-- 		<link rel="stylesheet" type="text/css" href="fonts/iconfont.css"/>
 -->		<link rel="stylesheet" type="text/css" href="css/upLogin/dialog.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/userLogin/css/upLogin/dialog.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/userLogin/css/upLogin/login.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/userLogin/css/upLogin/footer.css" />
		<title>登录</title>		
	</head>
	<body>
		<div class="header-logo">
			<a href="##">
				<span class="logo">logo部分</span>
			</a>
		</div>
		<div class="login-box">		
			<div class="login-title">登录</div>
			<div class="login-form">
				<form action="" id="form">
					<!--账户名-->
					<div class="form-item user">
						<div class="form-ctrl">
							<input type="text" id="userMail" name="username" value="" placeholder="昵称" style="vertical-align:top">
						</div>
						<div class="form-tips">							
							<span class="error" id="user_error" style="display: none;">用户名不能为空</span>							
						</div>
					</div>
					<!--密码-->
					<div class="form-item pass">
                        <div class="form-ctrl">
                            <input type="password" id="userPassword" name="password" value="" placeholder="请输入密码">
                        </div>
                        <div class="form-tips">                        	
                        	<span class="error" id="pass_error" style="display: none;">密码不能为空</span>                        	
                        </div>
                    </div>
                    
                    <!--记住密码-->
                    <div class="form-item box">
                        <div class="rememb">
                            <div class="checkbox-group">
                                <input type="checkbox" checked="checked" id="save_pass" class="isRemberPass">
                                <label for="save_pass" class="checkbox">记住密码</label>
                            </div>
                        </div>
                        
                        <div class="box-fr">
                            <a href="#" class="btn btn-link">忘记密码?</a>
                        </div>
                    </div>
                    
                    <!--登录按钮-->
                    <div class="form-item form-button">
                        <button type="button" class="btn btn-green block btn-login" onclick="checkForm()">登录 </button>
                    </div>
                    
                    <div style="margin-left:210px">
					<a href="${pageContext.request.contextPath}/user/get_upLogin" class="btn btn-link">使用手机号登录</a> 
					</div>                                                                          
				</form>
			</div>
		</div>
		<!--页脚版权相关-->
		<div class="footer">
			<div>
		        <div>
		            <span class="copy">©<span>17素材网 |  
		            	<a href="http://www.17sucai.com" class="btn-link">官网首页</a> |
		            	<a href="http://www.17sucai.com/about.html" class="btn-link">关于我们</a> | 
		            	<a href="http://www.17sucai.com/pay/jf-jb" class="btn-link">积分获取</a> | 
		            	<a href="http://www.17sucai.com/rule.html" class="btn-link">用户协议</a> 	
		            	<a href="http://www.17sucai.com/pins/tagall.html" class="btn-link">标签搜索</a> |	
		                <a href="http://www.miibeian.gov.cn/" target="_blank" class="beiang">浙ICP备13006792号</a>
		        	</span></span>
		        </div>
		        <div>© 2017 http://www.17sucai.com 版权所有</div>
		    </div>
		</div>
		
		<!--信息提示框-->
		<div class="dialog-content"></div>		
		
		<script src="js/upLogin/jquery.min.js" type="text/javascript"></script>
		<script src="js/upLogin/dialog.js" type="text/javascript"></script>
		<script type="text/javascript">	

			function checkForm(){
				var username = document.getElementById("userMail").value;
		        var password = document.getElementById("userPassword").value;
		        //是否记住登录密码  默认记住登录密码true
		        var isCheck = document.getElementsByClassName("isRemberPass")[0].checked;
		        var isRemberPass = '1';
		        if(isCheck){
		        	isRemberPass = '1';
		        }else{
		        	isRemberPass = '0';
		        }
		     
		       
		 
		        var userError = document.getElementById("user_error");
		        var passError = document.getElementById("pass_error");
                               
                if (username == "" || username == null || username == undefined) {		             
		             userError.style.cssText='display:block;';
		             passError.style.cssText='display:none;';
		             return false;
		           
		        } else if (password == "" || password == null || password == undefined) {
		            passError.style.cssText='display:block;';
		            userError.style.cssText='display:none;';
		            return false;
		            
		        }else{
		        	passError.style.cssText='display:none;';
		            userError.style.cssText='display:none;';
		    		
		    		//ajax后台post登录请求 （假设登录成功）
		    		
		    		dialog($,'success','登陆成功！');
//					dialog($,'error','登陆失败！');
		    		
		    		
		        }


			}

			
		
		</script>
		
	</body>
</html>
		