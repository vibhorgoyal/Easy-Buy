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

		try{
		String productLink = req.getParameter("usr");
		String reviewLink = saveproductpage.extract(productLink);

		int count =0;
		
		ArrayList<String> reviews = ReviewDowloader.reviewDownload(reviewLink);
		if(reviews.size()==0)
		{
			RequestDispatcher requestDispatcher; 
			requestDispatcher = req.getRequestDispatcher("/zero.jsp");
			requestDispatcher.forward(req, res);
		}		
		}
		catch(Exception e) {
			RequestDispatcher requestDispatcher; 
			req.setAttribute("exc",e);
			requestDispatcher = req.getRequestDispatcher("/exception.jsp");
			requestDispatcher.forward(req, res);
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		res.sendRedirect("index.html");
	}
}
