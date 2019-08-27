<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <title>众创数字资产综合运营管理平台</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/admin.css"/>
</head>
<body>
	<div class="container">
	    <blockquote class="layui-elem-quote"><span style="color:#FF5722">超级管理员</span>
	    <p>国本善美管理平台欢迎您！</p></blockquote>

	    <fieldset class="layui-elem-field site-demo-button">
		  <legend>近七天统计</legend>
		  <div class="layui-form">
		  <table class="layui-table" lay-skin="nob">
		    <tbody>
		      <tr>
		        <td>新注册会员：500个</td>
		        <td>绑定AGR账户：280个</td>
		      </tr>
		      <tr>
		        <td>待发货订单（平台）：28个</td>
		        <td>待发货订单（第三方）：23个</td>
		      </tr>
		      <tr>
		        <td>机票订单：50个</td>
		        <td>消费金额：<span class="price">1500000.00</span></td>
		      </tr>
		      <tr>
		        <td>消费AGR：1000000</td>
		        <td>提现金额：<span class="price">1500000.00</span></td>
		      </tr>
		      <tr>
		        <td>待审核提现金额：<span class="price">1500000.00</span></td>
		        <td></td>
		      </tr>
		     
		    </tbody>
		  </table>
		</div>
		</fieldset>

		<div id="main" style="width: 100%;height:400px;"></div>
		
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.common.min.js"></script>
	<script>
	var myChart = echarts.init(document.getElementById('main'));

	var	option = {
    title: {
        text: '折线图堆叠'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'邮件营销',
            type:'line',
            stack: '总量',
            data:[120, 132, 101, 134, 90, 230, 210]
        },
        {
            name:'联盟广告',
            type:'line',
            stack: '总量',
            data:[220, 182, 191, 234, 290, 330, 310]
        },
        {
            name:'视频广告',
            type:'line',
            stack: '总量',
            data:[150, 232, 201, 154, 190, 330, 410]
        },
        {
            name:'直接访问',
            type:'line',
            stack: '总量',
            data:[320, 332, 301, 334, 390, 330, 320]
        },
        {
            name:'搜索引擎',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 934, 1290, 1330, 1320]
        }
    ]
};

myChart.setOption(option);
	</script>
   
</body>
</html>