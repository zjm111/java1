<%@ page language="java"  import="com.zjm.usual.bean.Baoxiao,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加附件</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery-1.8.1.js"></script>
    <script type="text/javascript">
        function commit() {
        $("#form11").submit();
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
    当前位置:报销管理>>更改${nnbx.bxid}
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form11" method="post" action="${pageContext.request.contextPath}/baoxiao/genggai1">
	<input type="hidden"  name="_method" value="put">
     <input type="hidden"  name="bxid" value="${nnbx.bxid}">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;更改<span style="color: red">${msg}</span>&nbsp;</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">支出类型：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

		<select name="paymode" id="paymode">
            <c:if test="${nnbx.paymode eq '出差票据'}">
				<option value="出差票据" selected>出差票据</option>
				<option value="办公采购">办公采购</option>
				<option value="其他">其他</option>
			</c:if>
			<c:if test="${nnbx.paymode eq '办公采购'}">
				<option value="出差票据">出差票据</option>
				<option value="办公采购" selected>办公采购</option>
				<option value="其他">其他</option>
			</c:if>
			<c:if test="${nnbx.paymode eq '其他'}">
				<option value="出差票据" >出差票据</option>
				<option value="办公采购">办公采购</option>
				<option value="其他" selected>其他</option>
			</c:if>

		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">总金额：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input size="26"  id="totalmoney" name="totalmoney" value="${nnbx.totalmoney}"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">使用时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input size="52" name="bxtime" id="bxtime" value="<fmt:formatDate value="${nnbx.bxtime}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130  id="bxremark" name="bxremark">${nnbx.bxremark}</textarea>
	</td>
</tr>
    <tr >
		<td align="right" bgcolor="#FAFAF1" >批注：</td>
		<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
			<textarea rows=3 cols=130 name="result" id="pizhu" readonly="true">${nnbx.caiwuFk}</textarea>
		</td>
	</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
	<a href="${pageContext.request.contextPath}/baoxiao/list" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>