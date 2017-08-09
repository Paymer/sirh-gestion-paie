package dev.paie.repository;

import java.math.BigDecimal;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonnesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class , JeuxDeDonnesConfig.class, DataSourceMySQLConfig.class, JpaConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)

public class AvantageRepositoryTest {

	@Autowired private AvantageRepository avantageRepository;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Avantage avant = new Avantage ();
		avant.setCode("CODE1");
		avant.setNom("COCO");
		BigDecimal a = new BigDecimal("13.52");
		avant.setMontant(a);
		
		
	//sauvegarder un nouvel avantage
		Avantage av = avantageRepository.save(avant);
		
	
		
	// vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		
		assert avantageRepository.exists(av.getId());
		

	// modifier un avantage
		
		avant.setCode("CODE2");
		avant.setNom("KUKI");
		BigDecimal b = new BigDecimal("13.24");
		avant.setMontant(b);
		
		av = avantageRepository.save(avant);
		
	// vérifier que les modifications sont bien prises en compte via la méthode findOne
	
		assert avantageRepository.exists(av.getId());
		
		
	}
	
}
