package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("\t<link href=\"kajol.css\" rel=\"stylesheet\">\n");
      out.write("\t<script src=\"abc.js\"></script>\n");
      out.write("\t<div class=\"head\">\n");
      out.write("\t\t<img src=\"images/logo.png\" style=\"margin-left: 20px;\">\n");
      out.write("\t</div>\n");
      out.write("\t<div class=content>\n");
      out.write("\t  <div class=\"nav\">\n");
      out.write("\t\t<div class=\"navcon\">Home</div>\n");
      out.write("\t\t<div class=\"navcon\">About Us</div>\n");
      out.write("\t\t<div class=\"navcon\">FAQ</div>\n");
      out.write("\t\t<div class=\"navcon\">Join Forum</div>\n");
      out.write("\t\t<div class=\"navcon\">Contact Us</div>\n");
      out.write("\t  </div>\n");
      out.write("\t  <div class=\"frm\">\n");
      out.write("\t   <h3>New User Registeration</h3>\n");
      out.write("\t   <form action=\"signup\" onsubmit=\"return validate(this)\">\n");
      out.write("  \t   <table>\n");
      out.write("               ");
      com.user.User obj = null;
      synchronized (session) {
        obj = (com.user.User) _jspx_page_context.getAttribute("obj", PageContext.SESSION_SCOPE);
        if (obj == null){
          obj = new com.user.User();
          _jspx_page_context.setAttribute("obj", obj, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>First Name</td>\n");
      out.write("               \n");
      out.write("                <td><input type=text placeholder=\"Enter Your Name\" class=tf name=txt1></td>\n");
      out.write("                \n");
      out.write("\t    </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>Last Name</td>\n");
      out.write("                \n");
      out.write("\t\t<td><input type=text placeholder=\"Enter Last Name\" class=tf name=txt2></td>\n");
      out.write("              \n");
      out.write("\t    </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>Email</td>\n");
      out.write("                \n");
      out.write("\t\t<td><input type=email class=tf placeholder=\"Enter Email\" name=txt3 value=\"></td>\n");
      out.write("              \n");
      out.write("\t    </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>Password</td>\n");
      out.write("\t\t<td><input type=password class=tf placeholder=\"Enter Password\" name=txt4></td>\n");
      out.write("\t    </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>Confirm Password</td>\n");
      out.write("\t\t<td><input type=password class=tf placeholder=\"Enter Confirm Password\" name=txt5>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>Gender</td>\n");
      out.write("\t\t<td><input type=radio checked name=rad value=\"male\">Male<input type=radio name=rad value=\"female\">Female</td>\n");
      out.write("\t    </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td class=lbl>Country</td>\n");
      out.write("\t\t<td><select name=\"cnt\">\n");
      out.write("\t\t\t<option>India</option>\n");
      out.write("\t\t\t<option>United States</option>\n");
      out.write("\t\t</select></td>\n");
      out.write("\t    </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td>\n");
      out.write("                <td><input type=\"file\" name=\"pic\" accept=\"image/*\" class=tf></td>\n");
      out.write("                <td>Select a file to upload</td>\n");
      out.write("            </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t      \t<td></td>\n");
      out.write("                <td><input type=submit value=SUBMIT class=\"btn\">&nbsp;&nbsp;&nbsp;<a href=\"login.html\" style=\"text-decoration: none;color:#ff0000;font-size: 15px;\">EXISTING USER?</a></td>\n");
      out.write("               \n");
      out.write("\t    </tr>\n");
      out.write("\t    <tr>\n");
      out.write("\t\t<td colspan=2><span style='color:red;font-size: 13px' id=err></span></td>\n");
      out.write("\t    </tr>\t\t\t\n");
      out.write("\t   </table>\n");
      out.write("\t   </form>\n");
      out.write("\t  </div>\n");
      out.write("\t</div>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
