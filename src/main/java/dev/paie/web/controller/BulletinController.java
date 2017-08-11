package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.BulletinService;


@Controller
@RequestMapping("/bulletins")
public class BulletinController {
	
	@Autowired private BulletinService ser;
	@Autowired private PeriodeRepository per;
	@Autowired private RemunerationEmployeRepository rem;
	@Autowired private BulletinRepository bull;
	

		@RequestMapping(method = RequestMethod.GET, path="/creer")
		@Secured("ROLE_ADMINISTRATEUR")
		public ModelAndView creerBulletin(){
			
			List<Periode> periodes = per.findAll();
			List<RemunerationEmploye> remu = rem.findAll();
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("bulletins/creerBulletin");
			
			mv.addObject("periode", periodes);
			mv.addObject("rem", remu);
			
			return mv;
		}
		
		@RequestMapping(method = RequestMethod.GET, path="/lister")
		@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
		public ModelAndView listerBulletin(){
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("bulletins/listeBulletins");
			
			mv.addObject("map",ser.lister());
			return mv;
			
			
		}
		
		
		@RequestMapping(method = RequestMethod.POST, path="/creer")
		@Secured("ROLE_ADMINISTRATEUR")
		
		public ModelAndView addEmploye(@RequestParam("Matricule") String mat, @RequestParam("Periode")String peri, @RequestParam("PrimeExceptionelle")String prime){
			
		//prendre la date du formulaire
			BulletinSalaire bulletin = new BulletinSalaire();
			
			bulletin.setDateCreation(ZonedDateTime.now());
			bulletin.setPrimeExceptionnelle(new BigDecimal(prime));
			
			List<RemunerationEmploye>  remun = rem.findAll();
			for(RemunerationEmploye r : remun){
				if (r.getMatricule().equals(mat)){
					bulletin.setRemunerationEmploye(r);
				}
			}
			
			
			List<Periode> periodes = per.findAll();
			String periode;
			for(Periode p : periodes){
				periode = p.getDateDebut()+" - "+p.getDateFin();
				if (periode.equals(peri)){
					bulletin.setPeriode(p);
				}
			}
			
			bull.save(bulletin);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("bulletins/listeBulletins");
		
			
			mv.addObject("map",ser.lister());
			return mv;
			}
			
			
		}
		
		

