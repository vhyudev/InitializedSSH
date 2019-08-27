<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>layout 后台大布局 - Layui</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<link rel="stylesheet" href="localhost:8080/BeginnerAdmin/css/begtable.css" />
</head>
<body class="layui-layout-body"> <script type="text/javascript">
		//设置body高度为浏览器高度，当然也可以不设置   
		document.getElementsByTagName('body')[0].style.height = window.innerHeight + 'px';
	</script>
	<div class="layui-layout layui-layout-admin" >
		<div class="layui-header">
			<div class="layui-logo">国本善美后台管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="#"
					class="systemManager" data-type="tabAdd" name="${pageContext.request.contextPath }/guid" id="111">首页</a></li>
				<li class="layui-nav-item"><a class="systemManager" name="${pageContext.request.contextPath }/systemManager" href="#"
					onclick="systemManager()" >系统管理</a></li>
				<li class="layui-nav-item"><a class="systemManager" name="${pageContext.request.contextPath }/goodlist" id="goodsmanager" href="javascript:void(0);">商品管理</a></li>
				<li class="layui-nav-item"><a class="systemManager" name="${pageContext.request.contextPath }/associatorlist" id="associatormanager" href="javascript:void(0);">会员管理</a>
				<li class="layui-nav-item"><a class="systemManager" name="${pageContext.request.contextPath }/hospitalList" id="hospital" href="javascript:void(0);">医院管理</a>
					<!-- <dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl> --></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img">
						${userInfo.username}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">菜单</a>
						<dl class="layui-nav-child" id="menulist">
		 
		  <!--
            <dd><a href="#" class="layui-nav-item site-demo-active" data-type="tabAdd" id="22" onclick="aaa1(this)">内容2</a></dd>
            <dd><a href="#" class="layui-nav-item site-demo-active" data-type="tabAdd" id="33" onclick="aaa1(this)">内容3</a></dd>
            <dd><a href="#" class="layui-nav-item site-demo-active" data-type="tabAdd" id="44" onclick="aaa1(this)">内容4</a></dd> -->

						</dl></li>
					<!-- <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="test.jsp" target="main-area">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li> -->
					<li class="layui-nav-item"><a href="#">基础设置</a></li>
					<li class="layui-nav-item"><a href="http://www.baidu.com">统计报表</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body" name="main-area">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<div class="layui-tab">
					<div class="layui-tab" lay-filter="demo" lay-allowclose="true">
						<ul class="layui-tab-title">

							<!--
    <li lay-id="22">用户管理</li>
    <li lay-id="33">权限分配</li>
    <li lay-id="44">商品管理</li>
    <li lay-id="55">订单管理</li> -->
						</ul>
						<div class="layui-tab-content">

							<!--
    <div class="layui-tab-item">内容2</div>
    <div class="layui-tab-item">内容3</div>
    <div class="layui-tab-item">内容4</div>
    <div class="layui-tab-item">内容5</div> -->
						</div>
					</div>
				</div>
			</div>

			<div class="layui-footer">
				<!-- 底部固定区域 -->
				© layui.com - 底部固定区域
			</div>
		</div>
	</div>
		<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
		<script>
		var titles;
		var ids;
		var flag = 0;
		var src;
		//JavaScript代码区域
		var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

		//Hash地址的定位
		var layid = location.hash.replace(/^#test=/, '');
		element.tabChange('test', layid);

		element.on('tab(test)', function(elem) {
			location.hash = 'test=' + $(this).attr('lay-id');
		});
			
		
			/* 个人工作平台------------------------- */
			$(".systemManager").click( function () { 
							titles = this.innerHTML
							ids = this.id
							src=this.name
							var lis = $(".layui-tab-title > li");
								
							if (lis.size() == 0) {
								//新增一个Tab项
								element.tabAdd('demo',{
													title : titles,
													content : '<iframe runat="server" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes" onload="this.height=body.offsetHeight-100" width="100%"   src="'+src+'"></iframe>',
													id : ids
												//实际使用一般是规定好的id，这里以时间戳模拟下 
													})

								element.tabChange('demo', ids); //切换到：用户管理
							} else {

								flag = 0;
								lis.each(function() {
									var nowid = $(this).attr("lay-id");
									if (nowid == ids) {
										element.tabChange('demo', ids); //切换到：用户管理 
										flag = 1;
									}
								});

								if (flag == 0) {
									//新增一个Tab项
									element.tabAdd('demo',{
														title : titles,
														content : '<iframe runat="server" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes" onload="this.height=body.offsetHeight-100" width="100%"   src="'+src+'"></iframe>',
														id : ids
													//实际使用一般是规定好的id，这里以时间戳模拟下 
														})
									element.tabChange('demo', ids); //切换到：用户管理
								}
							}
						});
			/* 个人工作平台------------------------ */

	
			function systemManager() {
				$("#menulist").html("");
				var id = "${userInfo.id}"
				//发送ajax请求,获取当前用户下的菜单,动态拼接html中.
				$.post("${pageContext.request.contextPath }/findMenus", {"id" : id}, function(data) {
					$(data).each(function(i,n) {
						i=i+100;
						$("#menulist").append('<dd><a href="#" name="'+n.page+'" id="'+i+'">'+n.name+'</a></dd>');
						$("#"+i).click( function () { 
							titles = this.innerHTML
							ids = this.id
							src = this.name
							var lis = $(".layui-tab-title > li");
								
							if (lis.size() == 0) {
								//新增一个Tab项
								element.tabAdd('demo',{
													title : titles,
													content : '<iframe runat="server" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes" onload="this.height=body.offsetHeight-100" width="100%"   src="${pageContext.request.contextPath }/'+src+'"></iframe>',
													id : ids
												//实际使用一般是规定好的id，这里以时间戳模拟下 
													})

								element.tabChange('demo', ids); //切换到：用户管理
							} else {

								flag = 0;
								lis.each(function() {
									var nowid = $(this).attr("lay-id");
									if (nowid == ids) {
										element.tabChange('demo', ids); //切换到：用户管理 
										flag = 1;
									}
								});

								if (flag == 0) {
									//新增一个Tab项
									element.tabAdd('demo',{
														title : titles,
														content : '<iframe onload="this.height=body.offsetHeight-100" width="100%" scrolling="auto"  src="${pageContext.request.contextPath }/'+src+'"></iframe>',
														id : ids
													//实际使用一般是规定好的id，这里以时间戳模拟下 
														})
									element.tabChange('demo', ids); //切换到：用户管理
								}
							}
						});
					});
				}, "json");
				
				

				
			}
			//显示个人工作平台
			$(function() {
				var ss = 111;
				element = layui.element;

				element.tabAdd('demo',{
									title : '首页',
									content : '<iframe onload="this.height=body.offsetHeight-100" width="100%" scrolling="auto"  src="${pageContext.request.contextPath }/guid"></iframe>',
									id : ss
								//实际使用一般是规定好的id，这里以时间戳模拟下 
									})

				element.tabChange('demo', ss); //切换到：用户管理
			})

			
		</script>
</body>
</html>