<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>新闻发布</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="script/css/bootstrap.min.css" />
    <link rel="stylesheet" href="script/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="script/css/uniform.css" />
    <link rel="stylesheet" href="script/css/select2.css" />
    <link rel="stylesheet" href="script/css/unicorn.main.css" />
    <link rel="stylesheet" href="script/css/colorpicker.css" />
    <link rel="stylesheet" href="script/css/datepicker.css" />
    <link rel="stylesheet" href="script/css/select2.css" />
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
        <h1>添加新闻</h1>
    </div>
    <div id="breadcrumb">
        <a href="MVIndexCountServlet" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
        <a href="#" class="current">News edit</a>
    </div>
    <div class="container-fluid">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="widget-box">
                        <div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>
								</span>
                            <h5>Text inputs</h5>
                        </div>
                        <div class="widget-content nopadding">
                            <form action="MVNewsEditServlet" method="post" class="form-horizontal" />
                            <div class="control-group">
                                <label class="control-label">新闻标题</label>
                                <div class="controls">
                                    <input style="height:30px;" type="text" name="newsTitle" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">栏目</label>
                                <div class="controls">
                                    <select style="width:80px;" name="columnId">
										<option value="101">数码</option>
										<option value="102">娱乐</option>
										<option value="103">军事</option>
										<option value="104">体育</option>
										<option value="105">经济</option>
										<option value="106">游戏</option>
										<option value="107">社会</option>
										<option value="108">国际</option>
									</select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">作者</label>
                                <div class="controls">
                                    <input style="height:30px;" type="text" name="author" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">新闻内容</label>
                                <div class="controls">
                                    <textarea style="height:200px;" name="newsContent"></textarea>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                            </form>
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
