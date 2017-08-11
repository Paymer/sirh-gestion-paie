package dev.paie.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

		@RequestMapping(method = RequestMethod.GET, path="/creer")
		@Secured("ROLE_ADMINISTRATEUR")
		public ModelAndView creerBulletin(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("bulletins/creerBulletin");
			return mv;
		}
		
		@RequestMapping(method = RequestMethod.GET, path="/lister")
		@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
		public ModelAndView listerBulletin(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("bulletins/listeBulletins");
			return mv;
		}
		
}
