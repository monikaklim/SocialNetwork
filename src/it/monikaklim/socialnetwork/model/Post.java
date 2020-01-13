package it.monikaklim.socialnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table

public class Post {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private int idPost;	
		@Column
		private String testo;
		
		@ManyToOne
		@JoinColumn(name = "idUtente")
		private Utente utente;
		
		@OneToOne
		@JoinColumn(name = "idImmagine")
		private Immagine immagine;
		
		public Post() 
		{}


		public Post(String testo) {
			this.testo = testo;
		}


		public Post(String testo, Utente utente) {
			this.testo = testo;
			this.utente = utente;
		}


		public Post(String testo, Utente utente, Immagine immagine) {
			this.testo = testo;
			this.utente = utente;
			this.immagine = immagine;
		}



		public Utente getUtente() {
			return utente;
		}

		public void setUtente(Utente utente) {
			this.utente = utente;
		}


		public Immagine getImmagine() {
			return immagine;
		}


		public void setImmagine(Immagine immagine) {
			this.immagine = immagine;
		}


		public int getIdPost() {
			return idPost;
		}


		public void setIdPost(int idPost) {
			this.idPost = idPost;
		}


		public String getTesto() {
			return testo;
		}


		public void setTesto(String testo) {
			this.testo = testo;
		}


		
		
		
		
		
		
		
		
		
		
		
		
}
