

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/change"})
public class ChangePassServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
  {
      String s=req.getParameter("err");
       PrintWriter pw=res.getWriter();
       pw.println("<html>");
       RequestDispatcher rd1=getServletContext().getRequestDispatcher("/head");
       rd1.include(req, res);
       pw.println("<div class=content>");
       RequestDispatcher rd2=getServletContext().getRequestDispatcher("/nav");
       rd2.include(req, res);
       pw.println(" <div class=\"frm\">");
       pw.println("<from action='match'>");
       pw.println("<table>");
       pw.println("<tr>");
       pw.println("<td>OLD PASSWORD</td>");
       pw.println("<td><input type=password name=op class=tf></td>");
       pw.println("</tr>");
       pw.println("<tr>");
       pw.println("<td>NEW PASSWORD</td>");
       pw.println("<td><input type=password name=np class=tf></td>");
       pw.println("</tr>");
         pw.println("<tr>");
       pw.println("<td>CONFIRM PASSWORD</td>");
       pw.println("<td><input type=password name=cp class=tf></td>");
       pw.println("</tr>");
       pw.println("<tr>");
       pw.println("<td></td>");
       pw.println("<td colspan=2>ENTER CAPTCHA</td>");
       pw.println("</tr>");
       pw.println("<tr>");
          pw.println("<td></td>");
          InetAddress address=InetAddress.getLocalHost();
          String ip=address.getHostAddress();
       pw.println("<td colspan=2><img src='http://"+ip+":29002/webapp4/captcha'></td>");
       pw.println("</tr>");
       pw.println("<tr>");
          pw.println("<td></td>");
               pw.println("<td colspan=2><input type=text name=cap class=tf></td>");
               pw.println("</tr>");
                  pw.println("<td></td>");
               pw.println("<tr>");
                  pw.println("<td></td>");
               pw.println("<td colspan=2><input type=submit value=SUBMIT name=sbt class=btn></td>");
               pw.println("</tr>");
               pw.println("<tr>");
               if(s!=null&&s.equals("A"))
               {
                   pw.println("<td colspan=2 style='text-decoration:none;Color.RED;'>");
               pw.println("password changed successfully");
               pw.println("</td>");
               }
               else if(s!=null&&s.equals("B"))
               {
                   pw.println("<td colspan=2 style='text-decoration:none;Color.RED;'>");
               pw.println("password doesn't match with new entered password");
               pw.println("</td>");
               }
            else if(s!=null&&s.equals("C"))
               {
                   pw.println("<td colspan=2 style='text-decoration:none;Color.RED;'>");
               pw.println("entered captcha is wrong");
               pw.println("</td>");
               }
    pw.println("</tr>");
   pw.println("</table>");
   pw.println("</form>");
       pw.println("</div>");
       pw.println("</div>");
       pw.println("</html>");
       
  }
}
