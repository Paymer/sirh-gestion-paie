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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



import dev.paie.entite.Performance;
import dev.paie.service.PerformanceService;

@Configuration
@Aspect
public class ControllerPerformanceAspect {
	
	
	
			private static final Logger LOGGER = LoggerFactory.getLogger (ControllerPerformanceAspect.class);
			@Autowired private PerformanceService perfo;
			
			@Around("execution(* dev.paie.web.controller.*.*(..))")
			public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
				
				LocalDateTime init, fin;
				
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
				
				
				perfo.sauvegarder(perf);
				
				
			
				return resultat;
			}
	
}
