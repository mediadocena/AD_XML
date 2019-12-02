package Actividad1_SAX;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // TODO Auto-generated method stub

        SAXParserFactory f=SAXParserFactory.newInstance();
        SAXParser saxPar=f.newSAXParser();

        DefaultHandler handle=new DefaultHandler() {
            boolean nombreb=false;
            boolean edadb=false;

            public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
                if(qName.equalsIgnoreCase("nombre"))
                    nombreb=true;
                if(qName.equalsIgnoreCase("edad"))
                    edadb=true;
            }

            public void endElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {

            }

            public void characters(char ch[], int start, int lenght) throws SAXException {
                if(nombreb) {
                    System.out.println("Nombre: "+new String(ch,start,lenght));
                    nombreb=false;
                }
                if(edadb) {
                    System.out.println("Edad: "+new String(ch,start,lenght));
                    edadb=false;
                }
            }
        };

        saxPar.parse("alumnos.xml",handle);
    }

}
	        