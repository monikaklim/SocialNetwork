package it.monikaklim.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import it.monikaklim.socialnetwork.dao.*;
import it.monikaklim.socialnetwork.model.*;

@Component
public class ServicePost {

@Autowired
PostDAOImpl postDAO;
	
	
@Transactional
public void insertPost(Post post) {		
	 postDAO.insertPost(post);		
	}	
	
	
@Transactional
public void deletePost(Post post) {		
	 postDAO.deletePost(post);	
	}	
	

@Transactional
public void updatePost(Post post,String contenuto) {		
	 postDAO.updatePost(post, contenuto);	
	}	
	
@Transactional
public void selectPost(int idPost) {		
	 postDAO.selectPost(idPost);	
	}	
	

@Transactional
public void selectAllPost(Utente utente) {		
 postDAO.selectAllPost(utente);	
}	
	
}
