
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/nav"})
public class NavigationServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
    {
        PrintWriter pw=res.getWriter();
        pw.println("	" +
                "<div class=content>\n" +
                "	  <div class=\"nav\">\n" +
                "		<div class=\"navcon\">Control Brightness</div>\n" +
                "		<div class=\"navcon\">Control Contrast</div>\n" +
                "		<div class=\"navcon\">Resize Image</div>\n" +
                "		<div class=\"navcon\">Add Text</div>\n" +
                "		<div class=\"navcon\"><a href='change' style='text-decoration:none;color:#000;'>Change Password</a></div>\n" +
                "	  </div>\n");
    }
}
