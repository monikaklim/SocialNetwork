package it.monikaklim.socialnetwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.monikaklim.socialnetwork.model.Utente;


@Repository
public class LoginDAOImpl implements LoginDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Utente findUtente(String user, String pass) {
		Utente utente = null;	
		try {
					Session session = sessionFactory.getCurrentSession();

					utente = session.createQuery("from Utente where username = '"+user+"' and password = '"+pass+"'", Utente.class).getSingleResult();

					}
					catch(Exception e) {
						e.printStackTrace();
					}
		return utente;
		}	
			
	
	
	public String registraUtente(Utente utente) {
		String esito = "";	
			
		try {
		Session session = sessionFactory.getCurrentSession();
		session.save(utente);
		esito = "Registrazione avvenuta con successo.";

		}
		catch(Exception e){
		esito = "Errore.";	
		}

		return esito;
		}
	
	
	
	
	
	
	
	
}
