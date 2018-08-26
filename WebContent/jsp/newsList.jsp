<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>新闻列表</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="script/css/bootstrap.min.css" />
    <link rel="stylesheet" href="script/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="script/css/uniform.css" />
    <link rel="stylesheet" href="script/css/select2.css" />
    <link rel="stylesheet" href="script/css/unicorn.main.css" />
    <link rel="stylesheet" href="script/css/unicorn.grey.css" class="skin-color" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>


<div id="header">
    <h1><a href="#">AXF. NEWS</a></h1>
</div>

<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav btn-group">
        <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
        <li class="btn btn-inverse"><a title="" href="loginManager.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
    </ul>
</div>

<div id="sidebar">
    <ul>
        <li class="active"><a href="MVIndexCountServlet"><i class="icon icon-home"></i> <span>Big Data</span></a></li>
        <li class="submenu">
            <a href="#"><i class="icon icon-th-list"></i> <span>News operation</span> <span class="label">3</span></a>
            <ul>
                <li><a href="MVNewsListServlet">News list</a></li>
                <li><a href="newsEdit.jsp">Edit news</a></li>
                <li><a href="MVUnNewsListServlet">Unpublished</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="#"><i class="icon icon-file"></i> <span>User operation</span> <span class="label">4</span></a>
            <ul>
                <li><a href="MVUserListServlet">User list</a></li>
                <li><a href="MVRemarkListServlet">User comment</a></li>
                <li><a href="MVAboListServlet">User letter</a></li>
            </ul>
        </li>
        <li class="submenu">
			<a href="MVIndexCountServlet"><i class="icon icon-th-list"></i> <span>Baby Info</span><span class="label">3</span></a>
			<ul>
                <li><a href="MVBabyInfoListServlet">Baby Info list</a></li>
                <li><a href="babyEdit.jsp">add Baby Info</a></li>
                <li><a href="MVBabyMedicalServlet">Medical Records</a></li>
            </ul>
		</li>
    </ul>
</div>

<div id="style-switcher">
    <i class="icon-arrow-left icon-white"></i>
    <span>Style:</span>
    <a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
    <a href="#blue" style="background-color: #2D2F57;"></a>
    <a href="#red" style="background-color: #673232;"></a>
</div>

<div id="content">
    <div id="content-header">
        <h1>新闻列表</h1>
    </div>
    <div id="breadcrumb">
        <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
        <a href="#" class="current">News list</a>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title">
                        <h5>News table</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>新闻编号</th>
                                <th>新闻类别</th>
                                <th>新闻标题</th>
                                <th>新闻日期</th>
                                <th>新闻状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
	                            <c:forEach var="news" items="${requestScope.newsList}">
	                           		<tr class="gradeX">
		                                <td>${news.newsId }</td>
		                                <c:forEach var="column" items="${requestScope.columnList}">
			                                <c:choose>
										   		<c:when test="${column.columnId == news.columnId}">
													 <td>${column.columnTitle }</td>
										   		</c:when>
											</c:choose>
		                                </c:forEach>
			                            <td>${news.newsTitle }</td>
			                            <td class="center">${news.createDate }</td>
		                                 <c:choose>
	                                 		<c:when test="${news.newsStatus == 0}">
												 <td>未发布</td>
									   		</c:when>
										   	<c:otherwise>
												<td>已发布</td>
									   		</c:otherwise>
										</c:choose>
		                            	<td class="center"><a href="MDeleteServlet?newsId=${news.newsId }">删除</a></td>
	                           		</tr>
								</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <div class="row-fluid">
            <div id="footer" class="span12">
                2016 &copy; AXF management brings you by <a href="#">AXF.NEWS</a>
            </div>
        </div>
    </div>
</div>



<script src="script/js/jquery.min.js"></script>
<script src="script/js/jquery.ui.custom.js"></script>
<script src="script/js/bootstrap.min.js"></script>
<script src="script/js/jquery.uniform.js"></script>
<script src="script/js/select2.min.js"></script>
<script src="script/js/jquery.dataTables.min.js"></script>
<script src="script/js/unicorn.js"></script>
<script src="script/js/unicorn.tables.js"></script>
</body>
</html>
