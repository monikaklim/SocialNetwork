package it.monikaklim.socialnetwork.dao;

import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;

public interface ImmagineDAO {

	void insertImmagine(Immagine immagine);
	
	Immagine selectImmagineByPost(Post p);
	
	Immagine selectImmagineById(int idImmagine);
	
	String deleteImmagine(Immagine immagine);
	
	String rinominaImmagine(Immagine immagine, String nome);
	
}
