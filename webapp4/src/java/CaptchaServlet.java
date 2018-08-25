

import com.itextpdf.text.Font;
import com.mysql.jdbc.util.Base64Decoder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;


@WebServlet(urlPatterns = {"/captcha"})
public class CaptchaServlet extends HttpServlet {

    String captcha="";
    public String getRandomText()
    {
        String res="";
        String req="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int len=req.length();
        for(int i=1;i<=6;i++)
        {
            int index=(int)(len*Math.random());
          captcha+=req.charAt(index);
          res+=req.charAt(index)+" ";
        }
        return res;
    }
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
    {
        try
        {
       BufferedImage img=new BufferedImage(170,30,BufferedImage.TYPE_INT_RGB);
       Graphics g=img.getGraphics();
       g.setColor(Color.WHITE);
       g.drawRect(0, 0, 170, 30);
       g.fillRect(0, 0,170, 30);
      // Font f = new Font("Constantia", Font.NORMAL, 28);
       // g.setFont(f);
       g.setColor(Color.BLACK);
      g.drawString(getRandomText(), 5, 20);
       g.dispose();
        Cookie ck=new Cookie("captcha",encryptText(captcha));
        ck.setMaxAge(15*24*60*60);
        ck.setSecure(true);
        res.addCookie(ck);
       ServletOutputStream sout=res.getOutputStream();
       ImageIO.write(img,"PNG",sout);
            }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String encryptText(String text) throws InvalidKeyException
    {
        String enctext="";
        try
        {
        
            FileInputStream fin=new FileInputStream(getServletContext().getRealPath("/")+"key.txt");
            ObjectInputStream oin=new ObjectInputStream(fin);
            SecretKey k=(SecretKey)oin.readObject();
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,k);
        byte b[]=cipher.doFinal(text.getBytes());
        enctext=new BASE64Encoder().encode(b);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return enctext;
    }
    
}
