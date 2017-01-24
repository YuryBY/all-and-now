package com.epam.allandnow.transformations;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Main {
  public static void main( String[] args ) throws Exception {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
    // initialize StreamResult with File object to save to file
    StreamResult result = new StreamResult( new StringWriter() );

    File fXmlFile = new File( "c://Users/YURY_BAKHMUTSKI/Desktop/xml.aspx.xml" );
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse( fXmlFile );

    DOMSource source = new DOMSource( doc );
    transformer.transform( source, result );
    String xmlString = result.getWriter().toString();
    System.out.println( xmlString );
  }
}
