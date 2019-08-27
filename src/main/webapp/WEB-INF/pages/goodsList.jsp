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
			<form class="layui-form layui-form-pane" action="">
				<div class="layui-inline">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-block">
						<input  autocomplete="off" placeholder="请输入商品名称" class="layui-input" type="text"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">所属分类</label>
					<div class="layui-input-inline">
						<select lay-verify="">
						  <option value="0">请选择</option>
						  <option value="1">名牌包包</option>
						  <option value="2">名牌手表</option>
						  <option value="3">锦龙春酒业</option>
						  <option value="4">伍基酵素</option>
						  <option value="5">韵客翡翠</option>
						  <option value="6">品牌豪车</option>
						</select>   
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">所属品牌</label>
					<div class="layui-input-block">
						<input  autocomplete="off" placeholder="请输入所属品牌" class="layui-input" type="text"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">商品状态</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
						  <option value="0">请选择</option>
						  <option value="1">待上架</option>
						  <option value="2">已上架</option>
						  <option value="3">已下架</option>
						  <option value="4">已售罄</option>
						</select>   
					</div>
				</div>				
				<div class="layui-inline">
					<label class="layui-form-label">开始时间</label>
					<div class="layui-input-inline">
						<input class="layui-input layui-date" placeholder="开始时间" id="start">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">截止时间</label>
					<div class="layui-input-inline">
						<input class="layui-input layui-date" placeholder="结束时间" id="end">
					</div>
				</div>
				<div class="layui-inline"><button class="layui-btn" lay-submit="">查询</button></div>
			</form>
		</div>

		<fieldset class="layui-elem-field mt10">
		  <legend>2016-12-01 至 2016-12-28已售商品统计</legend>
		  <div class="layui-field-box">
			<table class="layui-table" lay-skin="nob">
			  <tbody>
			    <tr>
			      <td>商品成本：<span class="price">120000.00</span></td>
			      <td>成交金额：<span class="price">120000.00</span></td>
			      <td>成交AGR：12000 </td>
			      
			      <td align="right">
			      	<span class="tar mt10">
						<button class="layui-btn layui-btn-normal layui-btn-small add">+发布商品</button>
						<button class="layui-btn layui-btn-normal layui-btn-small">导出</button>
					</span>
				 </td>
			    </tr>
			  </tbody>
			</table>
		  </div>
		</fieldset>
		
		<div class="table-listm roll-x">
			<table class="layui-table" lay-skin="line">
			  <thead>
			    <tr>
			      <th colspan="2">商品名称</th>
			      <th>所属分类</th>
			      <th>所属品牌</th>
			      <th>销售价</th>
			      <th>AGR</th>
			      <th>已售数量</th>
			      <th>库存</th>
			      <th>发布时间</th>
			      <th>商品状态</th>
			      <th>操作</th>
			    </tr> 
			  </thead>
			  <tbody>
			  
			  <c:forEach begin="0" step="1" end="4">
			  		<tr>
			      <td width="66" ><a href="javascript:;"  class="a3"><img class="img-cp" src="${pageContext.request.contextPath }/layui2/img/1.jpg" alt=""></a></td>
			      <td width="300">
			      	<a href="javascript:;"  class="a3"><div>国本  电信  理财一号 </div>
			      	<div class="gray">保本,浮动</div></a>
			      </td>
			      <td>专属理财</td>
			      <td>电信</td>
			      <td><span class="price">1000.0</span></td>
			      <td>50000</td>
			      <td>3</td>
			      <td>20</td>
			      <td>2017-05-05 12:00:00</td>
			      <td>待上架</td>
			      <td>
			      	<button class="layui-btn layui-btn-normal layui-btn-small a1">上架</button>
			      	<button class="layui-btn layui-btn-warm layui-btn-small add">编辑</button>
			      	<button class="layui-btn layui-btn-danger layui-btn-small a4">删除</button>
			      </td>
			    </tr>
			  </c:forEach>
			    
			    
			  </tbody>
			</table>   
		</div>
	</div>
	<div id="table-pages" style="text-align:center"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui2/layui/layui.js"></script>
	
    <script>
    layui.use(['jquery', 'laydate','form','layer','laypage'], function(){
		var $ = layui.jquery,
		    laydate = layui.laydate,
		    layer = layui.layer,
		    laypage = layui.laypage;


		// 分页
		 laypage({
		    cont: 'table-pages'
		    ,pages: 4
		    ,skip: true
		    , curr: "${curr}"
		    ,jump:function(e,first){  //第一次访问不跳转
		        if(!first){  
		            location.href = 'goodlist?page='+e.curr;
		          }  
		      }  
		  });

        // 开始时间及截止时间
        var start = {
		   choose: function(datas){
		      end.min = datas; //开始日选好后，重置结束日的最小日期
		      end.start = datas //将结束日的初始值设定为开始日
		    }
		  };
		  
		  var end = {
		    choose: function(datas){
		      start.max = datas; //结束日选好后，重置开始日的最大日期
		    }
		  };

		$('#start').click(function(){
			start.elem = this;
			laydate(start);
		});

		$('#end').click(function(){
			end.elem = this
			laydate(end);
		});

		// 删除操作
	    $(".a4").click(function(){
		    layer.open({
		      title:"删除操作"
			  ,content: '您确认要删除该商品吗？'
			  ,btn: ['取消', '确认']
			  ,yes: function(index, layero){
			       layer.closeAll();
			  }
			  ,btn2: function(index, layero){
			      layer.msg('删除成功！',{time: 1000});
			  }
			});
		});
		 // 上架操作
			$(".a1").click(function(){
			    layer.open({
			      title:"上架操作"
				  ,content: '您确认要上架该商品吗？'
				  ,btn: ['取消', '确认']
				  ,yes: function(index, layero){
				       layer.closeAll();
				  }
				  ,btn2: function(index, layero){
				      layer.msg('上架成功！',{time: 1000});
				  }
				});
			});
 		// 下架操作
			$(".a2").click(function(){
			    layer.open({
			      title:"下架操作"
				  ,content: '您确认要下架该商品吗？'
				  ,btn: ['取消', '确认']
				  ,yes: function(index, layero){
				       layer.closeAll();
				  }
				  ,btn2: function(index, layero){
				      layer.msg('下架成功！',{time: 1000});
				  }
				});
			});
		
				$(".a3").click(function(){
					
					layer.open({
					      type:2
					      ,area:['80%', '90%']
					      ,title:"商品详情"
						  ,content: '${pageContext.request.contextPath }/goodsInfo'
						});
				})
			 
			  
			  $(".add").click(function(){
					
					layer.open({
					      type:2
					      ,area:['80%', '90%']
					      ,title:"商品编辑"
						  ,content: '${pageContext.request.contextPath }/goodsEdit'
						});
				})
	});
	
	   
		
	</script>
</body>
</html>