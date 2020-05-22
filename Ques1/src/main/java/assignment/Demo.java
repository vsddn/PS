package assignment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
  
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the employee: ");
		String lId = sc.next();
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
 
         // Load the input XML document, parse it and return an instance of the
         // Document class.
         Document document = builder.parse(new File("Employees.xml"));
 
         List<Employee> employees = new ArrayList<Employee>();
         
         NodeList nodeList = document.getDocumentElement().getChildNodes();
         Boolean flag=false;
         for (int i = 0; i < nodeList.getLength(); i++) {
              Node node = nodeList.item(i);
 
              if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element elem = (Element) node;
 
                   String id = node.getAttributes().getNamedItem("id").getNodeValue();
                   if(id.equals(lId)) {
                	   flag=true;
                	   String name = elem.getElementsByTagName("name")
                               .item(0).getChildNodes().item(0).getNodeValue();

                	   String city = elem.getElementsByTagName("city").item(0)
                               .getChildNodes().item(0).getNodeValue(); 
                	   
                	   System.out.println("Name: "+name+" "+"City: "+city);
                   }

              }
         }
         
         if(!flag) {
        	 System.out.println("No employee present with the given id.");
         }
 
		
	}

}
