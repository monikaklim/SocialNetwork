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
	
	
	
}
