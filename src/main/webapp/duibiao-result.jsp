<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>对标管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery-1.8.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script type="text/javascript">
        $(function () {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            var  name=[];
            var  money=[];
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/comp/complist",
                success: function(msg){
                    if (msg!=null){
                        $(msg).each(function (index,item) {
                            name.push(item.company);
                            money.push(item.targetmoney);
                        });
                    }
                    myChart.setOption({
                        title: {
                            text: '2018营业额'
                        },
                        xAxis: {
                            data: name
                        },
                        yAxis: {},
                        series: [{
                            name: '营业额',
                            type: 'bar',
                            data: money
                        }]
                    });
                },
            });
        })

    </script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:对标管理>>对标分析
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<div id="main" style="width: 600px;height:400px;"></div>
</body>
</html>