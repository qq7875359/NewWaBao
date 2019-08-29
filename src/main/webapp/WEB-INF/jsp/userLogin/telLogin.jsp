<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10,IE=11,edge" />
<!-- 		<link rel="stylesheet" type="text/css" href="fonts/iconfont.css"/>
<link rel="stylesheet" type="text/css" href="css/upLogin/dialog.css" /> -->	
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
							<input id="telphone" name="phoneNum" value="" placeholder="手机号" style="vertical-align:top"/>
						</div>
					</div>
					<div class="form-item pass">
                        <div class="form-ctrl">
                            <input id="code" style="width:150px"  name="codeNum" value="" placeholder="请输入验证码">
                       		 <button type="button" class="btn btn-green" id="getCode" style="width:100px;height:50px;margin-top:5px">点击获取短信验证码</button>
                        </div>
                    </div>
                                                     
				</form>
				<!--登录按钮-->
                    <div class="form-item form-button">
                        <button id="login" class="btn btn-green block btn-login">登录 </button>
                    </div>
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
		
		<script src="${pageContext.request.contextPath}/userLogin/js/common/jquery.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/userLogin/js/common/jquery.validate.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/userLogin/js/common/jquery.validate.min.js" type="text/javascript"></script>		
		<script type="text/javascript">
			$("#getCode").click(function(){
				var tel = $("#telphone").val();
				var code = $("#code").val();
				 $.ajax({
					type:"get",
					url:"${pageContext.request.contextPath}/user/telcode_generate",
					data:{tel:tel},
					success:function(data){ 
					},
					error:function(){}
				}); 
			});
			
			
			$("#login").click(function(){
				var tel = $("#telphone").val();
				console.log(tel);
				var code = $("#code").val();
				console.log(code);
				 $.ajax({
						type:"get",
						url:"${pageContext.request.contextPath}/user/tel_login",
						data:{tel:tel,code:code},
						success:function(data){
							if(data == "1")
								window.location.href="${pageContext.request.contextPath}/user/tel_login_success";
							else
								alert("登录失败");
						},
						error:function(){
							console.log("我失败了");
						}
					}); 
			});
			
			
	         $("#form").validate({
	            rules: {
	                phoneNum: {
	                    required: true,
	                    maxlength:11,
	                    maxlength:11,
	                    isphoneNum:true
	                },
	            	codeNum : {
	            		   required: true,
		                   maxlength:6,
		                   maxlength:6,
		                   isCode:true
	            	}
	            },
	            messages: {
	                phoneNum:{
	                    required:"*请输入手机号",
	                    maxlength:"*请填写11位的手机号",
	                    minlength:"*请填写11位的手机号",
	                    isphoneNum:"请填写正确的手机号码"
	                },
	                codeNum:{
	                	  required:"*请输入验证码",
		                  maxlength:"*请填写6位的验证码",
		                  minlength:"*请填写6位的验证码",
		                  isphoneNum:"请填写正确的验证码"
	                }
	            }
	        });

	        //自定义手机号验证
	        jQuery.validator.addMethod("isphoneNum", function(value, element) {
	            var length = value.length;
	            var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
	            return this.optional(element) || (length == 11 && mobile.test(value));
	        }, "请正确填写您的手机号码");
	        
			//自定义验证码验证
	        jQuery.validator.addMethod("isCode", function(value, element) {
	            var length = value.length;
	            var mobile = /[1-9]{6}$/;
	            return this.optional(element) || (length == 6 && mobile.test(value));
	        }, "请正确填写您的验证码");


			 
			
		</script>
	 
		
	</body>
</html>
		