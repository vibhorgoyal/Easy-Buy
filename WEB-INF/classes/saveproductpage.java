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

public class saveproductpage  {
	public static void main (String[] arg)  {
		Scanner in = new Scanner(System.in);
		String pagelink;
		System.out.println("Enter the product page link");
		pagelink = in.nextLine();
		System.out.println("You entered string "+ pagelink);
		try {
System.out.println("0st");
	 		Connection connection = null;
	    		Connection.Response response = null;
	    		Document document = null;
	    		String userAgent1 = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+".0.2228.0 Safari/536.38";
System.out.println("1st");
			connection = Jsoup.connect(pagelink).userAgent(userAgent1);
System.out.println("2st");
			response = connection.execute();
System.out.println("3st");
			document = connection.get();
System.out.println("4st");
			
			FileWriter out = new FileWriter(new File("./downloaded_product_page.html"));
		    	out.write(document.toString());
		    	out.flush();
		    	out.close();
		    	System.out.println("File for page written successfully..");
		}
		catch (Exception e) {
	    		e.printStackTrace();
		}
	}
	private static char[] toString(int i) {
		return null;
	}
}
