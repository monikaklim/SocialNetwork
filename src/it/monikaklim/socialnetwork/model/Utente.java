package it.monikaklim.socialnetwork.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")

public class Utente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idUtente;	
	
	@Column
	private String nome;
	@Column
	private String cognome;	
	@Column
	private String dataNascita;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private int richiestaModificaPsw; //0 = no - 1 = si
	
	@OneToMany(mappedBy="utente")
	private List<Post> post;
	  

	

	

	public Utente() {
		
	}
	
	
	public Utente(String nome, String cognome, String dataNascita, String username, String password, String email) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.username = username;
		this.password = password;
		this.email = email;
		this.richiestaModificaPsw = 0;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}	
	
	
	public int getRichiestaModificaPsw() {
		return richiestaModificaPsw;
	}


	public void setRichiestaModificaPsw(int richiestaModificaPsw) {
		this.richiestaModificaPsw = richiestaModificaPsw;
	}


	public List<Post> getPost() {
		return post;
	}


	public void setPost(ArrayList<Post> post) {
		this.post = post;
	}
	
	//add post
	
	public void addPost(Post p) {
	
		if(post == null) {
			post = new ArrayList<Post>();
		}
		
		post.add(p);
		p.setUtente(this);
	}






	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", richiestaModificaPsw=" + richiestaModificaPsw ;
	}
	
	
	
	
	
	
	
	
	
}
