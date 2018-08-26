<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新闻发布网站</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="script/css/index.css"/>
    <link rel="stylesheet" href="script/imgsChange/nivo-slider.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="script/imgsChange/style.css" type="text/css" media="screen" />
    <script src="script/js/jquery-2.1.4.min.js"></script>
    <script src="script/imgsChange/jquery-1.4.3.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="script/js/index.js"></script>
</head>
<body>
    <!-- 头部登入，注册 -->
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

        <img src="images/family.jpg" style="position:absolute;left:0px;top:150px;width: 100%;height: 350px;"/>

        <div class="img-header text-center" style="color:#e10065;">
            <div class="container">
                <div class="row">
                    <div class="img-header-info col-lg-12">
                        <div class="row">
                            <div class="img-title01 col-lg-6 col-lg-offset-6">
                                <h1><b>Record every <br>moment of our life</b></h1><br>
                                <h2>BY AI-FAMILY</h2>
                            </div>
                        </div>
                        <div class="row">
                            <div class="img-title05 col-lg-12">
                                <a href="reglog.jsp"><div class="col-lg-3 col-lg-offset-3 img-button" style="opacity:0.8;">
                                    SIGN IN
                                </div></a>
                                <a href="#news-categories"><div class="col-lg-5 col-lg-offset-1 img-button" style="opacity:0.8;">
                                    NEWS LIST
                                </div></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </header>

    <!-- å½æ¥ééæ°é» -->
    <div class="headline-News  text-center">
        <div class="container">
            <div class="row">
                <div class="headline-News-title col-lg-12">
                    <h1>最新新闻</h1>
                </div>
            </div>
            <div class="row">
                <div id="slider-wrapper">

                    <div id="slider" class="nivoSlider">
                    	<c:forEach var="news" items="${requestScope.newsList}"  begin="0" end="3" varStatus="status">
							<a href="VNewServlet?newsId=${news.newsId}"><img src="images/${status.index}.jpg" alt="" title="${news.newsTitle}"/></a>
                    	</c:forEach>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <!-- æ°é»ç±»å« -->
    <div id="news-categories" class="news-categories" style="margin-top: 50px;">
        <div class="container">
            <div class="row">
            	<c:forEach var="column" items="${requestScope.columnList}">
            		<div class="col-lg-3">
	                    <div class="thumbnail" style="height: 334px;text-align: center;">
	                        <a  href="VTheServlet?columnId=${column.columnId}">
	                            <img class="small-imgs" src="${column.columnPicPath}" style="background-color: #CF4646;"/>
	                        </a>
	                        <div class="caption">
	                            <h3>
	                                <a href="VTheServlet?columnId=${column.columnId}" title="${column.columnTitle}">
	                                    ${column.columnTitle}<br>
	                                </a>
	                                <br>
	                            </h3>
	                                <p>${column.columnDescribe}</p>
	                        </div>
	                    </div>
	                </div>
				</c:forEach>
            </div>
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
    <script src="script/imgsChange/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript">
        $(window).load(function() {
            $('#slider').nivoSlider();
        });
    </script>
</body>
</html>