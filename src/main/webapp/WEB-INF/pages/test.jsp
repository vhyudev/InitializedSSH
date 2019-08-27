<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
	<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
	<script >
		var userName = {"userName":"fff"};
		function downLoad(){
			window.location.href="${pageContext.request.contextPath }/downLoad";
		}
	</script>
		
  </head>
  	
  <body>
    This is my JSP page. <br>
  ${userInfo.username }
  <button type="button" class="layui-btn" id="test11">
  		<i class="layui-icon">&#xe67c;</i>上传图片
	</button>
	<script>
		layui.use('upload', function(){
		  var upload = layui.upload;
		   
		  //执行实例
		  var uploadInst = upload.render({
		    elem: '#test11' //绑定元素
		    ,url: 'upload' //上传接口
		    ,accept: 'file' 
		    ,done: function(res){	
		      //上传完毕回调
		      if(res.status=="0"){
		    	  alert('CHENGGONG');
		      }else{
		    	  alert('shibaile');
		      }
		      
		    }
		    ,error: function(res){
		      alert(res);
		      alert("ccc");
		    }
		  });
		});
		
		
	</script>
	<button value=‘11’ onClick="downLoad()" id="download">下载</button>
    <center>
    	<h2 style="color: #ff261a;">this is my test page!</h2>
	</center>
	
	
	 <shiro:hasPermission name="读权限读读读">
		读取内容
	</shiro:hasPermission> 
	
	
	<shiro:hasPermission name="写权限写写写">
		写入内容
	</shiro:hasPermission>
	<script type="text/javascript">
	$(function(){
		$.post("${pageContext.request.contextPath }/login", { "username": "admin1" ,"password":"123"},
				   function(data){
				     alert(data); // John
				    
				   }, "text");
	})
	
	</script>
  </body>
</html>
