<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册</title>
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/register.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="js/google-maps.js"></script>
<script>$(document).ready(function(){$(".vertical-nav").verticalnav({speed: 400,align: "left"});});</script>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div id="register">
			<form:form id="registerForm"  method="Post" action="adduser" commandName="userInfo">
				 <table>
					 <tr>
					 	<td>用户名:<FONT color="red"><form:errors path="userName" /></FONT></td>
					 </tr>
					 <tr>
					 	<td><form:input path="userName" /></td>
					 </tr>
					 <tr>
					 	<td>密码:<FONT color="red"><form:errors path="password" /></FONT></td>
					 </tr>
					 <tr>
					 	<td><form:password path="password" /></td>
					 </tr>
					 <tr>
					 	<td>确认密码:<FONT color="red"><form:errors path="confirmPassword" /></FONT></td>
					 </tr>
					 <tr>
					 	<td><form:password path="confirmPassword" /></td>
					 </tr>
					 <tr>
					 	<td>Email:<FONT color="red"><form:errors path="email" /></FONT></td>
					 </tr>
					 <tr>
					 	<td><form:input path="email" /></td>
					 </tr>
					 <tr>
					 	<td><input type="submit" value="提交" width="10px" /></td>
					 </tr>
				 </table>
			</form:form>
		</div>
</body>
</html>