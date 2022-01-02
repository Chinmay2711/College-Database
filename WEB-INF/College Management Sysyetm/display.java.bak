import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class display extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/vnd.wap.wml");
		PrintWriter pw=res.getWriter();
		pw.println("<?xml version=\"1.0\" encoding=\"utf-8\"?> "+ 
"<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.3//EN\" \"http://www.wapforum.org/DTD/wml13.dtd\"> "+"<wml><h1> welcome</h1></wml>");
	}
}
