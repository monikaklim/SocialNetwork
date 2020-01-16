package it.monikaklim.socialnetwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.monikaklim.socialnetwork.model.Utente;


@Repository
public class UtenteDAOImpl implements UtenteDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	//select by username password
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
			
	
	//select by email
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
	public void updatePassword(int idUtente,String pass1) {
			Utente utente = null;						
			try {
			Session session = sessionFactory.getCurrentSession();
			utente = session.get(Utente.class, idUtente);
			if(utente.getRichiestaModificaPsw() == 1) {
		    utente.setPassword(pass1);
			System.out.println( "Password aggiornata con successo.");
			}
			else
				System.out.println("Non è stata richiesta la modifica di questa password");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println( "errore");
		}
		
		
	}

//set richiesta
	public void setRichiestaModificaPsw(int idUtente, int richiesta) {
	
		Utente utente = null;			
			
		try {
		Session session = sessionFactory.getCurrentSession();
		utente = session.get(Utente.class, idUtente);
	    utente.setRichiestaModificaPsw(richiesta);
		System.out.println( "Richiesta aggiornata con successo.");
		}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println( "errore");
	}
	
}

//select by id
	public Utente findUtenteById(int idUtente) {
	Utente utente = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			utente = session.createQuery("from Utente where idUtente = "+idUtente, Utente.class).getSingleResult();

			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Utente non trovato");
			}

		return utente;
	}
	
	
	
	
//select all amici
	
	public List<Utente> selectAllAmici(Utente utente){
		
		List<Utente> amici = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			amici = session.createQuery("from Utente u join amicizia a on a.idUtente = u.idUtente where u.idUtente ="+utente.getIdUtente(), Utente.class).getResultList();

			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Utente non trovato");
			}
		return amici;
			
	}
	
	
	
	
	
	
	
	
	
	
	
}
