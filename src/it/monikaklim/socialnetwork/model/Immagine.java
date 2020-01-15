package it.monikaklim.socialnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "immagini")
public class Immagine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idImmagine;	
	@Column
	private String nome;
	@Column
	private String path;
	@Column
	private String extension;
	@Column
	private byte[] dati;
	
	public Immagine() 
	{}
	


	
	public Immagine(String nome, String path, String extension, byte[] dati) {
		this.nome = nome;
		this.path = path;
		this.extension = extension;
		this.dati = dati;
	}



	public byte[] getDati() {
		return dati;
	}




	public void setDati(byte[] dati) {
		this.dati = dati;
	}




	public int getIdImmagine() {
		return idImmagine;
	}


	public void setIdImmagine(int idImmagine) {
		this.idImmagine = idImmagine;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}


	@Override
	public String toString() {
		return "Immagine [nome=" + nome + ", path=" + path + ", extension=" + extension + "]";
	}
	
	
	
	
	
	
}
