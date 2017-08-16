package dev.paie.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dev.paie.entite.Performance;

@Service
public class PerformanceService {

@PersistenceContext private EntityManager em;
	
	
	@Transactional
	public void sauvegarder (Performance perf) {
		
		em.persist(perf);

	}
	
}
