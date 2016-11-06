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
		else{
			ArrayList<Pair> positive = new ArrayList<Pair>();
			ArrayList<Pair> negative = new ArrayList<Pair>();
			ArrayList<Pair> neutral = new ArrayList<Pair>();
			//out.println(reviews.size());
			for(String re : reviews)
			{
				float res1 = Test.run(re,"de0b127019a70b21b95e26464d04240aa03b6f4f");
				Pair p = new Pair(res1,re);

				if(res1>0)
				{		
					positive.add(p);
				}
				else if(res1<0)
				{
					negative.add(p);
				}
				else
				{
					neutral.add(p);
				}
			}
			
			Collections.sort(positive,new Comparator<Pair>(){
				@Override public int compare(Pair p1 ,Pair p2)
				{
					float fs = p1.getScore()-p2.getScore();
					if(fs>0)
					return -1;
					else if(fs<0)
					return  1;
					return 0;
				}
			});
			Collections.sort(negative,new Comparator<Pair>(){
				@Override public int compare(Pair p1 ,Pair p2)
				{
					float fs = p1.getScore()-p2.getScore();
					if(fs>0)
					return 1;
					else if(fs<0)
					return  -1;
					return 0;
				}
			});
			int i;
			ArrayList<String> positiv = new ArrayList<String>();
			for(i=0;i<10&&i<positive.size();i++)
			{
				Pair p1 = positive.get(i);
				positiv.add(p1.getReview());
			 	out.println(p1.getScore());
			 	out.println("<br>");
			}
			ArrayList<String> negativ = new ArrayList<String>();
			for(i=0;i<10&&i<negative.size();i++)
			{
				Pair p1 = negative.get(i);
				negativ.add(p1.getReview());
				out.println(p1.getScore());
				out.println("<br>");
			}
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
