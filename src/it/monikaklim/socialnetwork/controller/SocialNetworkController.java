package it.monikaklim.socialnetwork.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String homepage() {

	return "home";
	}	
	
	
	
	@RequestMapping("/login")
	public String showLogin() {

	return "login";
	}		
	
	
	@RequestMapping("/processLogin")
	public void processLogin(HttpServletRequest request, Model model,HttpServletResponse response) throws ServletException, IOException{

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		String messaggio = "";
		
		if( service.findUtente(username,password) == false)
			{messaggio = "password e/o username non validi";
			model.addAttribute("msg",messaggio);
			model.addAttribute("display", "\"block\"");
			RequestDispatcher req = request.getRequestDispatcher("login");
			req.forward(request, response);
			}
		else
			
		{
			RequestDispatcher req = request.getRequestDispatcher("logged");
			req.forward(request, response);

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
			
		return "redirect:/";
	}	
		
	@RequestMapping("/select")
	public String showSelect() {

	return "redirect:/";
	}	
	
	
	
	
	
	
}
