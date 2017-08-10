package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDoneesService;

@Controller
public class StartUpController {

	@Autowired private InitialiserDoneesService init;
	
	@EventListener(ContextRefreshedEvent.class)
	  public void contextRefreshedEvent() {
	    // code exécuté une fois que le contexte Spring est entièrement chargé
		init.initialiser();
		
	  }
	
}
