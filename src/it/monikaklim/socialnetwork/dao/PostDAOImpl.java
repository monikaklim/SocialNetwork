package it.monikaklim.socialnetwork.dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.monikaklim.socialnetwork.model.*;


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
	
	
	//delete post
	public void deletePost(Post post) {
	if(post != null) {
		try {
		Session session = sessionFactory.getCurrentSession();
		session.delete("Post", post);
		System.out.println( "Post eliminato con successo");
		}
		catch(Exception e){
			System.out.println("Errore.");	
		}
	  }
}
		
	//select 
	public Post selectPost( int idPost){
		Post post = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			post = session.createQuery("from Post where idPost = "+idPost , Post.class).getSingleResult();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Post non trovato");
			}

		return post;
	}
	
	//select all utente post dal più recente
	
	public List<Post> selectAllPost( Utente utente){
		List<Post> post = null;
	
		try {
			Session session = sessionFactory.getCurrentSession();
			post = session.createQuery("from Post where idUtente = "+utente.getIdUtente() + " order by idUtente" , Post.class).getResultList();
			Collections.reverse(post);
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Nessun post trovato");
			}

		return post;
	}
	

	//update post
	public void updatePost(Post post) {
	if(post != null) {
		try {
		Session session = sessionFactory.getCurrentSession();
		Post p =session.get(Post.class, post.getIdPost());
		p.setTesto(post.getTesto());
		session.update(p);
		System.out.println( "Post modificato con successo");
		}
		catch(Exception e){
			System.out.println("Errore.");	
		}
	  }
	}
	
	
	
}
