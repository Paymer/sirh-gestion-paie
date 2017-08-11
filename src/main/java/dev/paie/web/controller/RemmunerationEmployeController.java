package dev.paie.web.controller;



import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		mv.addObject("remu", rem.findAll());
		
		return mv;
	}


	
	@RequestMapping(method = RequestMethod.POST, path="/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView addEmploye(@RequestParam("Matricule") String mat, @RequestParam("Entreprise")String entr, @RequestParam("Profil")String prof, @RequestParam("Grade")String gra){
		
	//prendre la date du formulaire
		RemunerationEmploye empl = new RemunerationEmploye();
		empl.setMatricule(mat);
		empl.setDateCreation(ZonedDateTime.now());
		
		List<Entreprise> entreprise = ent.findAll();
		List<ProfilRemuneration> profils = pro.findAll();
		List<Grade> grad = gd.findAll();
		
		for(Entreprise e : entreprise){
			if (e.getDenomination().equals(entr)){
				empl.setEntreprise(e);
			}
		}
		
		for(ProfilRemuneration p : profils){
			if (p.getCode().equals(prof)){
				empl.setProfilRemuneration(p);
			}
		}
		
		for(Grade g : grad){
			if (g.getCode().equals(gra)){
				empl.setGrade(g);
			}
		}
		
		rem.save(empl);
	
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeEmployes");
		mv.addObject("remu", rem.findAll());
		return mv;
	}
}
	
	

	
	

