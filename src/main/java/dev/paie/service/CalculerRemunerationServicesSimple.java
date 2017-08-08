package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;


@Service
public class CalculerRemunerationServicesSimple implements CalculerRemunerationService{

	@Autowired PaieUtils p;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		
		
		
		
		res.setSalaireDeBase( p.formaterBigDecimal(calculSalaireDeBase(bulletin)));
		res.setSalaireBrut( p.formaterBigDecimal(calculSalaireBrut(bulletin)));
		res.setTotalRetenueSalarial( p.formaterBigDecimal(calculTotalRetenueSalarial(bulletin)));
		res.setTotalCotisationsPatronales( p.formaterBigDecimal(calculTotalCotisationsPatronales(bulletin)));
		res.setNetImposable( p.formaterBigDecimal(calculNetImposable(bulletin)));
		res.setNetAPayer( p.formaterBigDecimal(calculNetAPayer(bulletin)));
		
		
		
		return res;

	}

	
	private BigDecimal calculSalaireDeBase (BulletinSalaire bulletin){
		BigDecimal resultat;
		resultat = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		return resultat;
		
	}
	
	private BigDecimal calculSalaireBrut (BulletinSalaire bulletin){

		return (calculSalaireDeBase(bulletin).add(bulletin.getPrimeExceptionnelle()));
		
	}
	
	private BigDecimal calculTotalRetenueSalarial (BulletinSalaire bulletin){
		
		BigDecimal resultat = new BigDecimal("0");
		List<Cotisation> cot = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		
				for (Cotisation c : cot){
					
					if (c.getTauxSalarial()!=null)
					resultat = resultat.add(c.getTauxSalarial());		
				}
		
		return (resultat.multiply(calculSalaireBrut(bulletin)));
		
	}
	
	private BigDecimal calculTotalCotisationsPatronales (BulletinSalaire bulletin){

		
		BigDecimal resultat = new BigDecimal(0);
		List<Cotisation> cot = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		
		for (Cotisation c : cot){
			if (c.getTauxPatronal()!=null)
			resultat = resultat.add(c.getTauxPatronal());
		}

			return (resultat.multiply(calculSalaireBrut(bulletin)));
		
	}
	
	private BigDecimal calculNetImposable (BulletinSalaire bulletin){

		
		BigDecimal resu = new BigDecimal(p.formaterBigDecimal(calculSalaireBrut(bulletin)));
		BigDecimal res = new BigDecimal(p.formaterBigDecimal(calculTotalRetenueSalarial(bulletin)));
		return resu.subtract(res);
		
	}
	
	private BigDecimal calculNetAPayer (BulletinSalaire bulletin){

		
		BigDecimal resultat = new BigDecimal(0);
		List<Cotisation> cot = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		
		for (Cotisation c : cot){
			if (c.getTauxSalarial()!=null)
			resultat = resultat.add(c.getTauxSalarial());
		}

		
			return (calculNetImposable(bulletin).subtract(resultat.multiply(calculSalaireBrut(bulletin))));
		
	}
}
