<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <title>添加医院信息</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/admin.css"/>
</head>
<body>
    <form id="formID" class="layui-form">
	    <table class="layui-table layui-table-add" lay-skin="nob">
		  <tbody>
		    <tr style="width:30%">
		      <th><span class='red'>*</span>医院名称</th>
		      <td>
		      <div>
		      <input type="text" name="name" placeholder="请输入医院名称" autocomplete="off" class="layui-input"></td>
		   		</div>
		   	<th><span class='red'>*</span>所属分类</th>
		      <td>
		        <div class='fl'>
		        	<select lay-verify="" name="rank">
					  <option value="">请选择分类</option>
					  <option value="1">甲级医院</option>
					  <option value="2">乙级医院</option>
					</select>  
		        </div>
		      </td>
		    </tr>
		    <tr style="width:25%">
		      <th><span class='red'>*</span>联系人姓名</th>
		      <td>
		        <div>
		        	<input type="text" name="contact"  autocomplete="off" class="layui-input">
		        </div>
		      </td>
		      
		      <th><span class='red'>*</span>联系方式</th>
		      <td>
		        <div>
		        	<input type="text" name="phone"  autocomplete="off" class="layui-input">
		        </div>
		      </td>
		    </tr>
		    <tr style="width:100%">
		      <th>备注</th>
		      <td>
		        <div>
		        	<input type="text" name="remark"  autocomplete="off" class="layui-input">
		        </div>
		      </td>
		    </tr>
		  </tbody>
		</table>
		<div style="margin-left: 40%; margin-bottom: 15px;">	
			<div class="layui-btn" style=" min-width: 150px;">提 交</div>
		</div>
	</form>

	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js"></script>
	<script type="text/javascript">
	
		
		$(".layui-btn").click(function(){
			var data = $("#formID").serialize(); 
			$.post("${pageContext.request.contextPath }/savehospital", data ,function(data){
				if(data=="ok"){
					parent.window.location.reload(true)
					parent.layer.closeAll()
				}
			},"text");
			
		})
	
	</script>
</body>
</html>