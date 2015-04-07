package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Contact;
import Metier.Parser;


public class AfficherContacts extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	Parser parser = new Parser();
	parser.creerFichier();
	ArrayList<Contact> T = parser.LireData();
    request.setAttribute( "contacts", T );
	/* Transmission à la page JSP en charge de l'affichage des données */
    this.getServletContext().getRequestDispatcher( "/AfficherContacts.jsp" ).forward( request, response );
	}

}
