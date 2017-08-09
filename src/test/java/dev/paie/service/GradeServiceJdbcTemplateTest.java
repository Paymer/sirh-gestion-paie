package dev.paie.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonnesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class , JeuxDeDonnesConfig.class, DataSourceMySQLConfig.class, JpaConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)



public class GradeServiceJdbcTemplateTest {
	
	@Autowired private GradeService gds;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Grade gd = new Grade ();
	
		// sauvegarder un nouveau grade
		gd.setCode("GRA1");
		BigDecimal b = new BigDecimal("15.263");
		gd.setNbHeuresBase(b);
		gd.setTauxBase(b);
		gds.sauvegarder(gd);
		
		// vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> liste = gds.lister(); 
		List<Grade> filt = liste.stream()
				.filter(p -> p.getCode().equals("GRA1"))
				.filter(p -> p.getNbHeuresBase().equals(b))
				.filter(p -> p.getTauxBase().equals(b))
				.collect(Collectors.toList());
		assert(filt.size() != 0);
		
		
		// modifier un grade
		BigDecimal c = new BigDecimal("20.896");
		gd.setNbHeuresBase(c);
		gd.setTauxBase(c);
		gds.mettreAJour(gd);
		
		//vérifier que les modifications sont bien prises en compte via la méthode lister
		liste = gds.lister();
		
		filt = liste.stream()
				.filter(p -> p.getCode().equals("GRA1"))
				.filter(p -> p.getNbHeuresBase().equals(c))
				.filter(p -> p.getTauxBase().equals(c))
				.collect(Collectors.toList());
		assert(filt.size() != 0);
		filt = liste.stream()
				.filter(p -> p.getCode().equals("GRA1"))
				.filter(p -> p.getNbHeuresBase().equals(b))
				.filter(p -> p.getTauxBase().equals(b))
				.collect(Collectors.toList());
		assert(filt.size() == 0);
		
	}

}
