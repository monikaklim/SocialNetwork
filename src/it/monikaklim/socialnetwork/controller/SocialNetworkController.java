package it.monikaklim.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocialNetworkController {

	
	@RequestMapping("/")
	public String showLogin() {

	return "login";
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
