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
import dev.paie.entite.Cotisation;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;


//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class , JeuxDeDonnesConfig.class, DataSourceMySQLConfig.class, JpaConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired private CotisationService cotisationService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	
		Cotisation cot = new Cotisation ();
		cot.setCode("COD1");
		cot.setLibelle("libelleCOD1");
		BigDecimal d = new BigDecimal("9.85");
		cot.setTauxPatronal(d);
		cot.setTauxSalarial(d);
		
		// sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(cot);
		
	// vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
		List<Cotisation> liste = cotisationService.lister(); 
		List<Cotisation> filt = liste.stream()
				.filter(p -> p.getCode().equals("COD1"))
				.filter(p -> p.getLibelle().equals("libelleCOD1"))
				.filter(p -> p.getTauxPatronal().equals(d))
				.filter(p -> p.getTauxSalarial().equals(d))
				.collect(Collectors.toList());
		assert(filt.size() == 1);
		
	// modifier une cotisation
		cot.setLibelle("libelleCOD2");
		BigDecimal e = new BigDecimal("10.57");
		cot.setTauxPatronal(e);
		cot.setTauxSalarial(e);
		
		cotisationService.mettreAJour(cot);
		
	// vérifier que les modifications sont bien prises en compte via la méthode lister
		liste = cotisationService.lister(); 
		filt = liste.stream()
				.filter(p -> p.getCode().equals("COD1"))
				.filter(p -> p.getLibelle().equals("libelleCOD2"))
				.filter(p -> p.getTauxPatronal().equals(e))
				.filter(p -> p.getTauxSalarial().equals(e))
				.collect(Collectors.toList());
		assert(filt.size() == 1);
		filt = liste.stream()
				.filter(p -> p.getCode().equals("COD1"))
				.filter(p -> p.getLibelle().equals("libelleCOD1"))
				.filter(p -> p.getTauxPatronal().equals(d))
				.filter(p -> p.getTauxSalarial().equals(d))
				.collect(Collectors.toList());
		assert(filt.size() == 0);
		
		
	}

}
