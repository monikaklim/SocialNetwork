package it.monikaklim.socialnetwork.dao;

import java.util.*;

import it.monikaklim.socialnetwork.model.*;

public interface AmiciziaDAO {

public void richiediAmicizia(Utente loggato, Utente utente2);
	
public void accettaAmicizia(Utente loggato, Utente richiedente);	
	
public Amicizia selectAmicizia(Utente loggato, Utente utente2);	
	
public List<Amicizia>selectAllAmici(Utente utente);
	
}
