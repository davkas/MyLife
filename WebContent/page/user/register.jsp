<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户注册</title>
</head>
<body>
	<form:form method="Post" action="register" commandName="userinfo">
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
			 	<td><input type="submit" value="提交" /></td>
			 </tr>
		 </table>
	</form:form>
</body>
</html>