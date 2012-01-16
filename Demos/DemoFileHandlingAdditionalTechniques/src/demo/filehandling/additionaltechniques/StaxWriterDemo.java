package demo.filehandling.additionaltechniques;

import javax.xml.stream.*;
import java.io.*;

public class StaxWriterDemo {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            System.out.println("Please enter XML filename: ");
            String xmlFilename = br.readLine();

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(xmlFilename));

            writer.writeComment("Document created electronically.");
            writer.writeStartDocument();

            writer.writeStartElement("Employee");
            writer.writeNamespace(null, "urn:olsen-software");
            writer.writeAttribute("EmpId", "007");
            
            writer.writeStartElement("FirstName");
            writer.writeCharacters("James");
            writer.writeEndElement();
            
            writer.writeStartElement("LastName");
            writer.writeCharacters("Bond");
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();           

            writer.flush();
            writer.close();

            System.out.println("Created " + xmlFilename);
            
        } catch (XMLStreamException ex) {
            System.out.println("XML stream exception occurred: " + ex.getMessage());

        } catch (Exception ex) {
            System.out.println("General exception occurred: " + ex.getMessage());
        }
    }
}
