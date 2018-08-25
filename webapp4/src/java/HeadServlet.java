
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/head"})
public class HeadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
    {
       
        String s=req.getParameter("name");
         if(s==null)
        {
            Cookie ck[]=req.getCookies();
            for(Cookie c:ck)
            {
                if(c.getName().equals("name"))
                {
                    s=c.getValue();
                }
            }}
             
        
      
       
        
        PrintWriter pw=res.getWriter();
        pw.println("<link href=\"kajol.css\" rel=\"stylesheet\">\n" +
"	<!--<script src=\"abc.js\"></script>-->\n" +
"	<div class=\"head\">\n" +
"		<img src=\"images/logo.png\" style=\"margin-left: 20px;float:left;\"/>\n" +
"                <div class=\"usrinf\">\n" +
"                    <div style=\"font-family:Verdana, Arial, Helvetica, sans-serif;font-size:15px;float:left;margin-right:10px\">Hi "+s+"</div>\n" +
"                    <div style=\"float:left;font-family:\"Courier New\", Courier, monospace;margin-left: 10px\"><a href=\"\" style=\"text-decoration:none;color:#0000FF\">Logout</a></div>	\n" +
"                </div>\n" +
"	</div>\n" +
"	");
        
       
        
    }

}
