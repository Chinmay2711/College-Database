import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class subject extends HttpServlet
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	PrintWriter out;
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		try
		{
			ServletContext context=getServletConfig().getServletContext();
           String driver=	context.getInitParameter("driver");
		   String url=context.getInitParameter("url");
		   String uname=context.getInitParameter("uname");
		   String pwd=context.getInitParameter("pwd");
         out=response.getWriter();
            response.setContentType("text/vnd.wap.wml");
			Class.forName(driver);
			con=DriverManager.getConnection(url,uname,pwd);
			stmt=con.createStatement();
		System.out.println("Entered1");	

out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?> "+ 
"<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.3//EN\" \"http://www.wapforum.org/DTD/wml13.dtd\"> "+"<wml>"+ 
   "<card id=\"card1\" title=\"Mobile Information System\"><p align=\"center\">");
out.println("<br/><br/>");
rs=stmt.executeQuery("select distinct(branch) from subject");
out.println("List of branches<select  name=\"branch\">");
		System.out.println("Entered1");	
			while(rs.next())
			{
						System.out.println("Entered1");	
				String s=rs.getString("branch");

                 out.println("<option value=\""+s+"\">"+s+"</option>");
					 
			}
			out.println("</select>");

rs=stmt.executeQuery("select distinct(year) from subject");

out.println("Select Year<select  name=\"year\" >");
while(rs.next())
			{
	                String s=rs.getString("year");
	              out.println("<option value=\""+s+"\">"+s+"</option>");
			}
			
out.println("</select>");

rs=stmt.executeQuery("select distinct(semester) from subject");
out.println("Select Sem<select name=\"sem\">");
while(rs.next())
			{
	             String s=rs.getString("semester");
	             out.println("<option value=\""+s+"\">"+s+"</option>");
			}

out.println("</select><br/><br/>");
out.println("<anchor>");
out.println("<go href=\"subjectserach2\">");
out.println("<postfield name=\"branch\" value=\"$branch\"/>");
out.println("<postfield name=\"year\" value=\"$year\"/>");
out.println("<postfield name=\"sem\" value=\"$sem\"/>");
out.println("</go>	Search</anchor>");
out.println("</p></card></wml>");


		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	
	}

}