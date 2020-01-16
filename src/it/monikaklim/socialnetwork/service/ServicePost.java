package it.monikaklim.socialnetwork.service;

import java.util.List;

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
public void updatePost(Post post) {		
	 postDAO.updatePost(post);	
	}	
	
@Transactional
public Post selectPost(int idPost) {		
	return postDAO.selectPost(idPost);	
	}	
	

@Transactional
public List<Post> selectAllPost(Utente utente) {		
return postDAO.selectAllPost(utente);	
}	
	
}
