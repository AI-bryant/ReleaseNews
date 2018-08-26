<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新闻列表</title>
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
        <img src="images/naslovna_slika_1.jpg" style="position:absolute;left:0px;top:150px;width: 100%;height: 150px;"/>
    </header>

    /* news-list */
    <div class="news-list">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="news-search text-left">
                        <label class="search-title">Search By KeyWord</label>
                        <from>
                            <input class="input-text01" type="text" />
                            <br><br>
                            <label class="search-title">Duration</label>
                            <div class="list-checkboxes">
                                <div>
                                    <input type="checkbox" name="" value=""/>&nbsp;&nbsp;&nbsp;
                                    <label class="">1 WEEK</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="" value=""/>&nbsp;&nbsp;&nbsp;
                                    <label class="">2 WEEKS+</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="" value=""/>&nbsp;&nbsp;&nbsp;
                                    <label class="">DAYTRIP</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="" value=""/>&nbsp;&nbsp;&nbsp;
                                    <label class="">WEEKEND</label>
                                </div>
                            </div>
                            <label class="search-title">Category</label>
                            <div class="row category-position">
				                <c:forEach var="column" items="${requestScope.columnList}">
				                 	<span><a href="VTheServlet?columnId=${column.columnId}"><b>${column.columnTitle}</b></a></span>
								</c:forEach>
                            </div>
                            <input style="width: 250px;height: 50px;margin-top: 150px;" class="input-button" type="submit" value="submit"/>
                        </from>
                    </div>
                </div>
                <div class="col-lg-9">
                    <h1>${requestScope.column.columnTitle}</h1>
                    <div class="main-list">
                        <ul>
                        	<c:forEach var="news" items="${requestScope.column.newsList}">
                        		 <a href="VNewServlet?newsId=${news.newsId}"><li>${news.newsTitle}</li></a>
							</c:forEach>
                        </ul>
                    </div>
                    <nav>
                        <ul class="pagination pagination-lg">
                            <li><a href="javascript:pageNum('left')">&laquo;</a></li>
							   	<c:forEach varStatus="newsPage" begin="1" end="${requestScope.newsPage}">
	 								<li><a href="javascript:pageNum(${newsPage.index})">${newsPage.index}</a></li>
	<%--  								<li><a href="VTheServlet?columnId=${column.columnId}&pageNum=${newsPage.index}" onclike="pageNum('${newsPage.index}')">${newsPage.index}</a></li> --%>
								</c:forEach>
                            <li><a href="javascript:pageNum('right')">&raquo;</a></li>
                        </ul>
                    </nav>
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
<script>
var columnId = ${requestScope.column.columnId};
var tempNum = ${requestScope.pageNum};
function pageNum(obj){
	var num = 1;
	if(obj == 'left'){
		num = tempNum-1;
	}else if(obj=='right'){
		num = tempNum+1
	}else{
		num = obj;
	}
	window.location.href="VTheServlet?columnId="+ columnId + "&pageNum=" + num; 
}
</script>
</html>