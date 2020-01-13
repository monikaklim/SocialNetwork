package it.monikaklim.socialnetwork.dao;

import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;

public interface ImmagineDAO {

	String insertImmagine(Immagine immagine);
	
	Immagine selectImmagineByPost(Post p);
	
	String deleteImmagine(Immagine immagine);
	
	String rinominaImmagine(Immagine immagine, String nome);
	
}
