package Beans;

import java.util.ArrayList;

public class Contact {

	private String nomContact;
	private String prenomContact;
	private String emailContact;
	ArrayList<Contact> mesContacts = new ArrayList<Contact>();
	
	public Contact(String nomContact, String prenomContact,
			String emailContact) {
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.emailContact = emailContact;
	}
	
	public ArrayList<Contact> getContacts(){
		return mesContacts;
	}
	
	public String getNomContact() {
		return nomContact;
	}
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	public String getPrenomContact() {
		return prenomContact;
	}
	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}
	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	
	public void ajouterContact(Contact c){
		mesContacts.add(c);
	}
	
	public void suppContact(Contact c){
		mesContacts.remove(c);
	}
	
}
