package it.monikaklim.socialnetwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;


@Component
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//insert post
	public void insertPost(Post post) {
	if(post != null) {
		try {
		Session session = sessionFactory.getCurrentSession();
		session.save("Post", post);
		System.out.println( "Post salvato con successo");
		}
		catch(Exception e){
			System.out.println("Errore.");	
		}
	  }
}
	
	
	
	
	
	
	
	
	
	
}
