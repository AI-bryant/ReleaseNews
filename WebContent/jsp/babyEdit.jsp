<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>家庭记录</title>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css">
    	.table th, .table td { 
		text-align: center;
		vertical-align: middle!important;
		}
		
		.startTime{
			color:#000000;
		}
		
		.endTime{
			color:#000000;
		}
		
	</style>
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
        <h1>添加BABY信息</h1>
    </div>
    <div id="breadcrumb">
        <a href="MVIndexCountServlet" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
        <a href="#" class="current">Baby Info Edit</a>
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
                            <form action="MVBabyInfoEditServlet" method="post" class="form-horizontal" />
                            <div class="input-group">
                            	<label class="control-label">选择日期</label> 
                            	<div class="controls date" id="datepicker">
							        <input type="text" style="height:30px;" class="form-control" name="date">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
                            <div class="control-group">
                                <label class="control-label">排泄</label>
                                <div class="controls">
                                    <select style="width:80px;" name="excretion">
										<option value="101">0</option>
										<option value="102">1</option>
										<option value="103">2</option>
										<option value="104">3</option>
										<option value="105">4</option>
										<option value="106">5</option>
										<option value="107">6</option>
										<option value="108">7</option>
									</select>
                                </div>
                            </div>
                            
                            <div class="control-group">
                                <label class="control-label">食量</label>
                                <div class="controls">
                                    <input style="height:30px;" type="text" name="eat" />
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">睡眠时间:</label>
                            </div>
							<div class="input-group">
                            	<label class="control-label">开始时间1</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间1
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
                            <div class="input-group">
                            	<label class="control-label">开始时间2</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间2
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
						    <div class="input-group">
                            	<label class="control-label">开始时间3</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间3
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
						    <div class="input-group">
                            	<label class="control-label">开始时间4</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间4
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
						    <div class="input-group">
                            	<label class="control-label">开始时间5</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间5
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
						    <div class="input-group">
                            	<label class="control-label">开始时间6</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间6
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
						    <div class="input-group">
                            	<label class="control-label">开始时间7</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间7
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
						    <div class="input-group">
                            	<label class="control-label">开始时间8</label> 
                            	<div class="controls date startTime" >
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
							        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间8
							        <input type="text" size="16" style="height:30px;width:200px;" class="form-control">
							        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						        </div>
						    </div>
                            <div class="control-group">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <input style="height:30px;" type="button" class="btn btn-primary" onclick="javascript:go()" value="计算"></input>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">总和</label>
                                <div class="controls">
                                    <input style="height:30px;" type="text" name="sleep" id="timeCount"/>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">保存</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        <div class="row-fluid">
            <div id="footer" class="span12">
                2016 &copy; AXF management brings you by <a href="#">AXF.FAMILY</a>
            </div>
        </div>
    </div>
</div>

<script src="script/js/jquery.min.js"></script>
<script src="script/js/jquery.ui.custom.js"></script>
<script src="script/js/jquery.dataTables.min.js"></script>
<script src="script/js/bootstrap.min.js"></script>
<script src="script/js/jquery.uniform.js"></script>
<script src="script/js/select2.min.js"></script>
<script src="script/js/unicorn.js"></script>
<script src="script/js/unicorn.tables.js"></script>
<link rel="stylesheet" href="script/time/css/bootstrap-datetimepicker.min.css">
<script src="script/time/js/bootstrap-datetimepicker.js"></script>
<script src="script/time/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
var timeArray=[];
var startTime =[];
var endTime =[];
var timeVal = $('.startTime').find(':text');//$('.timeList input');
var timeCountDiv=document.getElementById("timeCount"); 
function go(){
	for (var i = 0; i < timeVal.length; i++) {
		if(timeVal.eq(i).val()==""){
			timeVal.eq(i).val()=="00:00";
		}
		timeArray.push(timeVal.eq(i).val());  //将文本框的值添加到数组中
    }
	for(var j = 0; j < timeArray.length;j++){
		if(j%2!=0){
			startTime = timeArray[j]; 	 //奇数
		}else{
			endTime = timeArray[j];		//偶数
		}
		//timeCountDiv.value = timeCount(startTime,endTime);
	}
	alert(timeArray[0]);
}

function timeCount(startTime,endTime){
	alert(startTime+"--------------------"+endTime);
	var timeCount;
	var hour =endTime.substring(0,2)-startTime.substring(0,2);
	var minute = endTime.slice(3)-startTime.slice(3);
	//同一小时内
	if(hour=0){					
		return timeCount=hour+":"+minute;
	}else if(hour>0&&minute>0)
	{		//超过1小时
		minute=minute-60;
		if(minute>=60){
			hour=hour+1;
		}
		return timeCount=endTime.substring(0,2)+":"+minute;
	}else{	 //低于1小时
		minute=60-startTime.substring(0,2)+endTime.substring(0,2)
	}
}

    $('#datepicker .form-control').datetimepicker({
        "autoclose":true,"format":"yyyy-mm-dd","language":"zh-CN"
    });
    $(".startTime .form-control").datetimepicker({
    	"autoclose":true,"format":"hh:ii","language":"zh-CN","startView":"hour"
    });
</script>
</body>
</html>
