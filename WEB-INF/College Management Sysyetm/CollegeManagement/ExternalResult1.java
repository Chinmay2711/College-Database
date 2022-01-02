package CollegeManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
public class ExternalResult1 extends HttpServlet
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
out.println("External Results");
out.println("<br/><br/>");
out.println("Results for HallTicketNo:<b> "+results+"</b>");
rs=stmt.executeQuery("select * from results where hallticketno="+results);
rsmd=rs.getMetaData();
int count=rsmd.getColumnCount();
out.println("<table columns=\"4\">");

                     out.println("<tr>");
                     out.println("<td><b>SUBJECT NAME</b></td>");
                     out.println("<td><b>INTERNAL MARKS</b></td>");			
                     out.println("<td><b>EXTERNAL MARKS</b></td>");			
                     out.println("<td><b>TOTAL MARKS</b></td>");			
                     out.println("</tr>");
			while(rs.next())
			{
                   
				   out.println("<tr>");
				   out.println("<td>"+rs.getString("subject")+"</td>");
				   int inter=rs.getInt("internalmarks");
				   int ext=rs.getInt("externalmarks");
                   int total=inter+ext;
				   out.println("<td>"+inter+"</td>");
				   out.println("<td>"+ext+"</td>");
				   out.println("<td>"+total+"</td>");
				   out.println("</tr>");
			}
			out.println("</table>");



out.println("<a href=\"home.wml\">Home</a>");
out.println("</p></card></wml>");


		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	
	}

}