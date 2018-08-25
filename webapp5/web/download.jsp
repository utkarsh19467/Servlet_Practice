
<%@page import="java.io.File"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .box{
          width:130px;
          height: 130px;
          border: 1px solid#000;
          padding: 5px;
          margin: 10px;
          text-align: CENTER;
        }
        a
        {
            color: tomato;
            margin-left: 10px;
            text-decoration: none;
        }
        a:hover
        {
            color: tomato;
            margin-left: 10px;
            text-decoration: underline;
        }
        </style>
    <body>
        <h1 style="text-align: center">My Family Images</h1>
        <form action="upload.jsp" method="post" enctype="multipart/form-data">
        <div style="width:80%;height: 50px;padding-left: 60%;">UPLOAD IMAGES<input type="file" name="file" style="border:1px solid#000;padding:5px; "><input type="submit" name="sbt" value="UPLOAD"> </div>
        </form>
        <%
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
             %>
        <table style="margin: 30px;">
            <tr>
                <%
                    for(int i=(p-1)*10+1;i<=p*10&&i<=len;i++)
                    {
                       %>
                       <td class="box"><a href="load.jsp?filename=<%=filenames[i-1]%>"><img src="images/<%=filenames[i-1]%>" width:120px height:120px></a></td>
                       <%
                           if(i%5==0&&i%10!=0)
                           {
                          out.println("</tr><tr>");
                           }
                       }
                      %>
            </tr>
            </table>
        <div style="width:80%;padding-left:30%">
            <%
                if(len>10)
                {
                int pages=len/10;
                if(len%10!=0)
                    pages=pages+1;
                if(p>1)
                {
                %>
                <a href="?pages=<%=p-1%>">&lt;&lt;</a>
                <% } %>
                <%
                    for(int i=1;i<=pages;i++)
                    {
                   %>     
                   
                   <a href="?pages=<%=i%>"><%=i%></a>
                   <%
                       }
                   if(p!=pages)
                        { 
                      %>
                      <a href="?pages=<%=p+1 %>">&gt;&gt;</a>
            <%
                }
              } 
             %>
                
            </div>
    </body>
</html>
