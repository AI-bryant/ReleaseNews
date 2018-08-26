<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>新闻发布</title>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="script/css/login.css" />
	</head>
	<body style="background: url('images/wallhaven-154455.jpg')">
		<header id="header">
			AXF.新闻发布网站
		</header>
		<div class="login-con" style="background: url('images/A_logo.jpg')">
			<div class="login-right-con">
				<div class="con">
					<form id="form_id" action="MLogServlet" name="loginForm" method='post'>
						<!--<img src="resources/images/loginTitle.png" alt="" />-->
						<div>
							<label class="label">
								<i class="icon-user"></i>&nbsp;&nbsp;用户：
							</label>
							<input type="text" name="userName" required="true" value="" placeholder="Username or email"/>
						</div>
						<div>
							<label class="label">
								<i class="icon-lock"></i>&nbsp;&nbsp;密码：
							</label>
							<input type="password" name="userPass" required="true" value="" placeholder="Password"/>
						</div>
						<div class="pdding-l-60">
							<input type="submit" value="登录"/>
							<!-- <a href="#" class="resetBtn">重置</a> -->
						</div>
						<div class="errorExplanation" id="notice_div"
							style="display: none; margin-top: 4px;color:red;font-weight:bold;">
						</div>
						<p class="pdding-l-60">版权所有&copy;AXF.NEWS</p>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
