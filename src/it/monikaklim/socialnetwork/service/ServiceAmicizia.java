package it.monikaklim.socialnetwork.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.monikaklim.socialnetwork.model.*;
import it.monikaklim.socialnetwork.dao.*;

@Component
public class ServiceAmicizia {

	@Autowired
	private AmiciziaDAOImpl amiDAO;		
	
	
	@Transactional
	public void richiediAmicizia(Utente loggato, Utente utente2) {		
		 amiDAO.richiediAmicizia(loggato, utente2);
		
		}


@Transactional
	public void updatePassword(Utente loggato, Utente richiedente) {
	amiDAO.accettaAmicizia(loggato, richiedente);	
	}	
	

@Transactional
public void rifiutaAmicizia(Utente loggato, Utente richiedente) {
	 amiDAO.rifiutaAmicizia(loggato, richiedente);
}

	
@Transactional
public Amicizia selectAmicizia(Utente loggato, Utente utente2) {
	return amiDAO.selectAmicizia(loggato, utente2);
}	
	


@Transactional
public  ArrayList<Utente> selectAllAmici(Utente utente) {
	return amiDAO.selectAllAmici(utente);
}	
	
}
