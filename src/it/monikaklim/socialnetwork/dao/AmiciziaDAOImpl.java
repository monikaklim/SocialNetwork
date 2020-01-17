package it.monikaklim.socialnetwork.dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.monikaklim.socialnetwork.model.*;

@Component
public class AmiciziaDAOImpl implements AmiciziaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	//stato richiesta = 0
	public void richiediAmicizia(Utente loggato, Utente utente2) {
		Amicizia amicizia = null;
		int id1 =loggato.getIdUtente();
		int id2 = utente2.getIdUtente();
		
		if(id1 > id2)
	  amicizia = new Amicizia(utente2,loggato.getIdUtente(),0,id2);
		
		if(id2>id1)
	 amicizia = new Amicizia(loggato,utente2.getIdUtente(),0,id1);	
			
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(amicizia);
			System.out.println( "Richiesta inserita con successo.");

			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println( "Errore");
			}	
	}


	//stato richiesta = 1
	public void accettaAmicizia(Utente loggato, Utente richiedente) {					
					try {
					Session session = sessionFactory.getCurrentSession();
					Amicizia amicizia = session.createQuery("from Amicizia where idUtente1 ="+loggato.getIdUtente() + " or idUtente1 = " + richiedente.getIdUtente()+ " and idUtente2 = "+ richiedente.getIdUtente() + " or idUtente2 = "+ loggato.getIdUtente(), Amicizia.class).getSingleResult();
					amicizia.setStatoRichiesta(1);
					amicizia.setUtenteRichiesta(loggato.getIdUtente());
				  
					System.out.println( "Richiesta accettata.");
					}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println( "errore");
				}
			
			}
	

	//stato richiesta = 2
	public void rifiutaAmicizia(Utente loggato, Utente richiedente) {					
					try {
					Session session = sessionFactory.getCurrentSession();
					Amicizia amicizia = session.createQuery("from Amicizia where idUtente1 ="+loggato.getIdUtente() + " or idUtente1 = " + richiedente.getIdUtente()+ " and idUtente2 = "+ richiedente.getIdUtente() + " or idUtente2 = "+ loggato.getIdUtente(), Amicizia.class).getSingleResult();
					amicizia.setStatoRichiesta(0);
					amicizia.setUtenteRichiesta(loggato.getIdUtente());
				  
					System.out.println( "Richiesta rifiutata.");
					}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println( "errore");
				}
			}
	
	
	
	
		

	//vedi relazione tra due utenti
	public Amicizia selectAmicizia(Utente loggato, Utente utente2) {
		Amicizia amicizia = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			 amicizia = session.createQuery("from Amicizia where idUtente1 ="+loggato.getIdUtente() + " or idUtente1 = " + utente2.getIdUtente()+ " and idUtente2 = "+ utente2.getIdUtente() + " or idUtente2 = "+ loggato.getIdUtente(), Amicizia.class).getSingleResult();

			}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println( "errore");
		}
		return amicizia;
	}


	
	//select all amici di un utente
	
		public List<Amicizia> selectAllAmici(Utente utente){
			
			List<Amicizia> amici = null;
			
			try {
				Session session = sessionFactory.getCurrentSession();
				amici = session.createQuery("from  amicizia   where idUtente1 ="+utente.getIdUtente() + " or idUtente2 ="+utente.getIdUtente() + " and statoRichiesta = 1 ", Amicizia.class).getResultList();

				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Nessun amico trovato");
				}
			return amici;
				
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
}
