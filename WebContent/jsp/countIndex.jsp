<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
	<head>
		<title>家庭记录</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="script/css/bootstrap.min.css" />
    <link rel="stylesheet" href="script/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="script/css/uniform.css" />
    <link rel="stylesheet" href="script/css/select2.css" />
    <link rel="stylesheet" href="script/css/unicorn.main.css" />
    <link rel="stylesheet" href="script/css/unicorn.grey.css" class="skin-color" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>
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
				<li class="active"><a href="MVIndexCountServlet?month=-06-"><i class="icon icon-home"></i> <span>Big Data</span></a></li>
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
		                <li><a href="MVBabyInfoListServlet">Baby Info list</a></li>
		                <li><a href="babyEdit.jsp">add Baby Info</a></li>
		                <li><a href="MVBabyMedicalServlet">Medical Records</a></li>
		            </ul>
				</li>
			</ul>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>Dashboard</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">Dashboard</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12 center" style="text-align: center;">					
						<ul class="stat-boxes">
							<li>
								<div class="left peity_bar_good"><span>1.家庭活动次数</span>+20%</div>
								<div class="right">
									<strong>1</strong>
									Num
								</div>
							</li>
							<li>
								<div class="left peity_bar_neutral"><span>2.家庭成员数量</span>0%</div>
								<div class="right">
									<strong>${requestScope.countUser}</strong>
									Users
								</div>
							</li>
							<li>
								<div class="left peity_bar_bad"><span>3.Baby平均进食量</span>-50%</div>
								<div class="right">
									<strong>${requestScope.averageFeed }</strong>
									ML
								</div>
							</li>
							<li>
								<div class="left peity_line_good"><span>4.Baby平均睡眠时间</span>+70%</div>
								<div class="right">
									<strong>${requestScope.countRemark }</strong>
									Remark
								</div>
							</li>
						</ul>
					</div>	
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="alert alert-info">
							Welcome to <strong>AXF family recode management system,</strong> the following data may click to view details！
							<a href="#" data-dismiss="alert" class="close">AXF</a>
						</div>
						<div class="widget-box">
							<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>Site Statistics</h5><div class="buttons"><a href="#" class="btn btn-mini"><i class="icon-refresh"></i> Update stats</a></div></div>
							<div class="widget-content">
								<div class="row-fluid">
								<div class="span4">
									<ul class="site-stats">
										<a href="MVUserListServlet"><li style="width:1170px;"><i class="icon-user"></i> <strong>${requestScope.countUser }</strong> <small>总用户数</small></li></a>
										<li class="divider"></li>
										<a href="MVNewsListServlet"><li style="width:1170px;"><i class="icon-arrow-right"></i> <strong>8</strong> <small>大类新闻</small></li></a>
										<a href="MVNewsListServlet"><li style="width:1170px;"><i class="icon-shopping-cart"></i> <strong>${requestScope.countNews }</strong> <small>总新闻条数</small></li></a>
										<a href="MVRemarkListServlet"><li style="width:1170px;"><i class="icon-tag"></i> <strong>${requestScope.countRemark }</strong> <small>总评论次数</small></li></a>
										<li class="divider"></li>
										<a href="MVAboListServlet"><li style="width:1170px;"><i class="icon-repeat"></i> <strong>${requestScope.countAboutUs }</strong> <small>总意见留言</small></li></a>
									</ul>
								</div>
								<div class="span8">
									<div class="chart"></div>
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

            <script src="script/js/excanvas.min.js"></script>
            <script src="script/js/jquery.min.js"></script>
            <script src="script/js/jquery.ui.custom.js"></script>
            <script src="bootstrap/js/bootstrap.min.js"></script>
            <script src="script/js/jquery.flot.min.js"></script>
            <script src="script/js/jquery.flot.resize.min.js"></script>
            <script src="script/js/jquery.peity.min.js"></script>
            <script src="script/js/fullcalendar.min.js"></script>
            <script src="script/js/unicorn.js"></script>
            <script src="script/js/unicorn.dashboard.js"></script>
	</body>
</html>
