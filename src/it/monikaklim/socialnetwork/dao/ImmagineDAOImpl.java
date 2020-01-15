package it.monikaklim.socialnetwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;


@Component
public class ImmagineDAOImpl implements ImmagineDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	
	//insert
	public void insertImmagine(Immagine immagine) {
	if(immagine != null) {
		try {
		Session session = sessionFactory.getCurrentSession();
		session.save("Immagine", immagine);
		System.out.println( "Immagine salvata con successo");
		}
		catch(Exception e){
			System.out.println("Errore.");	
		}
	  }
		
		}
	
	
	
	//select immagine by post
	public Immagine selectImmagineByPost(Post p) {
		Immagine immagine = null;
		if(p.getImmagine() == null) {
		System.out.println("Il post non ha un'immagine");		
		}
		else {
		int idImmagine = p.getImmagine().getIdImmagine();
		
			
		try {
					Session session = sessionFactory.getCurrentSession();

					immagine= session.createQuery("from Immagine where idImmagine = "+idImmagine, Immagine.class).getSingleResult();

					}
					catch(Exception e) {
						System.out.println("Immagine non trovata");
					}
		}
		return immagine;
		
		}	


	
	
	//select immagine by id
	public Immagine selectImmagineById(int idImmagine) {
		Immagine immagine = null;
			
		try {
					Session session = sessionFactory.getCurrentSession();

					immagine= session.createQuery("from Immagine where idImmagine = "+idImmagine, Immagine.class).getSingleResult();

					}
					catch(Exception e) {
						System.out.println("Immagine non trovata");
					}
		
		return immagine;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//delete
		public String deleteImmagine(Immagine immagine) {
			String esito = "";		
			try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(immagine);
			esito = "Immagine eliminata con successo";
			}
			catch(Exception e){
			esito = "Errore.";	
			}
			return esito;
			}
	
	//update
		
		public String rinominaImmagine(Immagine immagine, String nome) {
			String esito = "";		
			try {
			Session session = sessionFactory.getCurrentSession();
			Immagine imm = session.get(Immagine.class,immagine.getIdImmagine());
			imm.setNome(nome);
			System.out.println("Immagine rinominata con successo.");
			}
			catch(Exception e){
			esito = "Errore.";	
			}
			return esito;
			}
	
	


	
	
	
	
	
	
}
