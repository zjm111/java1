/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-27 13:53:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexvalue_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("    <title>添加对标信息</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"skin/css/base.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"8\" topmargin=\"8\" background='skin/images/allbg.gif'>\r\n");
      out.write("\r\n");
      out.write("<!--  快速转换位置按钮  -->\r\n");
      out.write("<table width=\"98%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#D1DDAA\" align=\"center\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td height=\"26\" background=\"skin/images/newlinebg3.gif\">\r\n");
      out.write("            <table width=\"58%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        当前位置:对标管理>>添加对标基本信息\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/comp/saveInfo\" method=\"post\">\r\n");
      out.write("    <table width=\"98%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#D1DDAA\" align=\"center\"\r\n");
      out.write("           style=\"margin-top:8px\">\r\n");
      out.write("        <tr bgcolor=\"#E7E7E7\">\r\n");
      out.write("            <td height=\"24\" colspan=\"12\" background=\"skin/images/tbg.gif\">&nbsp;<font color=\"red\">对标企业信息如下</font>&nbsp;\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">公司名称：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <input type=\"text\" name=\"company\" id=\"company\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">营业额：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <input type=\"text\" id=\"targetmoney\" name=\"targetmoney\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">年份：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <input type=\"text\" id=\"year\" name=\"year\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">主要业务：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <textarea rows=\"3\" cols=\"18\" id=\"busines\" name=\"busines\"></textarea>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">优势：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <textarea rows=\"3\" cols=\"18\" id=\"priority\" name=\"priority\"></textarea>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">劣势：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <textarea rows=\"3\" cols=\"18\" id=\"bad\" name=\"bad\"></textarea>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">行业地位：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <input type=\"text\" name=\"status\" id=\"status\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">员工数量：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <input type=\"text\" name=\"empCount\" id=\"empCount\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\">创建时间：</td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("                <input type=\"text\" name=\"date\" id=\"date\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\" height=\"22\"></td>\r\n");
      out.write("            <td align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td align=\"right\" bgcolor=\"#FAFAF1\">简单描述：</td>\r\n");
      out.write("            <td colspan=3 align='left' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\r\n");
      out.write("                onMouseOut=\"javascript:this.bgColor='#FFFFFF';\">\r\n");
      out.write("                <textarea type=\"text\" rows=15 cols=130 id=\"description\" name=\"description\"></textarea>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("                <input type=\"submit\" value=\"保存\">\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 添加指标 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
