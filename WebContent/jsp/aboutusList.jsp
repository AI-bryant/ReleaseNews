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
			<a href="#"><i class="icon icon-th-list"></i> <span>Baby Info</span><span class="label">3</span></a>
			<ul>
                <li><a href="MVUserListServlet">Baby Info list</a></li>
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
        <a href="MVIndexCountServlet" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
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
                                <th>用户名</th>
                                <th>用户留言</th>
                                <th>留言时间</th>
                                <th>删除</th>
                            </tr>
                            </thead>
                            <tbody>
	                            <c:forEach var="aboutUs" items="${requestScope.aboutUsList}">
	                           		<tr class="gradeX">
										<td>${aboutUs.aboutusEmail }</td>
										<td>${aboutUs.aboutusContext }</td>
										<td>${aboutUs.createDate }</td>
		                            	<td class="center"><a href="MDeleteServlet?aboutUsId=${aboutUs.aboutusId }">删除</a></td>
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
