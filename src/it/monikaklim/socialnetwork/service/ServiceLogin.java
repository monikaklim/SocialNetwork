package it.monikaklim.socialnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.monikaklim.socialnetwork.dao.LoginDAOImpl;
import it.monikaklim.socialnetwork.model.Utente;

@Service

public class ServiceLogin {

	@Autowired
	private LoginDAOImpl loginDAO;	
	
	
	@Transactional
	public Utente findUtente(String user, String pass) {
		
		
		if(loginDAO.findUtente(user,pass) == null)
		{
			return  null;
		}
		else {
			
			return loginDAO.findUtente(user,pass);
		}
			
		}	
	
	
	
	@Transactional
	public Utente findUtenteByEmail(String mail) {		
		if(loginDAO.findUtenteByEmail(mail) == null)
		{
			return  null;
		}
		else {
			
			return loginDAO.findUtenteByEmail(mail);
		}
			
		}	
	
	@Transactional
	public Utente findUtenteById(int idUtente) {		
		if(loginDAO.findUtenteById(idUtente) == null)
		{
			return  null;
		}
		else {
			
			return loginDAO.findUtenteById(idUtente);
		}
			
		}	
	
	
@Transactional
	public String registraUtente(Utente utente) {		
		return loginDAO.registraUtente(utente);
				
		}


@Transactional
	public void updatePassword(int idUtente,String pass1) {
		 loginDAO.updatePassword(idUtente, pass1);
		
	}	
	


@Transactional
public void setRichiestaModificaPsw(int idUtente, int richiesta) {
	 loginDAO.setRichiestaModificaPsw(idUtente,richiesta);
	
}




}
