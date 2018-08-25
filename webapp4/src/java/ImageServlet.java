
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/img"})
public class ImageServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
  {
      try
      {
      String s=req.getParameter("email");
      Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/photo_editor","root","123");
            //Statement st = c.createStatement();
            PreparedStatement pst=c.prepareStatement("select * from users where email=? and password=?");
            pst.setString(1, s);
            ResultSet rs=pst.executeQuery();
            rs.next();
            Blob b=rs.getBlob("profilepicture");

            rs.close();
            pst.close();
            c.close();
             InputStream in=b.getBinaryStream();
            BufferedImage img=ImageIO.read(in);
            ImageIO.write(img, "PNG", res.getOutputStream());
            
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
  }
}
