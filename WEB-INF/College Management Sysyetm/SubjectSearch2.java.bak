import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class SubjectSearch2 extends HttpServlet
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
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String sem=request.getParameter("sem");
System.out.println("branch"+branch+"year"+year+"sem"+sem);
out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?> "+ 
"<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.3//EN\" \"http://www.wapforum.org/DTD/wml13.dtd\"> "+"<wml>"+ 
   "<card id=\"card1\" title=\"Mobile Information System\"><p align=\"center\">");
out.println("<br/><br/>");
rs=stmt.executeQuery("select * from subject where branch='"+branch+"' and year='"+year+"' and semester='"+sem+"'");
rsmd=rs.getMetaData();
int count=rsmd.getColumnCount();
out.println("Results for <b>"+year+"</b>year <b>"+sem+"</b>sem <b>"+branch+"</b>Engineering");
out.println("<br/><br/>");
out.println("<table columns=\"2\"><tr>");

                 out.println("<td><b>SUBJECT NAME</b></td>");
                 out.println("<td><b>PRACTICALS</b></td>");			
out.println("</tr>");
while(rs.next())
			{ out.println("<tr>");
	              out.println("<td>"+rs.getString("subname")+"</td>");
				  out.println("<td>"+rs.getString("practicals")+"</td>");
				out.println("</tr>");	       					
			}
			out.println("</table>");
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

