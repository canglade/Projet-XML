package Metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
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
	
	public Contact chercherContact(String theNom){
		Contact theContact = null;

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
				
				if(name.equals(theNom)){
					theContact = new Contact(name, contact.getElementsByTagName("Prenom").item(0).getTextContent(), contact.getElementsByTagName("Email").item(0).getTextContent());
				}
				
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		return theContact;
	}
	
	public void modifierData(String theNom, String thePrenom, String theMail){
		
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
			
			Element rootElement = doc.getDocumentElement();
			
			NodeList listContact = rootElement.getChildNodes();
			
			for(int i =0; i < listContact.getLength();i++){
				
				Node child = listContact.item(i);
				Element contact = (Element) child;
				String name = contact.getElementsByTagName("Nom").item(0).getTextContent();
			
				if(name.equals(theNom)){
					System.out.println("Nom trouvé !");
					NodeList listProp = child.getChildNodes();
					
					for(int j =0; j < listProp.getLength();j++){
						Node prop = listProp.item(j);
						
						if(prop.getNodeName().equals("Prenom")){
							prop.setTextContent(thePrenom);
							System.out.println("Change le prenom");
							
						}else if(prop.getNodeName().equals("Email")){
							prop.setTextContent(theMail);
							System.out.println("Change le mail");
						}
					}
				}
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(filepath));
				transformer.transform(source, result);
			
			}	
		} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<Contact> LireData(){
		        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   	
		        ArrayList<Contact> TableContacts = new ArrayList<Contact>();
		        try {
		        final DocumentBuilder builder = factory.newDocumentBuilder();
				final Document document= builder.parse(new File(filepath));
				final Element racine = document.getDocumentElement();
				
			    //élément racine
			    System.out.println("\n*************RACINE************");
			    System.out.println(racine.getNodeName());
				
			    //Personnes
			    final NodeList racineNoeuds = racine.getChildNodes();
			    final int nbRacineNoeuds = racineNoeuds.getLength();
					
			    for (int i = 0; i<nbRacineNoeuds; i++) {
			        if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
			            final Element personne = (Element) racineNoeuds.item(i);
					
			    	    /*
				     * Etape 6 : récupération du nom et du prénom
				     */
				    final Element nom = (Element) personne.getElementsByTagName("Nom").item(0);
				    final Element prenom = (Element) personne.getElementsByTagName("Prenom").item(0);
							
				    //Affichage du nom et du prénom
				    String n=nom.getTextContent();
				    String p=prenom.getTextContent();
				    
				    System.out.println(nom);
				    System.out.println(prenom);
				    
				    Contact c = new Contact(n, p, "mail");
				    TableContacts.add(c);
				
			        }				
			    }			
		        }
		        catch (final ParserConfigurationException e) {
		            e.printStackTrace();
		        }
		        catch (final SAXException e) {
		            e.printStackTrace();
		        }
		        catch (final IOException e) {
		            e.printStackTrace();
		        }		
		        
		        return TableContacts ;
		    }
		
	
}