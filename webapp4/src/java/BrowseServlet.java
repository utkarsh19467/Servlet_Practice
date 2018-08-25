

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/browse"})
public class BrowseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
    {
        String email=req.getParameter("txt3");
        String gender=req.getAttribute("gender").toString();
        String b=req.getAttribute("img").toString();
        PrintWriter pw=res.getWriter();
         
       
        pw.println("<html>");
        
        pw.println("<link href='kajol.css' rel=stylesheet>");
        pw.println("<center>");
        pw.println("<form action='upload?gender="+gender+"&txt3="+email+"' enctype='multipart/form-data' method=post>");
        
          pw.println("<table style='margin-top:50px;'>");
            pw.println("<tr>"); 
              pw.println("<td rowspan=2>");
              if(b.equals("N"))
        {
            pw.println("<img src='"+gender+".png' width=225 height=225>");
        }
        else
        {
            pw.println("<img src='http://localhost:29002/webapp4/img?email="+email+"' width=225 height=225>");
        }
        
                  pw.println("</td>");
                    pw.println("<td>");
                      pw.println("<tr>");
                        pw.println("<td><input type=file name=file></td>");
                          pw.println("</tr>");
                          pw.println("<tr>");
                          pw.println("<td><input type=submit value=UPLOAD name=sbt class='btn'>&nbsp;&nbsp<input type=submit name=sbt value=NEXT  class='btn'></td>");
                          pw.println("</tr>");
                          pw.println("</td>");
                          pw.println("</tr>");
                          pw.println("</table>");
                          pw.println("</center>");
                          pw.println("</html>");
    }
}
