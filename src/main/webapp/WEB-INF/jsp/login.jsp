<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div align="center">
		<form action="login" method="post">
			<h2 style="color: red">${msg}</h2>
			<table>
				用户名：<input type="text" name="username">
				密&nbsp;码：<input type="text" name="password">
			</table>
			<input type="submit" value="登录">
			<a href="zhuce"> 注册</a>
		</form>
	</div>

</body>