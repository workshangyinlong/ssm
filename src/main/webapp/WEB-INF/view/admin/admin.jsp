<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>后台首页</title>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
		<title>后台主页面</title>
		<style>
			@media ( min-width :768px ) {
				#left_tab {
					width: 250px;
					position: absolute;
					z-index: 1;
					height: 640px;
				}
				.mysearch {
					margin: 10px;
				}
				.page_main {
					margin-left: 255px;
				}
				.dv_content{
					width: 100%;
					height: 500px;
				}
			}
		</style>
	</head>
<body>

<!--导航 -->
<div style="width: 80%;margin-left: 10%;overflow: hidden;height: 80%;" >
	<nav class="navbar navbar-default navbar-static-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#left_tab,#top_right">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">网站后台管理</a>
		</div>
		<ul id="top_right" class="collapse navbar-collapse nav navbar-nav navbar-right"	style="margin-right: 20px;">
			<li>
				<a href="#">
					<span class="badge"	style="background-color: red;">23</span>
				</a>
			</li>
			<li>
				<a href="#">
					<span class="glyphicon glyphicon-off"></span>注销
				</a>
			</li>
		</ul>
		<!--左侧边栏 -->
		<div id="left_tab" style="margin-top: 70px;" class="collapse navbar-default navbar-collapse">
			<ul class="nav panel-group" id="myPanel">
				<!--栏目-->
				<li class="panel">
					<a href="#sub1" data-toggle="collapse" data-parent="#myPanel"> 用户管理
						<span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
					</a>
					<ul id="sub1" class="nav collapse panel-collapse">
						<li>
							<a href="javascript:void(0)" id="showUser">
								<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<b>普通用户管理</b>
							</a>
						</li>
					</ul>
				</li>
				<li class="panel">
					<a href="#sub4" data-toggle="collapse" data-parent="#myPanel"> 服务城市管理
						<span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
					</a>
					<ul id="sub4" class="nav panel-collapse collapse">
						<li>
							<a href="#" id="showCityAll">
								<span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看服务点
							</a>
						</li>
						<li>
							<a href="#" id="addCity">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;添加服务点
							</a>
						</li>
					</ul>
				</li>
				<li class="panel">
					<a href="#sub3" data-toggle="collapse" data-parent="#myPanel"> 车辆管理
						<span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
					</a>
					<ul id="sub3" class="nav panel-collapse collapse">
						<li>
							<a href="#" id="showcarsType">
								<span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看所有车型
							</a>
						</li>
						<li>
							<a href="#" id="addcarsType">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;添加车辆
							</a>
						</li>
					</ul>
				</li>
				<li class="panel">
					<a href="#sub2" data-toggle="collapse" data-parent="#myPanel"> 订单管理
						<span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
					</a>
					<ul id="sub2" class="nav panel-collapse collapse">
						<li>
							<a href="#" id="showOrder">
								<span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看订单
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<!--右侧部分-->
	<div class="page_main">
		<script type="text/javascript">
			$("#showUser").click(function(){
				$(".dv_content").attr("src","${pageContext.request.contextPath}/user/userAdmin");
			});
			$("#addCity").click(function(){
				$(".dv_content").attr("src","${pageContext.request.contextPath}/admincity/cityaddpage");
			});
			$("#showCityAll").click(function () {
				$(".dv_content").attr("src","${pageContext.request.contextPath}/admincity/citymanage")
			})
			$("#showcarsType").click(function () {
				$(".dv_content").attr("src","${pageContext.request.contextPath}/admincar/opencheckcar")
			})
			$("#showOrder").click(function(){
				$(".dv_content").attr("src","${pageContext.request.contextPath}/orderAdmin/orderAdmin");
			});
			$("#addcarsType").click(function(){
				$(".dv_content").attr("src","${pageContext.request.contextPath}/admincar/addcarpage");
			});
			//				$("#showGoods").click(function(){
			//					$(".dv_content").attr("src","${pageContext.request.contextPath}/getGoodsList");
			//				})
			//				$("#addGoods").click(function(){
			//					$(".dv_content").attr("src","addGoods.jsp");
			//				})
			//				$("#showOrder").click(function(){
			//					$(".dv_content").attr("src","${pageContext.request.contextPath}/getAllOrder");
			//				})
		</script>
		<iframe class="dv_content" frameborder="0" style="overflow:auto;overflow-x: hidden" >
		</iframe>
	</div>
</div>
</body>
</html>