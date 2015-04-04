package Plurals;

import java.util.ArrayList;

import Beans.Contact;

public class ListeContact {

	ArrayList<Contact> mesContacts = new ArrayList<Contact>();

	public ListeContact(ArrayList<Contact> mesContacts) {
		this.mesContacts = mesContacts;
	}
	
	public void newContact(Contact c){
		mesContacts.add(c);
	}
	
	public void suppContact(Contact c){
		mesContacts.remove(c);
	}
	
	public Contact chercherParNom(String nom){
		Contact monContact = null;
		
		for(Contact c : mesContacts){
			if(c.getNomContact() == nom){
				monContact = c;
			}
		}
		
		return monContact;
	}
	
	public Contact searchContact(Contact c){
		if(mesContacts.contains(c)){
			return c;
		}else{
			return null;
		}
	}
	
	//retourne la liste des noms de chaque contact de ce contact
	public ArrayList<String> afficherLiens(Contact c){
		ArrayList<String> mesLiens = new ArrayList<String>(); 
		
		if(mesContacts.contains(c)){
			for(Contact lien : c.getContacts()){
				mesLiens.add(lien.getNomContact());
			}
		}
		
		return mesLiens;
	}
}
	
	
