package it.monikaklim.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.monikaklim.socialnetwork.dao.LoginDAOImpl;
import it.monikaklim.socialnetwork.model.Utente;

@Service
public class ServiceLogin {

	@Autowired
	private LoginDAOImpl loginDAO;	
	
	
	@Transactional
	public String findUtente(String user, String pass) {
		
		
		if(loginDAO.findUtente(user,pass) == null)
		{
			return  "Username errato o password errata";
		}
		else {
			
			return "Trovato";
		}
			
		}	
	
	
	
}
