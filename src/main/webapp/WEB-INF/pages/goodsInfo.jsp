<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <title>国本善美管理平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/admin.css"/>
</head>
<body>
	    <table class="layui-table layui-table-add" lay-skin="nob">
		  <tbody>
		    <tr>
		      <th width="100" class="pad" style="padding: 14px 15px!important;">商品名称</th>
		      <td>Apple iPhone 7 128G 红色特别版<button class="layui-btn layui-btn-normal layui-btn-small ml10">浏览商品</button></td>
		    </tr>
		    <tr>
		      <th class="pad">所属分类</th>
		      <td>名牌手表 </td>
		    </tr>
		    <tr>
		      <th class="pad">所属品牌</th>
		      <td>浪陀 </td>
		    </tr>
		    <tr>
		      <th class="pad">显示市场价</th>
		      <td><span class="price">2980000.00</span>
		       </td>
		    </tr>
		    <tr>
		      <th class="pad">销售价</th>
		      <td><span class="price">1490000.00</span>
		      </td>
		    </tr>
		    <tr>
		      <th class="pad">AGR</th>
		      <td>
		        	57307
		      </td>
		    </tr>
		    <tr>
		      <th class="pad">库存</th>
		      <td>20</td>
		    </tr>
		    <tr>
		      <th class="pad">商品状态</th>
		      <td>待上架/已上架/已下架/已售罄</td>
		    </tr>
		    <tr>
		      <th class="pad">已售数量</th>
		      <td>3</td>
		    </tr>
		     <tr>
		      <th class="pad">成交商品成本</th>
		      <td><span class="price">10000000.00</span>
		      </td>
		    </tr>
		     <tr>
		      <th class="pad">成交金额</th>
		      <td><span class="price">100000.00</span>
		      </td>
		    </tr>
		    <tr>
		      <th class="pad">成交AGR</th>
		      <td>57307 </td>
		    </tr>
		    <tr>
		      <th class="pad">商品属性类型</th>
		      <td>双主属性(尺码+颜色)</td>
		    </tr>
		    <tr>
		      <th class="pad">具体商品属性</th>
		      <td>
			    规格：男款,女款。颜色：白色,红色。
			  </td>
		    </tr>
		    <tr>
		      <th class="pad">发布时间</th>
		      <td>2017-03-28 17:32:21</td>
		    </tr>
		  </tbody>
		</table>


	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script>
		layui.use(['jquery','form','upload','layer'], function(){
			var $ = layui.jquery,layer = layui.layer;
		});
	</script>
</body>
</html>