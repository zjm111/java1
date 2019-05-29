<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery-1.8.1.js"></script>
    <script src="https://cdn.bootcss.com/moment.js/2.24.0/moment.min.js"></script>
    <script type="text/javascript">
        function fa(msg){
            $(msg).each(function(index,item) {
                var time = moment(item.addtime).format('YYYY-MM-DD');
                var tr=
                    "<tr align='center' bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"
                    +"<td><input name='id' type='checkbox' id='id' value='"+item.id+"' class='np'></td>"
                    +"<td>"+item.id+"</td>"
                    +"<td>"+item.companyperson+"</td>"
                    +"<td align='center'>"+item.comname+"</td>"
                    +"<td>"+time+"</td>"
                    +"<td>"+item.comphone+"</td>"
                    +"<td><a href='customer-edit.jsp?id="+item.id+"'>编辑</a> | <a href='${pageContext.request.contextPath}/cus/showDetails/"+item.id+"'>查看详情</a></td></tr>"
                $("#tr").before(tr);
            });
        }

        $(function () {
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/cus/showInfo",
                success: function(msg){
                    fa(msg);
                },
                error:function (msg) {
                    alert("网络问题，稍后重试")
                }
            });
        })

        function searchInfo() {
            var tj=$("select[name='cid']").val();
            var gjz=$("input[name='keyword']").val();
            var px=$("select[name='orderby']").val();
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/cus/searchInfo",
                data:{"tj":tj,"gjz":gjz,"px":px},
                success: function(msg){
                    $("#tb").find("tr[name!='tr1']").remove();
                    //遍历集合
                   fa(msg);
                },
                error:function (msg) {
                    alert("网络问题，稍后重试")
                }
            });
        }
        function chooseall() {
         $("#tb").find("input").attr("checked","checked");
        }
        function reversechoose() {
         $("#tb").find("input").each(function (index,item) {
             $(this).attr("checked",!$(this).attr("checked"));
         })
        }
        function deletecus() {
         var ids="";
         $("#tb").find("input:checked").each(function (index,item) {
            ids=ids+$(this).val()+",";
         });
            $.ajax({
                type: "DELETE",
                url: "${pageContext.request.contextPath}/cus/deletecus/"+ids,
                contentType:"application/json",
                success: function(msg){
                    if (msg.statusCode==200){
                        window.location.href="${pageContext.request.contextPath}/customer.jsp"
                    }else {
                        if (!confirm("出错了，是否留在该页面？")){
                            window.location.href="${pageContext.request.contextPath}/customer.jsp"

                        }
                    }
                }
            });
        }
        function exportExcel() {
            $.ajax({
               type:"GET",
               url:"${pageContext.request.contextPath}/cus/export",
                success: function(result){
                if (result.statusCode==200){
                    alert(result.msg);
                }
                }
            });
        }
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
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='customer-add.jsp';" value='添加客户信息' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='javascript:void(0)' method='get'>
<input type='hidden' name='_method' value='delete' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style=''>
          <option value='0'>选择类型...</option>
          	<option value='1'>客户所在公司名称</option>
          	<option value='2'>联系人姓名</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='0'>添加时间</option>
            <option value='1'>修改时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" onclick="searchInfo()" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form id="form2" name="form2">

<table id="tb" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr name="tr1" bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr name="tr1" align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>
<tr id="tr" name="tr1" ></tr>
<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >--%>
	<%--<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>--%>
	<%--<td>1</td>--%>
	<%--<td>李彦宏</td>--%>
	<%--<td align="center">百度</td>--%>
	<%--<td>2015-02-03</td>--%>
	<%--<td>13257634888</td>--%>
	<%--<td><a href="customer-edit.jsp">编辑</a> | <a href="customer-look.jsp">查看详情</a></td>--%>
<%--</tr>--%>


<tr name="tr1" bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="JavaScript:chooseall();"  class="coolbg">全选</a>
	<a href="JavaScript:reversechoose()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="JavaScript:deletecus()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="JavaScript:exportExcel()" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr name="tr1" align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  

</body>
</html>