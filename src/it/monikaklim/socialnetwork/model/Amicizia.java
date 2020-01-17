package it.monikaklim.socialnetwork.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "amicizia")
public class Amicizia  implements Serializable{

	
	@Id
    @ManyToOne
    @JoinColumn(name = "idUtente1")
   Utente utente1;

	@Id
	@Column(name = "idUtente2")
    int idUtente2;
	
	@Column
	private int statoRichiesta;  //0 = inviata  1 = accettata  2 = eliminata  
	
	@Column
	private int utenteRichiesta; //utente che esegue l'ultima azione
	
	
	public Amicizia() {}
	



	public Amicizia(Utente utente1,int utente2, int statoRichiesta, int utenteRichiesta) {
		this.utente1 = utente1;
		this.idUtente2 = utente2;
		this.statoRichiesta = statoRichiesta;
		this.utenteRichiesta = utenteRichiesta;
	}




	public Utente getUtente1() {
		return utente1;
	}


	public void setUtente1(Utente utente1) {
		this.utente1 = utente1;
	}




	public int getIdUtente2() {
		return idUtente2;
	}




	public void setIdUtente2(int idUtente2) {
		this.idUtente2 = idUtente2;
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
		return "Amicizia [utente1=" + utente1 + ", utente2=" + idUtente2 + ", statoRichiesta=" + statoRichiesta
				+ ", utenteRichiesta=" + utenteRichiesta + "]";
	}


	
	
	
	
}
