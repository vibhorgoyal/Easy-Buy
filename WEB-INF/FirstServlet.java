package pack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class FirstServlet extends HttpServlet {

	public static void main(String[] args) {
		System.out.println("hello world");	
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String productLink = req.getParameter("usr");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		res.sendRedirect("index.html");
	}
}
