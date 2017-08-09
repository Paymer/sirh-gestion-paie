package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;



@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext private EntityManager em;
	
	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		
		em.persist(nouvelleCotisation);

	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		TypedQuery<Cotisation> query = em.createQuery("select p from Cotisation p where p.code=:cod", Cotisation.class)
				.setParameter("cod", cotisation.getCode());
		Cotisation p = query.getSingleResult();

			if(p != null){
					p.setLibelle(cotisation.getLibelle());
					p.setTauxPatronal(cotisation.getTauxPatronal());
					p.setTauxSalarial(cotisation.getTauxSalarial());
			
						}

	}

	@Override
	@Transactional
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("select p from Cotisation p", Cotisation.class);
		return query.getResultList();
		
	}

}
