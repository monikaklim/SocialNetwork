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
    @JoinColumn(referencedColumnName = "idUtente")
   Utente idUtente;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idAmico")
   Utente idAmico;
	
	@Column
	private int statoRichiesta;
	
	@Column
	private Utente utenteRichiesta;
	
	
	public Amicizia() {}

	public Amicizia(Utente idUtente, Utente idAmico, int statoRichiesta, Utente utenteRichiesta) {

		this.idUtente = idUtente;
		this.idAmico = idAmico;
		this.statoRichiesta = statoRichiesta;
		this.utenteRichiesta = utenteRichiesta;
	}

	public Utente getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Utente idUtente) {
		this.idUtente = idUtente;
	}

	public Utente getIdAmico() {
		return idAmico;
	}

	public void setIdAmico(Utente idAmico) {
		this.idAmico = idAmico;
	}

	public int getStatoRichiesta() {
		return statoRichiesta;
	}

	public void setStatoRichiesta(int statoRichiesta) {
		this.statoRichiesta = statoRichiesta;
	}

	public Utente getUtenteRichiesta() {
		return utenteRichiesta;
	}

	public void setUtenteRichiesta(Utente utenteRichiesta) {
		this.utenteRichiesta = utenteRichiesta;
	}

	@Override
	public String toString() {
		return "Amicizia [idUtente=" + idUtente + ", idAmico=" + idAmico + ", statoRichiesta=" + statoRichiesta
				+ ", utenteRichiesta=" + utenteRichiesta + "]";
	}
	
	
	
	
	
}
