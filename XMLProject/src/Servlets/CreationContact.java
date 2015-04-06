package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Contact;
import Metier.Parser;

public class CreationContact extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
	   String nom = request.getParameter( "nomContact" );
       String prenom = request.getParameter( "prenomContact" );
       String email = request.getParameter( "emailContact" );

       String message;
        
       if ( nom.trim().isEmpty() || prenom.trim().isEmpty() ) {
           message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"CreationContact.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un contact.";
       } else {
           message = "Contact créé avec succès !";
       }
       
       Contact contact = new Contact(nom, prenom, email);
        
       Parser parser = new Parser();
        
       parser.creerFichier();
       parser.newContact(contact);
        
       Contact raoul = parser.chercherContact("raoul");
       
       System.out.println(raoul.getNomContact() + " " + raoul.getPrenomContact() + " " + raoul.getEmailContact());
       

       parser.modifierData("raoul", "nouveauNom", "nouveauMail@hotmail.fr");
	
       
       Contact newRaoul = parser.chercherContact("raoul");

       System.out.println(newRaoul.getNomContact() + " " + newRaoul.getPrenomContact() + " " + newRaoul.getEmailContact());
       
       ArrayList<Contact> T = parser.LireData();
       ArrayList<String> noms = new ArrayList<String>();
        /* Ajout du bean et du message à l'objet requête */
       
       for(Contact c : T){
    	   noms.add(c.getNomContact());
       }
       
       
       request.setAttribute( "contacts", noms );
    	   
        //request.setAttribute( "contact", contact );
        //request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        //this.getServletContext().getRequestDispatcher( "/afficherContact.jsp" ).forward( request, response );
       this.getServletContext().getRequestDispatcher( "/afficherContact.jsp" ).forward( request, response );
	}
}