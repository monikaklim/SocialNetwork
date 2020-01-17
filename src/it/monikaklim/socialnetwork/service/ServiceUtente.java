package it.monikaklim.socialnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.monikaklim.socialnetwork.dao.UtenteDAOImpl;
import it.monikaklim.socialnetwork.model.Utente;

@Service
public class ServiceUtente {

	@Autowired
	private UtenteDAOImpl utenteDAO;	
	
	
	@Transactional
	public Utente findUtente(String user, String pass) {
		
		
		if(utenteDAO.findUtente(user,pass) == null)
		{
			return  null;
		}
		else {
			
			return utenteDAO.findUtente(user,pass);
		}
			
		}	
	
	
	
	@Transactional
	public Utente findUtenteByEmail(String mail) {		
		if(utenteDAO.findUtenteByEmail(mail) == null)
		{
			return  null;
		}
		else {
			
			return utenteDAO.findUtenteByEmail(mail);
		}
			
		}	
	
	@Transactional
	public Utente findUtenteById(int idUtente) {		
		if(utenteDAO.findUtenteById(idUtente) == null)
		{
			return  null;
		}
		else {
			
			return utenteDAO.findUtenteById(idUtente);
		}
			
		}	
	
	
@Transactional
	public String registraUtente(Utente utente) {		
		return utenteDAO.registraUtente(utente);
				
		}


@Transactional
	public void updatePassword(int idUtente,String pass1) {
		 utenteDAO.updatePassword(idUtente, pass1);
		
	}	
	


@Transactional
public void setRichiestaModificaPsw(int idUtente, int richiesta) {
	 utenteDAO.setRichiestaModificaPsw(idUtente,richiesta);
	
}








}
