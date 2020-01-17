package it.monikaklim.socialnetwork.controller;

import java.util.*;
import java.io.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import it.monikaklim.socialnetwork.model.*;
import it.monikaklim.socialnetwork.service.*;
import javax.mail.*;
import javax.mail.internet.*;

@Controller
@SessionAttributes("utenteSession")
public class SocialNetworkController {

   private final String messaggioResetPassword ="Clicca sul link per creare una nuova password:\n\n http://localhost:8080/SocialNetwork/resetPassword?idUtente=";
	
   //service
	@Autowired
	@Qualifier("serviceUtente")
	private ServiceUtente service;	
	
	@Autowired
	@Qualifier("serviceImmagine")
	private ServiceImmagine serviceImm;	
	
	@Autowired
	@Qualifier("servicePost")
	private ServicePost servicePost;	
	
	@Autowired
	@Qualifier("serviceAmicizia")
	private ServiceAmicizia serviceAmi;	
	
	
//------pagina iniziale------	
	@RequestMapping("/")
	public String showLogin(HttpServletResponse response,SessionStatus status) {
		status.setComplete();
	return "login";
	}		
	
	
//-------login-------
	Utente utente = null;
	Utente u = null;
	@RequestMapping("/processLogin")
	public String processLogin( HttpServletRequest request,HttpServletResponse response, Model model, @ModelAttribute Utente utente) {

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
		
		
			model.addAttribute("postlist",postlist);
			model.addAttribute("idUtente", u.getIdUtente());
			model.addAttribute("utenteSession", u);
			return "dashboard";
			}
		}
	

	

//-------dashboard-------	

	@RequestMapping("/dashboard")
	public String showDashboard(HttpServletRequest request, Model model,@ModelAttribute Utente utente) {
	
	List<Post> postlist = servicePost.selectAllPost(u);	

	model.addAttribute("postlist",postlist);
	
	model.addAttribute("utenteSession",u);
	return "dashboard";
	}	
	
	
	
	
//-------profilo utente--------	
	
	@RequestMapping("/userProfile")
	public String showUserProfile(@ModelAttribute Utente utente, Model model) {
		
		ArrayList<Utente> amici = serviceAmi.selectAllAmici(u);
		model.addAttribute("amici", amici);
	model.addAttribute("utenteSession",u);
	return "userprofile";
	}	
	
	
	//aggiungi amici
	
	
	@RequestMapping("/addFriend")
	public String addFriend(@ModelAttribute Utente utente, Model model) {
	//add user
	Utente ut2 = service.findUtenteById(0);	
	serviceAmi.richiediAmicizia(u,ut2 );	
	ArrayList<Utente> amici = serviceAmi.selectAllAmici(u);
	model.addAttribute("amici", amici);	
	model.addAttribute("utenteSession",u);
	return "userprofile";
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
			return "redirect:/";}
		
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
public String showNewPost(Model model) {
model.addAttribute("idUtente", u.getIdUtente());
return "newpost";
}		
	

//pubblica post
Utente ut = null;

@RequestMapping("/publishPost")
public String publishPost(@RequestParam CommonsMultipartFile file, @RequestParam(value ="idUtente") String idU,HttpSession session, HttpServletRequest request, Model model)throws Exception {
int id = Integer.parseInt(idU);
if(id != 0) {
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
	serviceImm.saveImmagineFromDB(immagine.getIdImmagine());
	}
	catch(Exception e) {
		System.out.println("Errore, non è stato possibile caricare l'immagine.");
	}
	}
	 ut = service.findUtenteById(id); ///
	
	
	 
	//testo
	String contenuto = request.getParameter("inputtext").trim();
	if(contenuto.isEmpty() == false) {
		Post p = new Post(contenuto,ut,immagine);
		servicePost.insertPost(p);
		model.addAttribute("utenteSession",ut);
	}else {
		Post p = new Post(immagine,ut);
		servicePost.insertPost(p);
	}
	
}
	return "redirect:/dashboard";
}


//modifica post

@GetMapping("/updatePost")
public String showUpdate(@RequestParam("idPost")String idPost, Model model) {
	Post post = servicePost.selectPost(Integer.parseInt(idPost));
	model.addAttribute("post", post);
	return "updatepost";
}	


@RequestMapping("/processUpdate")
public String processUpdate2(@ModelAttribute("post") Post post, Model model) {
	servicePost.updatePost(post);
	model.addAttribute("post2",post);

	return "redirect:/dashboard";
}	

//elimina post
@GetMapping("/deletePost")
public String showDelete(@RequestParam("idPost")String idPost) {
	Post post = servicePost.selectPost(Integer.parseInt(idPost));
	servicePost.deletePost(post);
	return "redirect:/dashboard";
}	









	
	
}
