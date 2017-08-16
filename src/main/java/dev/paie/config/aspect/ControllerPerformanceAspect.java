package dev.paie.config.aspect;

import java.time.Duration;
import java.time.LocalDateTime;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Performance;

@Configuration
@Aspect
@Service
public class ControllerPerformanceAspect {
	
	private LocalDateTime init;
	private LocalDateTime fin;
	
			private static final Logger LOGGER = LoggerFactory.getLogger (ControllerPerformanceAspect.class);
			@PersistenceContext private EntityManager em;
			
			@Around("execution(* dev.paie.web.controller.*.*(..))")
			@Transactional
			public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
				
				init = LocalDateTime.now();
				LOGGER.debug("Début d'exécution de la méthode " + pjp.getSignature().toString());
				
				Object resultat = pjp.proceed();
			
				LOGGER.debug("Fin d'exécution de la méthode");
				fin = LocalDateTime.now();
				
				
				Performance perf = new Performance();
				perf.setDateHeure(init);
				perf.setNomService(pjp.getSignature().toString());
				Duration period = Duration.between(init, fin);
				Long periode = period.toMillis();
				perf.setTempsExecution(periode);
				
				
				em.persist(perf);
				
				
			
				return resultat;
			}
	
}
