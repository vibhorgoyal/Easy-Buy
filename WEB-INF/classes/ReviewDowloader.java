package pack;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
public class ReviewDowloader {
	
	public static ArrayList<String> reviewDownload(String reviewLink) {
		Document doc = null;
		try {
			//count -> to count the no. of reviews in total
			
			//Writing in to file -> Print Writer
			 
			//Select the first link from the original link
			ArrayList<String> reviews = new ArrayList<String>();
			int no_pages = 0, rem = 0;
			int totalReview = 0;
			Elements ul = null;
			Element list = null, link1 = null;
			if(reviewLink == "") {
				return reviews;
			}
			while(doc == null) {	
				doc = Jsoup.connect(reviewLink).followRedirects(true).ignoreContentType(true).header("Accept-Language", "pt-BR,pt;q=0.8").header("Accept-Encoding", "gzip,deflate,sdch").timeout(300000).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+".0.2228.0 Safari/536.38").get();;
				ul = doc.select("span.a-size-medium.totalReviewCount");				
				totalReview = Integer.parseInt(ul.text().toString().replaceAll(",", ""));
				System.out.println(totalReview);
			}
			if(totalReview > 500) totalReview = 500;			
			no_pages = (totalReview) / 10;	
			rem = (totalReview)%10!=0 ? 1:0;
			Document doc1 = null;
			while (doc1 == null)
				doc1 = Jsoup.connect(reviewLink).followRedirects(true).ignoreContentType(true).header("Accept-Language", "pt-BR,pt;q=0.8").header("Accept-Encoding", "gzip,deflate,sdch").timeout(300000).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+".0.2228.0 Safari/536.38").get();		
			Elements link = doc1.select("span.a-size-base.review-text");
			for(Element div: link) {					
				String name = div.text();
				if(!name.equals("Verified Purchase")&&!(name.length()==0)) {	
					reviews.add(name);
				}
			}
			
			System.out.println(no_pages);
			reviewLink = reviewLink+"&pageNumber=";
			for(int i = 2;i<=no_pages+rem;i++) {
				String url2 = reviewLink+i;
				System.out.println(url2);
				doc1 = null;
				while (doc1==null)
					doc1 = Jsoup.connect(url2).followRedirects(true).ignoreContentType(true).header("Accept-Language", "pt-BR,pt;q=0.8").header("Accept-Encoding", "gzip,deflate,sdch").timeout(300000).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+".0.2228.0 Safari/536.38").get();		
				link = doc1.select("span.a-size-base.review-text");
				for(Element div: link) {					
					String name = div.text();
					if(!name.equals("Verified Purchase")&&!(name.length()==0)) {	
						reviews.add(name);
					}
				}
				//System.out.println(reviewLink);
			}
			return reviews;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		ReviewDowloader re = new ReviewDowloader();
		String url = "http://www.amazon.in/product-reviews/B01ABTQD3W/ref=cm_cr_dp_see_all_summary?ie=UTF8&showViewpoints=1&sortBy=helpful";
		
		ArrayList<String> s = re.reviewDownload(url);
		
		int count = 0;
		//System.out.println(s);
		for(String s1: s) {
		 	System.out.println(++count);
		 	System.out.println(s1);
		 	System.out.println("\n");
		}
	}
}
