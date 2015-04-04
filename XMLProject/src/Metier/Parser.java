package Metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Beans.Contact;
 
public class Parser {
	//testCmmit
	private static String filepath = "C:/Users/Christophe/Desktop/file.xml";

 
	// cree le fichier avec l'élément root "Contacts"
	public void creerFichier(){
		
		File file = new File(filepath);
		if(!file.exists()){
		
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = null;
			try {
				docBuilder = docFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Contacts");
			doc.appendChild(rootElement);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = null;
			try {
				transformer = transformerFactory.newTransformer();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void newContact(Contact c) throws FileNotFoundException {
 
	  try {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(filepath);
		
		Element rootElement = doc.getDocumentElement();
		
		// contact elements
		Element contact = doc.createElement("Contact");
		rootElement.appendChild(contact);

		// lastname elements
		Element lastname = doc.createElement("Nom");
		lastname.appendChild(doc.createTextNode(c.getNomContact()));
		contact.appendChild(lastname);
 
		// nickname elements
		Element nickname = doc.createElement("Prenom");
		nickname.appendChild(doc.createTextNode(c.getPrenomContact()));
		contact.appendChild(nickname);
 
		// nickname elements
		Element email = doc.createElement("Email");
		email.appendChild(doc.createTextNode(c.getEmailContact()));
		contact.appendChild(email);
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream(filepath));
		
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (TransformerException | ParserConfigurationException | SAXException | IOException tfe) {
		tfe.printStackTrace();
	  }
	}
	
	public String chercherNom(String nom){
		String theNom = null;

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			
			Element rootElement = doc.getDocumentElement();
			
			NodeList listContact = rootElement.getChildNodes();
			
			for(int i =0; i < listContact.getLength();i++){
				Element contact = (Element) listContact.item(i);
				String name = contact.getElementsByTagName("Nom").item(0).getTextContent();
				
				if(name.equals(nom)){
					theNom = name;
				}
				
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(theNom);
		return theNom;
	}
}