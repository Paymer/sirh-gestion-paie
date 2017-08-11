package dev.paie.service;

import java.util.List;
import java.util.Map;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

public interface BulletinService {

	public Map<BulletinSalaire, ResultatCalculRemuneration> lister ();
	
}
