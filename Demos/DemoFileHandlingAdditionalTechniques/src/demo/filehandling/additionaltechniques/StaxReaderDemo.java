package demo.filehandling.additionaltechniques;

import javax.xml.stream.*;
import java.io.*;

public class StaxReaderDemo {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            System.out.println("Please enter XML filename: ");
            String xmlFilename = br.readLine();

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(new FileReader(xmlFilename));

            int authorCount = 0;
            String elementName = "";
            
            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                
                switch (event) {
                
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = parser.getLocalName();
                        if (elementName.equals("book")) {
                            authorCount = 0;
                        } else if (elementName.equals("author")) {
                            authorCount++;
                        }
                        break;
                    
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = parser.getLocalName();
                        if (elementName.equals("book")) {
                            System.out.println(", Author count: " + authorCount);
                        } 
                        break;
                    
                    case XMLStreamConstants.CHARACTERS:
                        if (elementName.equals("title")) {
                            String text = parser.getText().trim();
                            if (text.length() != 0) {
                                System.out.print(" Book title: " + text);
                            }
                        }
                        break;
                } 
            } 
            parser.close();

        } catch (XMLStreamException ex) {
            System.out.println("XML stream exception occurred: " + ex.getMessage());

        } catch (Exception ex) {
            System.out.println("General exception occurred: " + ex.getMessage());
        }
    }
}
