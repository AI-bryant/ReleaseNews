<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="script/css/index.css"/>
    <link rel="stylesheet" href="script/css/login.css"/>
    <script src="script/js/jquery-2.1.4.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<title>登录注册页</title>
</head>
<body>
 <header>
        <section class="top-header" >
            <div class="container">
                <div class="row">
                    <!-- lg > md > xs >ms -->
                    <div class="col-xs-12 col-sm-12 col-md-7 col-lg-7">
                        <div class="content"></div>
                    </div>
                    <div class="col-xs-12 col-sm-8 col-md-5 col-lg-5">
                        <div  class="content">
                        <c:choose>
							<c:when test="${sessionScope.user.nickName != null}">
							 	<span style="color:#525050;"><b>用户：${sessionScope.user.nickName}</b></span>
							 	<span style="color:#525050;"><b><a href="#">，&nbsp;退出</a></b></span>
					        </c:when>
					        <c:when test="${sessionScope.user.userName != null}">
							    <p style="color:#525050;"><b>用户账号：${sessionScope.user.userName}</b></p>
						    </c:when>
						    <c:otherwise>
						           <a href="reglog.jsp">Login</a>&nbsp;&nbsp; &nbsp; &nbsp; <a href="reglog.jsp">Register</a>
						    </c:otherwise>
						</c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="main-header text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2">
                        <a href="VColServlet">
                            <img style="padding-top: 15px;width: 45%" src="images/newsLogo.png"/>
                        </a>
                    </div>
                    <div class="col-lg-5  col-lg-offset-5">
                        <ul id="list" class="list-header list-inline text-center">
                            <li onmouseover="changeBorder(0)" onmouseout="backBorder(0)"><a href="VColServlet">AXF.</a></li>
                            <li onmouseover="changeBorder(1)" onmouseout="backBorder(1)"><a href="reglog.jsp">LOGIN</a></li>
                            <li onmouseover="changeBorder(2)" onmouseout="backBorder(2)"><a href="about.jsp">ABOUT</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
    </header>

    <!-- form/login -->
    <div class="header-form text-center">
        <div class="container">
            <div class="row">
                <div class="sign-in col-lg-6">
                    <h1>SIGN IN</h1>
                    <form id="logSubmit" action="LogServlet" method="post">
                        <input class="input-text text-center" type="text" name="userName" placeholder="USERNAME"/><br>
                        <input class="input-text text-center" type="password" name="userPass" placeholder="PASSWORD"/><br><br>
                        <input class="input-button text-center" value="SIGN IN" type="submit"/><br><br><br>
                        <a href="index.html">forgot password?</a>
                    </form>
                </div>
                <div class="join-now col-lg-6">
                    <h1>JOIN NOW</h1>
                    <form id="regSubmit" onsubmit="return regFilter()" action="RegServlet" method="post">
                        <input class="input-text text-center" type="text" name="userName" placeholder="YOUR USERNAME"/><br>
                        <input class="input-text text-center" type="password" name="userPass" placeholder="YOUR PASSWORD"/><br>
                        <input class="input-text text-center" type="text" name="nickName" placeholder="YOUR NICKNAME"/><br><br>
                        <input class="input-button01 text-center" value="JOIN NOW" type="submit" title="Popover title"/><br><br><br>
                        <p style="color: #A9A9A9;">By clicking "Join Now," you are agreeing to the <span style="color: #6998F9;">Terms & Conditions</span> and the AXF.<br>
                            AXF-NEWS will also send you emails with news and updates.<br>
                            You can opt out in profile settings.</p>
                    </form>
                </div>
            </div>
            <div class="container login-about-us" onclick="javascript:window.location.href='about.jsp'">
                ABOUT US
            </div>
        </div>
    </div>
    
	<!-- <div id="myAlert" class="alert alert-warning">
	    <a href="#" class="close" data-dismiss="alert">
	        &times;
	    </a>
	    <strong>警告！</strong>您的网络连接有问题。
	</div> -->
    


    <!-- åºé¨è¿æ¥ -->
    <footer style="background-color: #272727;margin-top: 50px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 foot-link">
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a>
                </div>
                <div class="col-lg-3 foot-link">
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a>
                </div>
                <div class="col-lg-3 foot-link">
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a><br>
                    <a href="http://www.baidu.com">baidu</a>
                </div>
                <div class="col-lg-3 foot-link copyright">
                    <h4>COPYRIGHT AXF NEWS 2016</h4>
                </div>
            </div>
        </div>
    </footer>
    
    <script src="script/js/basic.js"></script>
    <script>
    var regSubmit = document.getElementById("regSubmit");
    /* var myAlert = document.getElementById("myAlert"); */
    regSubmit.userName.value;
    function regFilter(){
    	if(regSubmit.userName.value==""){
    		/* myAlert.alert(); */
    		alert("请输入用户名");
    		return false;
    	}else if(regSubmit.userPass.value==""){
    		alert("请输入密码");
    		return false;
    	}else if(regSubmit.nickName.value==""){
    		alert("请输入昵称");
    		return false;
    	}else{
    		alert("注册成功！请稍后");
    		return true;
    	}
    }
    </script>
</body>
</html>