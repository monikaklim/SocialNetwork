package it.monikaklim.socialnetwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;


@Repository
public class ImmagineDAOImpl implements ImmagineDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	
	//insert
	public String insertImmagine(Immagine immagine) {
		String esito = "";		
		try {
		Session session = sessionFactory.getCurrentSession();
		session.save(immagine);
		esito = "Immagine salvata con successo";
		}
		catch(Exception e){
		esito = "Errore.";	
		}
		return esito;
		}
	
	
	
	//select immagine
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
