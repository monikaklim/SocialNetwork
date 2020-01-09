package it.monikaklim.socialnetwork.dao;

import it.monikaklim.socialnetwork.model.Utente;

public interface LoginDAO {

	Utente findUtente(String user, String pass);	
	
	String registraUtente(Utente utente);
	
	Utente findUtenteByEmail(String mail);
	
	String updatePassword(int idUtente,String pass1);
}
