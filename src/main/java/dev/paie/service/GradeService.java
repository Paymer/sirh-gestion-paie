package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

public interface GradeService {

	void sauvegarder (Grade noveauGrade);
	void mettreAJour (Grade grade);
	List<Grade> lister();
	
}
