<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>国本善美</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/BeginnerAdmin/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/BeginnerAdmin/css/login.css" />
	</head>

	<body class="beg-login-bg" style="background-image: url(BeginnerAdmin/images/ntk29215.jpg);">
		<div class="beg-login-box">
			<header>
				<h1>国本善美后台管理系统</h1>
			</header>
			<div class="beg-login-main">
				<form action="/login" class="layui-form" method="post"><input name="__RequestVerificationToken" type="hidden" value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9.Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input id="111" type="text" name="username" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input id="222" type="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
					</div>
					<div class="layui-form-item">
						<div class="beg-pull-left beg-login-remember">
							<label>记住账号</label>
							<input type="checkbox" name="rememberMe" value="true" lay-skin="switch" checked title="记住帐号">
						</div>
						<div class="beg-pull-right">
							<button class="layui-btn layui-btn-sm" lay-submit lay-filter="login">
                            <i class="layui-icon"></i> 登录
                        </button>
                        <button class="layui-btn layui-btn-sm" lay-submit lay-filter="register">
                            <i class="layui-icon"></i> 注册
                        </button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
			<footer>
				<p>Beginner © www.goubenshanmei.cn</p>
			</footer>
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath }/BeginnerAdmin/plugins/layui/layui.js"></script>
		<script>
			layui.use(['layer', 'form'], function() {
				var layer = layui.layer,
					$ = layui.jquery,
					form = layui.form();
				
				
				form.on('submit(register)',function(data){
					location.href='toRegist';
					return false;
				});
			}); 
		</script>
	</body>

</html>