package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Element;

import Beans.Contact;
import Metier.Parser;

public class CreationContact extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String nom = request.getParameter( "nomContact" );
        String prenom = request.getParameter( "prenomContact" );
        String email = request.getParameter( "emailContact" );

        String message;
        
       if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"CreationContact.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un contact.";
        } else {
            message = "Contact cr�� avec succ�s !";
        }
       
        Contact contact = new Contact(nom, prenom, email);
        
        Parser parser = new Parser();
        
        parser.creerFichier();
        parser.newContact(contact);
        
        Element e = parser.chercherContact("raoul");
        System.out.println("test" + e.getAttribute("Nom"));
        System.out.println("test" + e.getAttribute("Nom"));
		

        /* Ajout du bean et du message � l'objet requ�te */
        request.setAttribute( "contact", contact );
        request.setAttribute( "message", message );

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( "/afficherContact.jsp" ).forward( request, response );
       
	}
}