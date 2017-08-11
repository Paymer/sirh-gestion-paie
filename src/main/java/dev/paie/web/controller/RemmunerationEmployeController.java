package dev.paie.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EnterpriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemmunerationEmployeController {

	@Autowired private EnterpriseRepository ent;
	@Autowired private ProfilRemunerationRepository pro;
	@Autowired private GradeRepository gd;
	@Autowired private RemunerationEmployeRepository rem;
	
	@RequestMapping(method = RequestMethod.GET, path="/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye(){
		List<Entreprise> entreprise = ent.findAll();
		List<ProfilRemuneration> prof = pro.findAll();
		List<Grade> grad = gd.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		
		mv.addObject("entreprise", entreprise);
		mv.addObject("prof", prof);
		mv.addObject("grad", grad);
		
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path="/lister")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	public ModelAndView listerEmploye(){
		
		List<RemunerationEmploye> remu = rem.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		
		mv.addObject("remu", remu);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView addEmploye(){
		
	//prendre la date du formulaire
		
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		return mv;
	}
	

	}
	

