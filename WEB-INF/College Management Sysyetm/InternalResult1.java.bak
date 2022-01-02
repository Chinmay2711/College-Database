import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class InternalResult1 extends HttpServlet
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	PrintWriter out;
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		try
		{
			ServletContext context=getServletConfig().getServletContext();
			String results=request.getParameter("result");
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
out.println("Internal Results");
out.println("<br/><br/>");
out.println("Results for HallTicketNo:<b> "+results+"</b>");
rs=stmt.executeQuery("select * from results where hallticketno="+results);
rsmd=rs.getMetaData();
int count=rsmd.getColumnCount();

if(rs.next())
			{
out.println("<table columns=\"2\">");
                     out.println("<tr>");
                     out.println("<td><b>SUBJECT NAME</b></td>");
                     out.println("<td><b>MARKS</b></td>");			
                     out.println("</tr>");
					 out.println("<tr>");
				   out.println("<td>"+rs.getString("subject")+"</td>");
				   out.println("<td>"+rs.getString("internalmarks")+"</td>");
				   out.println("</tr>");
			while(rs.next())
			{
                   out.println("<tr>");
				   out.println("<td>"+rs.getString("subject")+"</td>");
				   out.println("<td>"+rs.getString("internalmarks")+"</td>");
				   out.println("</tr>");
			}
			out.println("</table>");
			}
			else
			{
				out.println("<br>");
				out.println("<b>NO RECORD IS AVAILABLE</b>");
			}

out.println("<br/><br/>");
out.println("<a href=\"home.wml\">Home</a>");
out.println("</p></card></wml>");


		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	
	}

}