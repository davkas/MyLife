<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charse=utf-8">
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<title>xxxxx</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="login">
		<div class="input">
			<form id="loginForm" name="loginForm" method="post" action="loginCheck">
				<div class="name">
					<label>用户名：</label><input type="text" class="text" id="username" placeholder="用户名" name="username" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码：</label><input type="password" class="text" id="password" placeholder="密码" name="password" tabindex="2">
				</div>
				<div class ="fun">
					<input type="button" class="submit" tabindex="3" value="登录" onclick="checkUserForm();">
					<input type="button" class="forgetpassword" tabindex="3" value="忘记密码" onclick="getPassword();">
				</div>
				<div class="check"></div>
				<div class="tip"></div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript">
		if ("${error}" != "") {
			alert("${error}");
		};
		function checkUserForm() {
			var userName = $("#username").val()+'SSSS';
			var userPassword = $("#password").val();
			if (userName == "" || userPassword == "") {
				alert("用户名或密码不能为空");
				return false;
			}
			document.loginForm.submit();
		}
	</script>
	<!--[if IE 6]>
	<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
	<script>DD_belatedPNG.fix('.png')</script>
	<![endif]-->
</body>
</html>