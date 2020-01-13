package it.monikaklim.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.monikaklim.socialnetwork.dao.*;
import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;


@Service
public class ServiceImmagine {


@Autowired
private ImmagineDAOImpl imDAO;
	
	

@Transactional
public Immagine selectImmagineByPost(Post p) {		
	
	if(imDAO.selectImmagineByPost(p) == null)
	return 	null;
	else
		return imDAO.selectImmagineByPost(p);
	}


@Transactional
public String insertImmagine(Immagine immagine) {		
	return imDAO.insertImmagine(immagine);		
	}


@Transactional
public String rinominaImmagine(Immagine immagine, String nome) {
	
	return imDAO.rinominaImmagine(immagine, nome);
}	
	
	
@Transactional
public String deleteImmagine(Immagine immagine) {		
	return imDAO.deleteImmagine(immagine);		
	}	
	
	
	
	
	
	
}
