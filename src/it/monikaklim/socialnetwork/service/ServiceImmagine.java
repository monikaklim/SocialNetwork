package it.monikaklim.socialnetwork.service;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import it.monikaklim.socialnetwork.dao.*;
import it.monikaklim.socialnetwork.model.Immagine;
import it.monikaklim.socialnetwork.model.Post;


@Component
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
public void insertImmagine(Immagine immagine) {		
	 imDAO.insertImmagine(immagine);		
	}


@Transactional
public String rinominaImmagine(Immagine immagine, String nome) {
	
	return imDAO.rinominaImmagine(immagine, nome);
}	
	
	
@Transactional
public String deleteImmagine(Immagine immagine) {		
	return imDAO.deleteImmagine(immagine);		
	}	
	
	


@Transactional
public String saveImmagineFromDB(int idImmagine) {
	
	Immagine img = imDAO.selectImmagineById(idImmagine);
	
	byte[] datiImg = img.getDati();

	try{
	    FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\monika.klim\\\\eclipse-workspace\\\\SocialNetwork\\\\WebContent\\\\resources\\\\images\\"+img.getNome()+"."+img.getExtension()); 
	    fos.write(datiImg);
	    fos.close();
	    
	    return "caricata";
	}catch(Exception e){
	    e.printStackTrace();
	    return "non caricata";
	}
	
	
}
	
	
	
	
}
