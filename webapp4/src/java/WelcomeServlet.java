
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {

   @Override
   protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
   {
       PrintWriter pw=res.getWriter();
       pw.println("<html>");
       RequestDispatcher rd1=getServletContext().getRequestDispatcher("/head");
       rd1.include(req, res);
       pw.println("<div class=content>");
       RequestDispatcher rd2=getServletContext().getRequestDispatcher("/nav");
       rd2.include(req, res);
       pw.println(" <div class=\"frm\">");
       pw.println("</div>");
       pw.println("</div>");
          pw.println("</html>");
       
       
   }
}
