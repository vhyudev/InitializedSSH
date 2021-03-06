<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <title>众创数字资产综合运营管理平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui2/layui/css/layui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/admin.css"/>
</head>
<body>
	    <table class="layui-table layui-table-add" lay-skin="nob">
		  <tbody>
		    <tr>
		      <th class="pad" width="150">会员ID</th>
		      <td>100001</td>
		    </tr>
		    <tr>
		      <th class="pad">会员姓名</th>
		      <td>张三</td>
		    </tr>
		    <tr>
		      <th class="pad">手机号码</th>
		      <td>13800138000</td>
		    </tr>
		    <tr>
		      <th class="pad">绑定AGR</th>
		      <td>已绑定</td>
		    </tr>
		    <tr>
		      <th class="pad">AGR账户ID</th>
		      <td>AGR00001</td>
		    </tr>


		    <tr>
		      <th class="pad">AGR用户名</th>
		      <td>Harry</td>
		    </tr>
		    <tr>
		      <th class="pad">AGR等级</th>
		      <td>V1</td>
		    </tr>
		    <tr>
		      <th class="pad">账户余额</th>
		      <td><span class="price">10000.00</span></td>
		    </tr>
		    <tr>
		      <th class="pad">账户AGR</th>
		      <td>100000</td>
		    </tr>
		    <tr>
		      <th class="pad">累计提现</th>
		      <td><span class="price">10000.00</span></td>
		    </tr>
		    <tr>
		      <th class="pad">购物权限</th>
		      <td>正常</td>
		    </tr>
		    <tr>
		      <th class="pad">用户状态</th>
		      <td>正常</td>
		    </tr>
		    <tr>
		      <th class="pad">注册时间</th>
		      <td>2017-04-11 17:32:21</td>
		    </tr>

		  </tbody>
		</table>


	<script type="text/javascript" src="${pageContext.request.contextPath }/layui2/layui/layui.js"></script>
	<script>
		layui.use(['jquery','form','upload','layer'], function(){
			var $ = layui.jquery,layer = layui.layer;
		});
	</script>
</body>
</html>