package it.monikaklim.socialnetwork.dao;

import java.util.List;

import it.monikaklim.socialnetwork.model.Post;
import it.monikaklim.socialnetwork.model.Utente;

public interface PostDAO {

	
	void insertPost(Post post);
	
	void updatePost(Post post, String contenuto);
	
	List<Post> selectAllPost( Utente utente);
	
	Post selectPost( int idPost);
	
	void deletePost(Post post);
	
	
	
	
}
