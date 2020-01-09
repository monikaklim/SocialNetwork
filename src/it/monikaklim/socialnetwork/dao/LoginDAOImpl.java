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
	
	//select where username password
	public Utente findUtente(String user, String pass) {
		Utente utente = null;	
		try {
					Session session = sessionFactory.getCurrentSession();

					utente = session.createQuery("from Utente where username = '"+user+"' and password = '"+pass+"'", Utente.class).getSingleResult();

					}
					catch(Exception e) {
						System.out.println("Utente non trovato");
					}
		return utente;
		}	
			
	
	//select where email
	public Utente findUtenteByEmail(String mail){
		Utente utente = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			utente = session.createQuery("from Utente where email = '"+mail+"'", Utente.class).getSingleResult();

			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Utente non trovato");
			}

		return utente;
	}
	
	
	
	
	//insert
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


//update password
	public String updatePassword(int idUtente,String pass1) {
	
			//int id = Integer.parseInt(idUtente);
			Utente utente = null;		
			String esito = "";	
				
			try {
			Session session = sessionFactory.getCurrentSession();
			utente = session.get(Utente.class, idUtente);
		    utente.setPassword(pass1);
			esito = "Password aggiornata con successo.";
			
		}
		catch(Exception e) {
			e.printStackTrace();
			esito = "errore";
		}
		
		
		
		return esito;
	}
	
	
	
	
	
	
	
	
}
