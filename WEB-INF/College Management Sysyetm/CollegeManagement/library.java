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
public class library extends HttpServlet
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
		String registedno=request.getParameter("registedno");
		System.out.println("registedno"+registedno);
out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?> "+ 
"<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.3//EN\" \"http://www.wapforum.org/DTD/wml13.dtd\"> "+"<wml>"+ 
   "<card id=\"card1\" title=\"Mobile Information System\"><p align=\"center\">");
out.println("<br/><br/>");
rs=stmt.executeQuery("select * from library where registedno='"+registedno+"'");
rsmd=rs.getMetaData();
int count=rsmd.getColumnCount();
out.println("<table columns=\"4\"><tr>");
for(int i=1;i<=count;i++)
			{
                 out.println("<td><b>"+rsmd.getColumnName(i)+"</b></td>");
			}
out.println("</tr>");
while(rs.next())
			{ out.println("<tr>");
	                 for(int i=1;i<=count;i++)
					{
	                out.println("<td>"+rs.getObject(i)+"</td>");
					}
                    out.println("</tr>");	       
					
			}
			out.println("</table>");
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

