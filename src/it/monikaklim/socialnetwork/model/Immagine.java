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
	
	
	public Immagine() 
	{}
	

	public Immagine(String nome, String path, String extension) {
		this.nome = nome;
		this.path = path;
		this.extension = extension;
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
	
	
	
	
	
	
}
