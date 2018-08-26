<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>about us</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="script/css/index.css"/>
    <script src="script/js/jquery-2.1.4.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <!-- å¤´é¨ç»å¥ï¼æ³¨å -->
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

    <!-- ä¸»ä½é¨å -->
    <div class="about-us">
        <div class="container">
            <br>
            <div class="row">
                <div class="col-lg-12">
                    <img src="images/1.jpg"/>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-lg-12 text-color">
                    <p>Welcome to the axf news site,<br>
                        we will bring you the latest news, so you know the latest trends in the world, if you have new ideas you can always contact us !<br>
                    Each of your valuable suggestions will enhance your viewing experience, let us grow together...<br>
                        The following is the place to fill in the views, please complete your personal information, and comments, we will reply to you the first time, and finally thank you for your support ~
                    <br><br><br>
                    </p>
                </div>
            </div>
            <form id="regSubmit" onsubmit="return regFilter()" action="CAboServlet" method="post">
                <div class="col-lg-12 text-title">
                    FILL IN:
                </div>
                <div class="row">
                    <div class="col-lg-12">
                    	<input class="form-text" type="text" name="aboutUsEmail" placeholder="Your e-mail address"/>
                        <textarea class="form-big-text" name="aboutUsContext" placeholder="Message"></textarea>
                    	<input class="form-submit" type="submit" value="Send message">
                    </div>
                </div>
            </form>
        </div>
    </div>

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
    	if(regSubmit.aboutUsEmail.value==""){
    		/* myAlert.alert(); */
    		alert("请输入正确的邮箱地址");
    		return false;
    	}else if(regSubmit.aboutUsContext.value==""){
    		alert("请输入邮件内容");
    		return false;
    	}else{
    		alert("发送成功！请稍后");
    		return true;
    	}
    }
    </script>
</body>
</html>