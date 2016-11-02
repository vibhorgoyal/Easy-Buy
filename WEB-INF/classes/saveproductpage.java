package pack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;  
import java.util.Scanner;
public class saveproductpage {

	public static void main (String[] arg)  {
		Scanner in = new Scanner(System.in);
		String pagelink;
		System.out.println("Enter the product page link");
		pagelink = in.nextLine();
		System.out.println("You entered string "+ pagelink);
		try {
			String review_link = extract(pagelink);
			System.out.println("You review link is "+ review_link);
	    	}
		catch (Exception e) {
	    		e.printStackTrace();
		}
	}
	public static String extract(String htmlname) {
		String userAgent1 = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+".0.2228.0 Safari/536.38";
		Document doc=null;
		while(doc==null){
		try {
			doc = Jsoup.connect(htmlname).timeout(30000).userAgent(userAgent1).get();
			}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}
		Elements link_reviews = doc.select("a[class=a-link-emphasis a-nowrap]");
		String reviews_link = link_reviews.attr("href");
		System.out.println(reviews_link);
		return reviews_link;
	}
	private static char[] toString(int i) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
