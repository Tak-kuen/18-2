/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.11
 * Generated at: 2018-11-14 11:46:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.web2_0;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>1501163_송탁근</title>\r\n");
      out.write("<script\r\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.3.1.js\"\r\n");
      out.write("  integrity=\"sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=\"\r\n");
      out.write("  crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$(\"#BeforeLogin\").show();\r\n");
      out.write("\t$(\"#Login\").hide();\r\n");
      out.write("\t$(\"#LoginResult\").hide();\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#ToLogin\").click(function() {\r\n");
      out.write("\t\t$(\"#BeforeLogin\").hide();//hidden\r\n");
      out.write("\t\t$(\"#Login\").show();//show\r\n");
      out.write("\t\t$(\"#loginBtnLogin\").click(function() {\r\n");
      out.write("\t\t\tvar query={ id: $(\"#loginTxtID\").val(), passwd:$(\"#loginTxtPw\").val()};\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\turl:\"loginPro.jsp\",\r\n");
      out.write("\t\t\t\tdata:query,\r\n");
      out.write("\t\t\t\tsuccess:function(data) {\r\n");
      out.write("\t\t\t\t\tif(data==0) {\r\n");
      out.write("\t\t\t\t\t\talert(\"비밀번호가 틀립니다.\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtPw\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtPw\").focus();\r\n");
      out.write("\t\t\t\t\t\t$(\"#LoginResult\").html(\"\");\r\n");
      out.write("\t\t\t\t\t}else if(data==-1) {\r\n");
      out.write("\t\t\t\t\t\talert(\"아이디가 없습니다.\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtID\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtPw\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtID\").focus();\r\n");
      out.write("\t\t\t\t\t\t$(\"#LoginResult\").html(\"\");\r\n");
      out.write("\t\t\t\t\t}else {\r\n");
      out.write("\t\t\t\t\t\tvar result=JSON.parse(data);\r\n");
      out.write("\t\t\t\t\t\tvar area=result[0].mname;\r\n");
      out.write("\t\t\t\t\t\talert(\"환영합니다. <h3>\" + area + \"</h3> 님\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtID\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#loginTxtPw\").val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#LoginResult\").html(\"<p>안녕하세요</p><h3>\" + area + \"</h3><p>님.</p>\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#LoginResult\").show();\r\n");
      out.write("\t\t\t\t\t\tconsole.log(result);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}//success\r\n");
      out.write("\t\t\t});//ajax\r\n");
      out.write("\t\t});//loginBtnLogin\r\n");
      out.write("\t});//tologin\r\n");
      out.write("});//document\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"BeforeLogin\">\r\n");
      out.write("\t\t<img src='https://www.yju.ac.kr/sites/kr/images/img_symbol_mark.png'\r\n");
      out.write("\t\t\twidth='300px' height='300px' /><br/>\r\n");
      out.write("\t\t<button id=\"ToLogin\"> 인트로화면에서 로그인화면으로가기</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"Login\">\r\n");
      out.write("\t\t<h1>My SNS Service</h1>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<h3>로그인해주세요</h3>\r\n");
      out.write("\t\t<p>아이디</p>\r\n");
      out.write("\t\t<input type=\"text\" id=\"loginTxtID\" maxlength=\"50\"/>\r\n");
      out.write("\t\t<p>비밀번호</p>\r\n");
      out.write("\t\t<input type=\"password\" id=\"loginTxtPw\" maxlength=\"50\"/>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<button id=\"loginBtnLogin\">로그인</button>\r\n");
      out.write("\t\t<button id=\"loginBtnJoin\">회원가입</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"LoginResult\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}