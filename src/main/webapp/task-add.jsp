<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>创建任务</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/images/jquery-1.8.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/pro/prolistwithanalyse",
                success: function (msg) {
                    $(msg).each(function (index, itme) {
                        $("#proname").append("<option value='" + itme.pname + "," + itme.pid + "'>" + itme.pname + "</option>")
                    })
                }
            });
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/emp/emps",
                success: function (msg) {
                    $(msg).each(function (index, itme) {
                        $("#operator").append("<option value='" + itme.eid + "'>" + itme.ename + "</option>")
                    })
                }
            });

        })
        function parseAnalyse(obj) {
            var namewithid = obj.value;
            var pid = namewithid.split(",")[1];
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/analyse/info/" + pid,
                success: function (msg1) {
                    $("#analyse > option").remove();
                    $("#analyse").append("<option value='"+msg1.id+"'>"+msg1.title+"</option>");
                }
            });

            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/module/info/" + pid,
                success: function (msg2) {
                    $(msg2).each(function (index,item) {
                        $("#modules").append("<option value='"+item.id+"'>"+item.modname+"</option>");
                    })
                }
            });
        }
        function parseFunctions(mid) {
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/function/list/" + mid,
                success: function (msg3) {
                    alert(mid);
                 $(msg3).each(function (index,item) {
                     $("#functions").append("<option value='"+item.id+"'>"+item.functionname+"</option>");
                 })
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
                    <td>
                        当前位置:任务管理>>创建任务
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" action="${pageContext.request.contextPath}/task/saveInfo" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务<span style="color: red;font-size: 20px">${msg}</span>&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <select id="proname" onchange="parseAnalyse(this)">
                <option value=1>请选择项目</option>
            </select>
            -<select id="analyse" >
                <option value=1>项目需求</option>
            </select>
            -<select id="modules" onchange="parseFunctions(this.value)">
                <option value=1>请选择项目模块</option>
            </select>
            -<select id="functions" name="funFk">
                <option value=1>请选择模块功能</option>
            </select></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="define"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="starttime"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="endtime"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select id="operator" name="empFk2">
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="level">
                    <option>高</option>
                    <option>中</option>
                    <option>低</option>
                    <option>暂缓</option>
                </select></td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">详细说明：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <%--<a href="task-add.jsp" class="coolbg">保存</a>--%>
                <input type="submit" value="保存" class="coolbg">
            </td>
        </tr>
    </table>

</form>


</body>
</html>