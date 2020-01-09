package it.monikaklim.socialnetwork.controller;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.monikaklim.socialnetwork.model.Utente;
import it.monikaklim.socialnetwork.service.ServiceLogin;
import javax.mail.*;
import javax.mail.internet.*;
@Controller
public class SocialNetworkController {

   private final String messaggioResetPassword ="Clicca sul link per creare una nuova password:\n\n http://localhost:8080/SocialNetwork/resetPassword?idUtente=";
	
	@Autowired
	private ServiceLogin service;	
	
	

	
	
	@RequestMapping("/")
	public String homepage() {

	return "home";
	}	
	
	
	
	@RequestMapping("/login")
	public String showLogin() {

	return "login";
	}		
	
	
	@RequestMapping("/confirmRegistration")
	public String showConfirm() {

	return "confirmRegistration";
	}	
	
	
	@RequestMapping("/processLogin")
	public String processLogin(HttpServletRequest request, Model model,HttpServletResponse response) throws ServletException, IOException{

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		String messaggio = "";
		
		if( service.findUtente(username,password) == false)
			{messaggio = "password e/o username non validi";
			model.addAttribute("msg",messaggio);
			return "login";
			}
		else
			
		{
			return "homelogged";
			}
		
		
		}
	
	
	@RequestMapping("/registrazione")
	public String showRegistrazione() {

	return "registrazione";
	}	
	
	@RequestMapping("/logged")
	public String showLogged() {

	return "homelogged";
	}	
	
	
	
	
	
	//email di verifica per richiesta modifica password
	@RequestMapping("/sendMailVerifica")
	public String sendMailVerifica(HttpServletRequest request, Model model) throws MessagingException{
	int idUtente = 0;
	String indirizzo = request.getParameter("mailPass").trim();
	Utente utente = service.findUtenteByEmail(indirizzo);
	if(utente != null) {
	 idUtente = utente.getIdUtente();
	
	
	
	String messaggio ="Il codice di verifica è:\n\n"+  new Random().nextInt(10000) + 88888;
	
	 // Creazione di una mail session
    Properties props = new Properties();
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.prot", "465");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("monika.klim@scaiconsulting.it","monika99");
        }
    }
    );
    
    
    MimeMessage message = new MimeMessage(session);
    message.setSubject("Reset password");
    message.setText(messaggio);

    InternetAddress fromAddress = new InternetAddress("monika.klim@scaiconsulting.it");
    InternetAddress toAddress = new InternetAddress("monika.klim@scaiconsulting.it");
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);	
		
    model.addAttribute("idUtente",idUtente);	
	return "login";	
	}
	else
		return "login";
	
	}
	
	
	
	
	
	
	
	
	
	//invio email
	@RequestMapping("/sendMail")
	public String sendMail(HttpServletRequest request, Model model) throws MessagingException{
	int idUtente = 0,modifica = 0;
	
	String indirizzo = request.getParameter("mailPass").trim();
	Utente utente = service.findUtenteByEmail(indirizzo);
	if(utente != null) {
	 idUtente = utente.getIdUtente();
	 modifica = utente.getRichiestaModificaPsw();
	
	}
	
	if(modifica == 1) {
	String messaggio = messaggioResetPassword  + idUtente;
	 // Creazione di una mail session
    Properties props = new Properties();
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.prot", "465");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("monika.klim@scaiconsulting.it","monika99");
        }
    }
    );
    
    
    MimeMessage message = new MimeMessage(session);
    message.setSubject("Reset password");
    message.setText(messaggio);

    InternetAddress fromAddress = new InternetAddress("monika.klim@scaiconsulting.it");
    InternetAddress toAddress = new InternetAddress("monika.klim@scaiconsulting.it");
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);	
		
    model.addAttribute("idUtente",idUtente);	
	return "login";	
	}
	else
		return "login";
	
	}
	
	
	
	@RequestMapping("/resetPassword")
	public String showReset(){

	return "resetpassword";
	}
	
	
	
	@RequestMapping("/confrontaPassword")
	public String confrontaPassword(@RequestParam("idUtente") String id, HttpServletRequest request, Model model) {
	
		String pass1 = request.getParameter("p1").trim();
		String pass2 = request.getParameter("p2").trim();
		
		if(pass1.equals(pass2)) {

			service.updatePassword(Integer.parseInt(id), pass1);
			return "redirect:/login";	
		}
		else {
	System.out.println("no");
			return "redirect:/resetPassword";	
		}
	}
	


	
	@RequestMapping("/processRegistrazione")
	public String processInsert(HttpServletRequest request, Model model) {
		 	Utente utente = null;
			String nome = request.getParameter("nome").trim();
			String cognome = request.getParameter("cognome").trim();
			String data = request.getParameter("data").trim();
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			String email = request.getParameter("email").trim();
			if((nome.isEmpty() == false)&& (cognome.isEmpty() == false)&&(data.isEmpty() == false)&&(username.isEmpty() == false)&&(password.isEmpty() == false)&&(email.isEmpty() == false))
			utente = new Utente(nome,cognome,data,username,password,email);
	        service.registraUtente(utente);
			
		return "confirmRegistration";
	}	
		
	@RequestMapping("/select")
	public String showSelect() {

	return "redirect:/";
	}	
	
	
	
	
	
	
}
