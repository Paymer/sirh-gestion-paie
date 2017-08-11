package dev.paie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinRepository;

@Service
public class BulletinServices implements BulletinService {

	@Autowired private CalculerRemunerationService calcul;
	 @Autowired private BulletinRepository bull;
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> lister (){
		

		Map<BulletinSalaire, ResultatCalculRemuneration> map = new HashMap<>();
		for (BulletinSalaire b:bull.findAll()){
		map.put(b, calcul.calculer(b));}
		
	
		
		return map;
	}

}
