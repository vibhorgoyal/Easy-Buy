package pack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.ByteArrayInputStream;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.util.ArrayList;
public class Test {

	public static float run(String text,String apikey)	
	{
			AlchemyAPI a = AlchemyAPI.GetInstanceFromString(apikey);
			try{
			Document d = a.TextGetTextSentiment(text);
			String s = getStringFromDocument(d);
			System.out.println(s);
			Node n =d.getFirstChild();
			NodeList nodes = n.getChildNodes();
			Node a1 = nodes.item(9);
			NodeList s1 = a1.getChildNodes();
			Node a2 = s1.item(1);
			String abc=a2.getTextContent();
			System.out.println(a2.getTextContent());
			if(abc.equals("neutral"))
			{
				return 0;

			}
			else
			{
				return 	Float.parseFloat(a2.getTextContent());
			}
			
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				return 0;
			}
	}
public static void main(String[] args) {
		Float  f =  run("Its ultimate in this range","60ad303c39ce16e8e24ac0d78605ddc70f599bd3");
	
		System.out.println(f);
}
}
	
