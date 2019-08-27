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
	<div class="container">
		<div class="content-search">
			<form class="layui-form layui-form-pane" action="">
				<div class="layui-inline">
					<label class="layui-form-label">会员ID</label>
					<div class="layui-input-block">
						<input name="date" placeholder="请输入会员ID" autocomplete="off" class="layui-input" type="text"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">会员姓名</label>
					<div class="layui-input-block">
						<input name="date" placeholder="请输入会员姓名" autocomplete="off" class="layui-input" type="text"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">手机号码</label>
					<div class="layui-input-block">
						<input name="date" placeholder="请输入手机号码" autocomplete="off" class="layui-input" type="text"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">用户状态</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
						  <option value="0">请选择</option>
						  <option value="1">正常</option>
						  <option value="2">冻结</option>
						</select>   
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">绑定AGR</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
						  <option value="0">请选择</option>
						  <option value="1">已绑定</option>
						  <option value="2">未绑定</option>
						</select>   
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">AGR级别</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
						  <option value="0">请选择</option>
						  <option value="1">注册会员</option>
						  <option value="2">P1</option>
						  <option value="3">P2</option>
						  <option value="4">P3</option>
						  <option value="5">V1</option>
						  <option value="6">V2</option>
						  <option value="7">V3</option>
						</select>   
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">AGR账户ID</label>
					<div class="layui-input-block">
						<input name="date" placeholder="请输入AGR账户ID" autocomplete="off" class="layui-input" type="text"/>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">AGR用户名</label>
					<div class="layui-input-block">
						<input name="date" placeholder="请输入AGR用户名" autocomplete="off" class="layui-input" type="text"/>
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

		<div class="table-list layui-form roll-x">
			<table class="layui-table" lay-skin="line">
			  <thead>
			    <tr>
			      <th>会员ID</th>
			      <th>会员姓名</th>
			      <th>手机号码</th>
			      <th>绑定AGR</th>
			      <th>AGR级别</th>
			      <th>AGR账户ID</th>
			      <th>AGR用户名</th>
			      <th>账户余额</th>
			      <th>账户AGR</th>
			      <th>注册时间</th>
			      <th>购物权限</th>
			      <th>用户状态</th>
			      <th>操作</th>
			    </tr> 
			  </thead>
			  <tbody>
			    <tr>
			      <td><a href="javascript:;" class="a2">100001</a></td>
			      <td>张三</td>
			      <td>13688888888</td>
			      <td>已绑定</td>
			      <td>V1</td>
			      <td>AGR00001</td>
			      <td>Harry</td>
			      <td><span class="price">100000.00</span></td>
			      <td>50000</td>
			      <td>2016-10-28 16:23:17</td>
			      <td><input type="checkbox" name="switch" checked lay-skin="switch" lay-text="启用|冻结"></td>
			      <td><input type="checkbox" name="switch" checked lay-skin="switch" lay-text="启用|冻结"></td>
			      <td>
			      	<button class="layui-btn layui-btn-normal layui-btn-small a3">已购商品</button>
			      </td>
			    </tr>
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
			    ,pages: 5
			    ,skip: true
			    , curr: "${curr}"
			    ,jump:function(e,first){  //第一次访问不跳转
			        if(!first){  
			            location.href = 'associatorlist?page='+e.curr;
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

			

			// 会员详情
			$(document).on("click", ".a2", function() {
			    layer.open({
			      type:2
			      ,area:['50%', '70%']
			      ,title:"会员详情"
				  ,content: '${pageContext.request.contextPath }/associatorInfo'
				});
			});


			// 账户流水
			$(document).on("click", ".a3", function() {
			    layer.open({
			      type:2
				  ,area:['100%', '100%']
			      ,title:"当前选定用户下商品"
				  ,content: '${pageContext.request.contextPath }/goodlist'
				});
			});
			
		});
	</script>
</body>
</html>