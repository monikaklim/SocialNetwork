package it.monikaklim.socialnetwork.controller;

import java.util.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import it.monikaklim.socialnetwork.model.*;
import it.monikaklim.socialnetwork.service.*;
import javax.mail.*;
import javax.mail.internet.*;

@Controller
public class SocialNetworkController {

   private final String messaggioResetPassword ="Clicca sul link per creare una nuova password:\n\n http://localhost:8080/SocialNetwork/resetPassword?idUtente=";
	
   //service
	@Autowired
	@Qualifier("serviceLogin")
	private ServiceLogin service;	
	
	@Autowired
	@Qualifier("serviceImmagine")
	private ServiceImmagine serviceImm;	
	
	@Autowired
	@Qualifier("servicePost")
	private ServicePost servicePost;	
	

	
//-----homepage-----	
	@RequestMapping("/")
	public String showLogin() {

	return "login";
	}		
	
	
//------login------
	Utente utente = null;
	Utente u = null;
	@RequestMapping("/processLogin")
	public String processLogin(HttpServletRequest request, Model model) {

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String messaggio = "";
		 u = service.findUtente(username,password);
		if(  u == null)
			{messaggio = "Password e/o username non validi.";
			model.addAttribute("msg",messaggio);
			return "login";
			}
		else	
		{
			List<Post> postlist = servicePost.selectAllPost(u);	
			Collections.reverse(postlist);
			model.addAttribute("postlist",postlist);
			model.addAttribute("idUtente", u.getIdUtente());
			return "dashboard";
			}
		}
	
	

//-----dashboard-------	

	@RequestMapping("/dashboard")
	public String showDashboard(HttpServletRequest request, Model model) {

	List<Post> postlist = servicePost.selectAllPost(u);	
	Collections.reverse(postlist);
	
	model.addAttribute("postlist",postlist);
	return "dashboard";
	}	
	
	
//--------recupero password--------
	@RequestMapping("/forgottenPassword")
	public String showForgottenPassword() {

	return "forgottenpassword";
	}	
	
	
	String indirizzomail = "";
	
	int codiceGenerato = 0;
	
	//email di verifica per richiesta modifica password
	@RequestMapping("/sendMailVerifica")
	public String sendMailVerifica(HttpServletRequest request, Model model) throws MessagingException{
	int idUtente = 0;
	indirizzomail = request.getParameter("mailPass").trim();
	 utente = service.findUtenteByEmail(indirizzomail);
	if(utente != null) {
	 idUtente = utente.getIdUtente();
	 codiceGenerato = (new Random().nextInt(10000) + 55555);
	String messaggio ="Il codice di verifica è:\n\n"+ codiceGenerato ;
	
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
    message.setSubject("Codice di verifica");
    message.setText(messaggio);

    InternetAddress fromAddress = new InternetAddress("monika.klim@scaiconsulting.it");
    InternetAddress toAddress = new InternetAddress(indirizzomail);
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);	
		
    model.addAttribute("idUtente",idUtente);	
    model.addAttribute("controllo1","L'email di verifica è stata inviata.");	
		
	}
	else
		 model.addAttribute("controllo1","Non sei registrato.");
	return "forgottenpassword";
	}
	
	//controllo codice di verifica 
	@RequestMapping("/controlloCodice")
	public String controlloCodice(HttpServletRequest request, Model model) {
	int codiceInserito = Integer.parseInt(request.getParameter("codiceVerifica").trim());	
		
	if(codiceGenerato == codiceInserito)
	{
	utente.setRichiestaModificaPsw(1);	
	service.setRichiestaModificaPsw(utente.getIdUtente(), 1);
	model.addAttribute("controllo2","Identità verificata. Clicca 'Fine' per ricevere il link di reset.");	
	}
	else
	{
		model.addAttribute("controllo2","Il codice è errato");		
	}
	return "forgottenpassword";	
	}
	
	
	//invio email con link
	@RequestMapping("/sendMail")
	public String sendMail(HttpServletRequest request, Model model) throws MessagingException{
	int idUtente = 0;

	if(utente != null) {
	 idUtente = utente.getIdUtente();
	
	if(utente.getRichiestaModificaPsw() == 1) {
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
    InternetAddress toAddress = new InternetAddress(indirizzomail);
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);	
	
    model.addAttribute("idUtente",idUtente);	
    model.addAttribute("controllo3","L'email con il link per resettare la password è stata inviata.");	
	}
	else
    model.addAttribute("controllo3","L'email non è stata inviata.");	
	}
	return "forgottenpassword";
	}
	
	
	@RequestMapping("/resetPassword")
	public String showReset(){

	return "resetpassword";
	}
	
	//controlla password e aggiorna
	@RequestMapping("/confrontaPassword")
	public String confrontaPassword(@RequestParam("idUtente") String id, HttpServletRequest request, Model model) {
		int idUt = Integer.parseInt(id);
	   Utente utentePass = service.findUtenteById(idUt);
		String pass1 = request.getParameter("p1").trim();
		String pass2 = request.getParameter("p2").trim();
		
		if(pass1.equals(pass2) && (utentePass.getRichiestaModificaPsw() == 1)) {
			service.updatePassword(idUt, pass1);
			utentePass.setRichiestaModificaPsw(0);
			service.setRichiestaModificaPsw(Integer.parseInt(id), 0);
			return "redirect:/login";}
		
			if(pass1.equals(pass2) && (utentePass.getRichiestaModificaPsw() == 0)) {
				    model.addAttribute("controllo","Non sei autorizzato a modificare questa password.");
				    return "resetpassword";
			}
			
			if(!pass1.equals(pass2)) {
				
				  model.addAttribute("controllo","Le password non corrispondono.");
				  return "resetpassword";		
			} else
				 return "resetpassword";
			
		}
	
	

//------registrazione--------
	
	@RequestMapping("/registration")
	public String showRegistation() {

	return "registration";
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
			
		return "confirmregistration";
	}	
		
		
	//conferma registrazione
	@RequestMapping("/confirmRegistration")
	public String showConfirmRegistration() {

	return "confirmregistration";
	}	
	
	
	
//--------post---------
	
	
@RequestMapping("/newPost")
public String showNewPost() {

return "newpost";
}		
	

//pubblica post
Utente ut = null;

@RequestMapping("/publishPost")
public String publishPost(@RequestParam CommonsMultipartFile file, @RequestParam(value ="idUtente") String id,HttpSession session, HttpServletRequest request, Model model)throws Exception {

	//immagine
	Immagine immagine = null;
	
	if(file != null) {
	try {
	String path = "C:\\Users\\monika.klim\\eclipse-workspace\\SocialNetwork\\WebContent\\resources\\images\\";
	String ext = file.getOriginalFilename().substring((file.getOriginalFilename().indexOf("."))+1);
	String nomeFile = file.getOriginalFilename().substring(0,file.getOriginalFilename().indexOf("."));
	byte[] bytes = file.getBytes();

	immagine = new Immagine(nomeFile,path,ext,bytes);
	
	serviceImm.insertImmagine(immagine);
	}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("Errore, non è stato possibile caricare l'immagine.");
	}
	}
	 ut = service.findUtenteById(Integer.parseInt(id));
	
	 serviceImm.saveImmagineFromDB(immagine.getIdImmagine());
	 
	//testo
	String contenuto = request.getParameter("inputtext").trim();
	
		Post p = new Post(contenuto,ut,immagine);
		servicePost.insertPost(p);
		model.addAttribute("idUtente",id);

	return "redirect:/dashboard";
}






	
	
}
