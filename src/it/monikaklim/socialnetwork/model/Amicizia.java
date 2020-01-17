package it.monikaklim.socialnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "amicizia")
public class Amicizia {

	
	@Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "idUtente1")
   Utente utente1;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idUtente2")
   Utente utente2;
	
	@Column
	private int statoRichiesta;  //0 = inviata  1 = accettata  2 = eliminata  
	
	@Column
	private int utenteRichiesta; //utente che esegue l'ultima azione
	
	
	public Amicizia() {}
	



	public Amicizia(Utente utente1, Utente utente2, int statoRichiesta, int utenteRichiesta) {
		this.utente1 = utente1;
		this.utente2 = utente2;
		this.statoRichiesta = statoRichiesta;
		this.utenteRichiesta = utenteRichiesta;
	}




	public Utente getUtente1() {
		return utente1;
	}


	public void setUtente1(Utente utente1) {
		this.utente1 = utente1;
	}

	public Utente getUtente2() {
		return utente2;
	}


	public void setUtente2(Utente utente2) {
		this.utente2 = utente2;
	}


	public int getStatoRichiesta() {
		return statoRichiesta;
	}

	public void setStatoRichiesta(int statoRichiesta) {
		this.statoRichiesta = statoRichiesta;
	}

	public int getUtenteRichiesta() {
		return utenteRichiesta;
	}

	public void setUtenteRichiesta(int utenteRichiesta) {
		this.utenteRichiesta = utenteRichiesta;
	}




	@Override
	public String toString() {
		return "Amicizia [utente1=" + utente1 + ", utente2=" + utente2 + ", statoRichiesta=" + statoRichiesta
				+ ", utenteRichiesta=" + utenteRichiesta + "]";
	}


	
	
	
	
}
