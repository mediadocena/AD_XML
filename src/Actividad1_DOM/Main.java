package Actividad1_DOM;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Main {

	public static void main(String[] args) {
		
		File file = new File("alumnos.xml");
		
		try {
			  DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			  Document document = dBuild.parse(file);
			  document.getDocumentElement().normalize();
			  NodeList nList = document.getElementsByTagName("alumno");
			  
			  
			  for(int i=0; i<nList.getLength(); i++) {
				  
				  	Node node = nList.item(i);
				  	
				  if(node.getNodeType()==Node.ELEMENT_NODE){
					  
					Element el =(Element) node;
					System.out.println("Nombre: "+el.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Edad: "+el.getElementsByTagName("edad").item(0).getTextContent());
				  
				  }
			  }
			  
			} catch(Exception e) {
			  e.printStackTrace();
			}
	}

}