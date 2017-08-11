package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDoneesService {

	@PersistenceContext private EntityManager em;

	@Override
	@Transactional
	public void initialiser() {

		initialisePeriode();
		initialiseUsers();

		try (ClassPathXmlApplicationContext contextData = new ClassPathXmlApplicationContext(
				"classpath:cotisations-imposables.xml", "classpath:cotisations-non-imposables.xml",
				"classpath:entreprises.xml", "classpath:grades.xml", "classpath:profils-remuneration.xml")) {

			initialiseCotisation(contextData);
			initialiseEntreprises(contextData);
			initialiseGrade(contextData);
			initialiseProfilRemuneration(contextData);
		}

	}

	@Transactional
	public void initialisePeriode() {

		LocalDate date;

		for (int i = 1; i < 13; i++) {

			Periode p = new Periode();
			date = LocalDate.of(2017, i, 1);
			p.setDateDebut(date);
			date = date.with(TemporalAdjusters.lastDayOfMonth());
			p.setDateFin(date);
			em.persist(p);

		}
	}
	
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void initialiseUsers() {
		
		Utilisateur user = new Utilisateur();
		

		String passwordHashe = this.passwordEncoder.encode("user");
		user.setEstActivf(true);
		user.setNomUtilisateur("user");
		user.setNomDePasse(passwordHashe);
		user.setRole(ROLES.ROLE_UTILISATEUR);
		
		em.persist(user);
		
		Utilisateur admin = new Utilisateur();
		passwordHashe = this.passwordEncoder.encode("admin");
		admin.setEstActivf(true);
		admin.setNomUtilisateur("admin");
		admin.setNomDePasse(passwordHashe);
		admin.setRole(ROLES.ROLE_ADMINISTRATEUR);

			
		em.persist(admin);

		}
	

	@Transactional
	public void initialiseCotisation(ClassPathXmlApplicationContext contextData) {

		Map<String, Cotisation> beansOfType = contextData.getBeansOfType(Cotisation.class);

		Collection<Cotisation> liste = beansOfType.values();
		for (Cotisation cotisation : liste) {
			em.persist(cotisation);
		}

	}

	@Transactional
	public void initialiseEntreprises(ClassPathXmlApplicationContext contextData) {

		Map<String, Entreprise> beansOfType = contextData.getBeansOfType(Entreprise.class);

		Collection<Entreprise> liste = beansOfType.values();
		for (Entreprise ent : liste) {
			em.persist(ent);
		}

	}

	@Transactional
	public void initialiseGrade(ClassPathXmlApplicationContext contextData) {

		Map<String, Grade> beansOfType = contextData.getBeansOfType(Grade.class);

		Collection<Grade> liste = beansOfType.values();
		for (Grade gr : liste) {
			em.persist(gr);
		}

	}

	@Transactional
	public void initialiseProfilRemuneration(ClassPathXmlApplicationContext contextData) {

		Map<String, ProfilRemuneration> beansOfType = contextData.getBeansOfType(ProfilRemuneration.class);

		Collection<ProfilRemuneration> liste = beansOfType.values();
		for (ProfilRemuneration gr : liste) {
			em.persist(gr);
		}

	}

}
