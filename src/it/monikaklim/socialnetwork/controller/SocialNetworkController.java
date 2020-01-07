package it.monikaklim.socialnetwork.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.monikaklim.socialnetwork.model.Utente;
import it.monikaklim.socialnetwork.service.ServiceLogin;

@Controller
public class SocialNetworkController {

	@Autowired
	private ServiceLogin service;	
	
	
	@RequestMapping("/")
	public String showLogin() {

	return "login";
	}		
	
	
	@RequestMapping("/processLogin")
	public String processLogin(HttpServletRequest request, Model model) {

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		boolean esito = service.findUtente(username,password);
		if(esito == false)
			return "login";
		else
			return "home";
		}
	
	
	
	@RequestMapping("/registrazione")
	public String showRegistrazione() {

	return "registrazione";
	}	
	
	
	@RequestMapping("/processRegistrazione")
	public String processInsert(HttpServletRequest request, Model model) {
		 	Utente utente = null;
			String nome = request.getParameter("nome").trim();
			String cognome = request.getParameter("cognome").trim();
			String data = request.getParameter("data").trim();
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			if((nome.isEmpty() == false)&& (cognome.isEmpty() == false)&&(data.isEmpty() == false)&&(username.isEmpty() == false)&&(password.isEmpty() == false))
			utente = new Utente(nome,cognome,data,username,password);
	        service.registraUtente(utente);
			
		return "redirect:/";
	}	
		
	@RequestMapping("/select")
	public String showSelect() {

	return "redirect:/";
	}	
	
	
	
	
	
	
}
