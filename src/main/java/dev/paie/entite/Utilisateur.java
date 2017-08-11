package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class Utilisateur {

	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (name = "nom")
	private String nomUtilisateur;
	@Column (name = "password")
	private String nomDePasse;
	@Column (name = "actif")
	private Boolean estActivf;
	@Column (name = "role")
	@Enumerated(EnumType.STRING)
	private ROLES role;
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getNomDePasse() {
		return nomDePasse;
	}
	public void setNomDePasse(String nomDePasse) {
		this.nomDePasse = nomDePasse;
	}
	public Boolean getEstActivf() {
		return estActivf;
	}
	public void setEstActivf(Boolean estActivf) {
		this.estActivf = estActivf;
	}
	public ROLES getRole() {
		return role;
	}
	public void setRole(ROLES role) {
		this.role = role;
	}
	
	
	
	
	
	
}
