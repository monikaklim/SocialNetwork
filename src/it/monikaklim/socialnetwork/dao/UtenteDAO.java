package it.monikaklim.socialnetwork.dao;

import java.util.List;

import it.monikaklim.socialnetwork.model.Utente;

public interface UtenteDAO {

	Utente findUtente(String user, String pass);	
	
	String registraUtente(Utente utente);
	
	Utente findUtenteByEmail(String mail);
	
	void updatePassword(int idUtente,String pass1);
	
	void setRichiestaModificaPsw(int idUtente, int richiesta);
	
	 Utente findUtenteById(int idUtente);
	 List<Utente> selectAllAmici(Utente utente);
}
