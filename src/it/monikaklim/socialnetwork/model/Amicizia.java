package it.monikaklim.socialnetwork.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "amicizia")
public class Amicizia {


	@ManyToOne
	@JoinColumn(name = "idUtente")
	private int idUtente;	
	
	@ManyToOne
	@JoinColumn(name = "idAmico")
	private int idAmico;

	
	public Amicizia(int idUtente, int idAmico) {
		
		this.idUtente = idUtente;
		this.idAmico = idAmico;
	}
	
	
	
	public Amicizia()
	{}
	
	
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdAmico() {
		return idAmico;
	}

	public void setIdAmico(int idAmico) {
		this.idAmico = idAmico;
	}


	
	
	
	
}
