<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新闻详情</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="script/css/index.css"/>
    <script src="script/js/jquery-2.1.4.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/js/index.js"></script>
</head>
<body>
 <!-- 头部登入，注册 -->
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
							 	<p style="color:#525050;"><b>用户：${sessionScope.user.nickName}</b></p>
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

    <!--news-detail -->
    <div class="news-detail">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-center">
                    <h1>${requestScope.news.newsTitle}</h1>
                </div>
            </div>
            <div class="row">
                <!--<div class="col-lg-1"></div>-->
                <div class="col-lg-8 text-left">
                    <br>
                    <img src="images/2.jpg" style="width: 100%;height: 100%;"/>
                    <p>${requestScope.news.newsContext}</p>
                    
                     <c:choose>
				        <c:when test="${sessionScope.user.userName != null}">
						    <form action="EditRemarkServlet" method="post">
		                    	<input type="hidden" name="newsId" value="${requestScope.news.newsId}">
		                        <div class="col-lg-12 text-title">
		                            FILL IN:
		                        </div>
		                        <div class="row">
		                            <div class="col-lg-12">
		                                <textarea class="form-big-text" name="remarkContext" placeholder="Message"></textarea>
		                            	<input class="form-submit" type="submit" value="Send message">
		                            </div>
		                        </div>
		                    </form>
					    </c:when>
					</c:choose>
                </div>
                <div class="col-lg-4">
                    <div class="message-board">
                        <h3 class="text-center">message-board</h3>
                        <c:forEach var="remark" items="${requestScope.news.remarkList}" begin="0" end="5">
					        <div style="margin-top: 20px;width: 100%;height: 100%;">
		                        <div class="message-user">
		                            <div><b>用户:${remark.user.nickName}</b><span style="float:right;">${remark.createDate}</span></div>
		                            <div>
		                                <p>
		                                  	 ${remark.remarkContext}
		                                </p>
		                            </div>
		                        </div>
	                        </div>
						</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 底部连接 -->
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
</body>
</html>