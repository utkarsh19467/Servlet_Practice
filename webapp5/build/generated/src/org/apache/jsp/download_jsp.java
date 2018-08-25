package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;

public final class download_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        .box{\n");
      out.write("          width:130px;\n");
      out.write("          height: 130px;\n");
      out.write("          border: 1px solid#000;\n");
      out.write("          padding: 5px;\n");
      out.write("          margin: 10px;\n");
      out.write("          text-align: CENTER;\n");
      out.write("        }\n");
      out.write("        a\n");
      out.write("        {\n");
      out.write("            color: tomato;\n");
      out.write("            margin-left: 10px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        a:hover\n");
      out.write("        {\n");
      out.write("            color: tomato;\n");
      out.write("            margin-left: 10px;\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    <body>\n");
      out.write("        <h1 style=\"text-align: center\">My Family Images</h1>\n");
      out.write("        <form action=\"upload.jsp\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("        <div style=\"width:80%;height: 50px;padding-left: 60%;\">UPLOAD IMAGES<input type=\"file\" name=\"file\" style=\"border:1px solid#000;padding:5px; \"><input type=\"submit\" name=\"sbt\" value=\"UPLOAD\"> </div>\n");
      out.write("        </form>\n");
      out.write("        ");

            int p=1;
            try{
            p=Integer.parseInt(request.getParameter("pages"));}
            catch(Exception e)
            {
                p=1;
            }
            String path=application.getRealPath("/")+"images";
            File f=new File(path);
            String filenames[]=f.list();
            int len=filenames.length;
             
      out.write("\n");
      out.write("        <table style=\"margin: 30px;\">\n");
      out.write("            <tr>\n");
      out.write("                ");

                    for(int i=(p-1)*10+1;i<=p*10&&i<=len;i++)
                    {
                       
      out.write("\n");
      out.write("                       <td class=\"box\"><a href=\"load.jsp?filename=");
      out.print(filenames[i-1]);
      out.write("\"><img src=\"images/");
      out.print(filenames[i-1]);
      out.write("\" width:120px height:120px></a></td>\n");
      out.write("                       ");

                           if(i%5==0&&i%10!=0)
                           {
                          out.println("</tr><tr>");
                           }
                       }
                      
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            </table>\n");
      out.write("        <div style=\"width:80%;padding-left:30%\">\n");
      out.write("            ");

                if(len>10)
                {
                int pages=len/10;
                if(len%10!=0)
                    pages=pages+1;
                if(p>1)
                {
                
      out.write("\n");
      out.write("                <a href=\"?pages=");
      out.print(p-1);
      out.write("\">&lt;&lt;</a>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                ");

                    for(int i=1;i<=pages;i++)
                    {
                   
      out.write("     \n");
      out.write("                   \n");
      out.write("                   <a href=\"?pages=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("                   ");

                       }
                   if(p!=pages)
                        { 
                      
      out.write("\n");
      out.write("                      <a href=\"?pages=");
      out.print(p+1 );
      out.write("\">&gt;&gt;</a>\n");
      out.write("            ");

                }
              } 
             
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
