package dev.paie.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDoneesService;

@Component
public class InitController implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitController.class);
	
	@Autowired private InitialiserDoneesService initService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Log de niveau INFO
		LOGGER.info("Initialisation des données"); 
		initService.initialiser();
		
	}

}
