import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Login extends HttpServlet
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	PrintWriter out;
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		RequestDispatcher rd;
		try
		{
			ServletContext context=getServletConfig().getServletContext();
           String driver=	context.getInitParameter("driver");
		   String url=context.getInitParameter("url");
		   String uname=context.getInitParameter("uname");
		   String pwd=context.getInitParameter("pwd");
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
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
out.println("<u>Exam Schedule</u>");
out.println("<br/><br/>");
rs=stmt.executeQuery("select * from userregistration");
while(rs.next())
			{
                if(rs.getString("uname").equals(username) && rs.getString("pwd").equals(password))
				{
					//out.println("welcome");
                      rd=context.getRequestDispatcher("/home.wml");
					  rd.forward(request,response);
				}
			}

out.println("Invalid Username and Password");
rd=context.getRequestDispatcher("/login.wml");
rd.include(request,response);

out.println("</p></card></wml>");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	
	}

}