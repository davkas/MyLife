<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>这就是我的人生</title>
</head>
<body>
	<div class="login">
	    <div class="box png">
			<div class="logo png"></div>
			<div class="input">
				<div class="log">
				<form id="loginForm" name="loginForm" method="post"
				action="loginCheck">
					<div class="name">
						<label>用户名</label><input type="text" class="text" id="username" placeholder="用户名" name="username" tabindex="1">
					</div>
					<div class="pwd">
						<label>密　码</label><input type="password" class="text" id="password" placeholder="密码" name="password" tabindex="2">
						<input type="button" class="submit" tabindex="3" value="登录" onclick="checkUserForm();">
						<div class="check"></div>
					</div>
					<div class="tip"></div>
					</form>
				</div>
			</div>
		</div>
	    <div class="air-balloon ab-1 png"></div>
		<div class="air-balloon ab-2 png"></div>
	    <div class="footer"></div>
	</div>

	<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/fun.base.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript">
	if ("${error}" != "") {
		alert("${error}");
	};
	function checkUserForm() {
		var userName = $("#username").val();
		var userPassword = $("#password").val();
		if (userName == "" || userPassword == "") {
			alert("用户名或密码不能为空");
			return false;
		}
		var b;
		$.ajax({
					type : "POST",
					url : "loginCheck.html?data="
							+ new Date(),
					data : {
						username : userName,
						password : userPassword
					},
					dataType: "json",
					async : false,
					success : function(data) {
						if (data.error == "0") {
							b = false;
						} else {
							b = true;
							alert(data.error);
						}
					}
				});
		if (b) {
			return true;
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