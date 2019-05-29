<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>main</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery-1.8.1.js"></script>
	<script src="https://cdn.bootcss.com/moment.js/2.24.0/moment.min.js"></script>
	<script type="text/javascript">
        $(function(){
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/notice/showAll',
                dataType:'json',
                success:function(resultData){
                    $(resultData).each(function(index,item){
                        var time = moment(item.ndate).format('YYYY-MM-DD');
                        var tr ="<li class='ue-clear'>"
                            		+"<span>"+time+"</span>&nbsp;&nbsp;&nbsp;<a onclick='showWind("+item.nid+")' class='notice-title'>"+item.ntitle+"</a>"
                        		+"</li>"
                        $("#notice-list").append(tr);
                    });
                },
            });
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/tz/tzlist',
                dataType:'json',
                success:function(result){
                    $(result).each(function(index,item){
                        var time = moment(item.date).format('YYYY-MM-DD');
                        var tr ="<li class='ue-clear'> <span><img src='${pageContext.request.contextPath}/images/tx.png' height='50px' width='50px'/>"
							+"</span> 发布时间："+time+" <a href='role.jsp'class='notice-title'>"+item.biaoti+"</a></li><p>"
                        $("#tiezi").append(tr);
                    });
                },
            });

        });

        function showWind(nid) {
			$("#showdiv").show();
            $("#cover").css({"display":"block","height":window.screen.availHeight+"px"});
            $("#cover").show()
            $.ajax({
                type:'GET',
                url:'${pageContext.request.contextPath}/notice/infoByNid/'+nid,
                success:function(result){
                    $("#ntitle").text(result.ntitle);
                    $("#content").text(result.remark);
                },
            });
        }
        function closeWindow() {
            $("#showdiv").hide();
            $("#cover").hide();
        }
	</script>
</head>
<body leftmargin="8" topmargin='8'>
<!-- 遮罩层 -->
<div id="cover" style="background: #000; position: absolute; left: 0px; top: 0px; width: 100%; filter: alpha(opacity=30); opacity: 0.3; display: none; z-index: 2 ">

</div>
<!-- 弹窗 -->
<div id="showdiv" style="width: 60%; margin: 0 auto; height:500px; border: 1px solid #999; display: none; position: absolute; top: 20%; left: 20%; z-index: 3; background: #fff">
	<!-- 标题 -->
	<div id="ntitle" style="background: #F8F7F7; width: 100%; height: 2rem; font-size: 2rem; line-height: 2rem; border: 1px solid #999; text-align: center;" >

	</div>
	<!-- 内容 -->
	<div id="content" style="text-indent: 50px; height: 4rem; font-size: 1.5rem; padding: 0.5rem; line-height: 1rem; ">

	</div>
	<!-- 按钮 -->
	<div style="background: green; width: 10%; margin: 0 auto; height: 1.5rem; line-height: 1.5rem; text-align: center;color: #fff;margin-top: 28rem; -moz-border-radius: .128rem; -webkit-border-radius: .128rem; border-radius: .128rem;font-size: .59733rem;" onclick="closeWindow()">
		关闭
	</div>
</div>

	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><div style='float: left'>
					<img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用项目平台管理系统
				</div>
				<div style='float: right; padding-right: 8px;'>
					<!--  //保留接口  -->
				</div></td>
		</tr>
		<tr>
			<td height="1" background="skin/images/frame/sp_bg.gif"
				style='padding: 0px'></td>
		</tr>
	</table>

 



	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				class='title'><span>待完成任务</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>您有<a href=""><font color="red">2</font></a>个任务未完成……&nbsp;
			</td>
		</tr>
	</table>



	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				class='title'><span>未读消息</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>您有<a href=""><font color="red">10</font></a>条未读消息……&nbsp;
			</td>
		</tr>
	</table>


	

	<table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				class='title'><span>通知公告</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>
				<ul class="notice-list" id="notice-list">

				</ul>
			</td>
		</tr>
	</table>

    <table width="98%" align="center" border="0" cellpadding="3"
		cellspacing="1" bgcolor="#CBD8AC"
		style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
				class='title'><span>员工论坛</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td>
				<ul class="notice-list" id="tiezi">

				</ul>
			</td>
		</tr>
	</table>

</body>
</html>