<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>注册</title>
<script type="text/javascript" src="../../js/jquery-2.1.0.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/BeginnerAdmin/plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/BeginnerAdmin/css/regist.css" />
<script type="text/javascript">
			function checkUser(field){
				var userName = {"userName":field.value}
				if(field.value !="" ){
					$.ajax({
					    url:'userRepeat',
					    type:'POST', //GET
					   // contentType: "application/json;",
					    async:true,    //或false,是否异步
					    data:userName,//JSON.stringify(userName)
					    timeout:5000,    //超时时间
					    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
					    beforeSend:function(xhr){
					       
					    },
					    success:function(data,textStatus,jqXHR){
					    	if(data.status==0){//成功
					    		$("#errorMessage").html(data.message);
					    		$("#errorMessage").css("color","green");
					    	}else if(data.status==1){
					    		$("#errorMessage").html(data.message);
					    		field.value="";
					    		$("#errorMessage").css("color","red");
					    		
					    	}
					    	
					    },
					    error:function(xhr,textStatus){
					        console.log('错误')
					        console.log(xhr)
					        console.log(textStatus)
					    },
					    complete:function(){
					        console.log('结束')
					    }
					})
				}else{
					return;
				}
			}
		</script>
</head>

<body class="beg-login-bg" style="background-image: url(BeginnerAdmin/images/ntk29215.jpg);">
	<div class="beg-login-box">
		<header>
		<h1>注册</h1>
		</header>
		<div class="beg-login-main">
			<form action="regist2" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden" value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9.Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-inline">
						<input type="text" name="userName" required lay-verify="required"
							placeholder="请输入姓名" autocomplete="off" class="layui-input" onblur="checkUser(this)">
					</div>
					<div id="errorMessage" >
						
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-inline">
						<input type="text" name="idCardNo" required
							lay-verify="required" placeholder="请输入身份证号" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">辅助文字</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">手机号</label>
					<div class="layui-input-inline">
						<input type="text" name="mobile" required
							lay-verify="required" placeholder="请输入手机号" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="radio" name="sex" value="30" title="男"> <input
							type="radio" name="sex" value="33" title="女" checked>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">密码</label>
					<div class="layui-input-inline">
						<input type="password" name="password" required
							lay-verify="required" placeholder="请输入密码" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<button class="layui-btn" type="reset"
							class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			<script type="text/javascript" src="${pageContext.request.contextPath }/BeginnerAdmin/plugins/layui/layui.js"></script>
			<script>
				//Demo
				layui.use('form', function() {
					var form = layui.form;
					//监听提交
					form.on('submit(login)', function(data) {
						location.href = 'testmvc';
						return false;
					});
					form.on('submit(abolish)', function(data) {
						location.href = 'regist';
						return false;
					});
					form.on('submit(formDemo)', function(data) {
						location.href = 'regist2';
						return false;
					});
				});
			</script>

			<footer>
			<p>Beginner © www.goubenshanmei.cn</p>
</body>

</html>