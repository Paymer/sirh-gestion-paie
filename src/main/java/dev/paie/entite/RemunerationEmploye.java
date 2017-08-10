package dev.paie.entite;


import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "RemunerationEmploye")
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "matricule")
	private String matricule;
	
	@ManyToOne
	@JoinColumn(name="enterprise_id")
	private Entreprise entreprise;
	
	@ManyToOne
	@JoinColumn(name="profilRemuneration_id")
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade;
	
	@Column (name = "dateCreation")
	private ZonedDateTime dateCreation;
	
	
	
	public ZonedDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
