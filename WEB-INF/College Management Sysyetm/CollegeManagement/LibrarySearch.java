package CollegeManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Locale;

import javax.servlet.*;
import javax.servlet.http.*;
public class LibrarySearch extends HttpServlet
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	PrintWriter out;
	ResultSetMetaData rsmd;
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
		String registedno=request.getParameter("result");
	
out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?> "+ 
"<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.3//EN\" \"http://www.wapforum.org/DTD/wml13.dtd\"> "+"<wml>"+ 
   "<card id=\"card1\" title=\"Mobile Information System\"><p align=\"center\">");
out.println("<br/><br/>");
out.println("Library  Results");
out.println("<br/><br/>");
rs=stmt.executeQuery("select * from library where hallticketno='"+registedno+"'");
rsmd=rs.getMetaData();
int count=rsmd.getColumnCount();
if(rs.next())
			{
out.println("<table columns=\"4\"><tr>");
                 out.println("<td><b>BOOKID</b></td>");
                 out.println("<td><b>BOOKNAME</b></td>");
                 out.println("<td><b>AUTHOR</b></td>");				 
                 out.println("<td><b>DUEDATE</b></td>");
				 out.println("</tr>");
				  out.println("<tr>");
	                out.println("<td>"+rs.getString("bookid")+"</td>");
	                out.println("<td>"+rs.getString("bookname")+"</td>");
	                out.println("<td>"+rs.getString("bookauthor")+"</td>");
					java.util.Date d=rs.getDate("duedate");
                    java.text.SimpleDateFormat s=new java.text.SimpleDateFormat("dd MMM yyyy",Locale.US);
					String duedate=s.format(d);
	                out.println("<td>"+duedate+"</td>");					
                    out.println("</tr>");	     
while(rs.next())
			{       out.println("<tr>");
	                out.println("<td>"+rs.getString("bookid")+"</td>");
	                out.println("<td>"+rs.getString("bookname")+"</td>");
	                out.println("<td>"+rs.getString("bookauthor")+"</td>");
					d=rs.getDate("duedate");
                    java.text.SimpleDateFormat s1=new java.text.SimpleDateFormat("dd MMM yyyy",Locale.US);
					String ddate=s1.format(d);
	                out.println("<td>"+ddate+"</td>");					
                    out.println("</tr>");	       
					
			}
			out.println("</table>");
			}
			else
			{
				out.println("<br/>");
				out.println("<b>NO RECORD IS AVAILABLE</b>");

			}
			out.println("<br/><br/>");
			out.println("<a href=\"home.wml\">Home</a>");
			out.println("</p></card></wml>");
			
			
			stmt.close();
			rs.close();
			con.close();
		}
		catch(Exception e)
		{
        System.out.println(e);
		}
	}
}

