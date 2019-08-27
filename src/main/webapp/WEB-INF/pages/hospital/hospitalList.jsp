<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container">
		<div class="content-search">
			<form id="IDform" class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/hospitalList">
				<div class="layui-inline">
					<label class="layui-form-label">医院名称</label>
					<div class="layui-input-block">
						<input name="name" autocomplete="off" placeholder="请输入医院名称" class="layui-input" type="text" value="${name }"/>
						<input id="pagenumber" type="hidden" name="page" value="1"> 
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">所属分类</label>
					<div class="layui-input-inline">
						<select name="rank" lay-verify="">
						  <option value="0" <c:if test="${rank==0 }"> selected="selected"</c:if>>请选择</option>
						  <option value="1"<c:if test="${rank==1 }"> selected="selected"</c:if>>甲级医院</option>
						  <option value="2"<c:if test="${rank==2 }"> selected="selected"</c:if>>乙级医院</option>
						</select>   
					</div>
				</div>
				<div class="layui-inline"><button class="layui-btn" lay-submit="">查询</button></div>
				
			</form>
		</div>
		<table>
		<tr>
		<td>
		<button class="layui-btn layui-btn-normal layui-btn-mid add">新增</button>
		</td>
		</tr>
		</table>
		<div class="table-listm roll-x">
			<table class="layui-table" lay-skin="line">
			  <thead>
			    <tr>
			    	
			      <th>医院名称</th>
			      <th>等级</th>
			      <th>联系人姓名</th>
			      <th>联系方式</th>
			      <th>备注</th>
			      <th>操作</th>
			    </tr> 
			  </thead>
			  <tbody>
			  
			  <c:forEach items="${hp }" var="hospital">
			  	<tr>
			      <td>${hospital.name}</td>
			      <td> <c:if test="${hospital.rank==1 }">甲级医院</c:if>
			      <c:if test="${hospital.rank==2 }">乙级医院</c:if></td>
			      <td>${hospital.contact}</td>
			      <td>${hospital.phone}</td>
			      <td>${hospital.remark}</td>
			      <td>
			      	<button class="layui-btn layui-btn-warm layui-btn-small edit" id="${hospital.id}" >编辑</button>
			      	<button class="layui-btn layui-btn-danger layui-btn-small delete" id="${hospital.id}">删除</button>
			      </td>
			    </tr>
			  </c:forEach>
			    
			  </tbody>
			</table>   
		</div>
	</div>
	<div id="table-pages" style="text-align:center"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui2/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
    <script>
    layui.use(['jquery', 'laydate','form','layer','laypage'], function(){
		var $ = layui.jquery,
		    laydate = layui.laydate,
		    layer = layui.layer,
		    laypage = layui.laypage;

		// 分页
		 laypage({
		    cont: 'table-pages'
		    ,pages: "${totalpage}"
		    ,skip: true
		    , curr: "${curr}"
		    ,jump:function(e,first){  //第一次访问不跳转
		        if(!first){  
		        	$("#pagenumber").val(e.curr)
		        	$("#IDform").submit();
		          }  
		      }  
		  });


		// 删除操作
	    $(".delete").click(function(){
	    	var id = this.id;
	    
		    layer.open({
		      title:"删除操作"
			  ,content: '您确认要删除该商品吗？'
			  ,btn: ['取消', '确认']
			  ,yes: function(index, layero){
				
			  }
			  ,btn2: function(index, layero){
				  $.post("${pageContext.request.contextPath }/deletehospital?id="+id);
			   	location.reload(true)
			   	 layer.closeAll()
			   	 location.reload(true)
			  }
			});
		});
		
		$(".add").click(function(){
			layer.open({
				  type:2
				  ,title:"添加操作"
				  ,area:['50%', '50%']
				  ,content: '${pageContext.request.contextPath }/addHospital'
					 
				});
			
			
			});
			  
		  $(".edit").click(function(){
			layer.open({
			      type:2
			      ,area:['50%', '50%']
			      ,title:"编辑操作"
				  ,content: '${pageContext.request.contextPath }/edithospital?id='+this.id
				 
				});
			})
	});
		
	</script>
</body>
</html>