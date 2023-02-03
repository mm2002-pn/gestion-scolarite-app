package sn.gestionscolarite.model;

import java.time.LocalDate;

public class Eleve {
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private int indentifiant ;
	private String formation;
	private String classe;
	private char sexe;
	
	public Eleve(String nom, String prenom, LocalDate dateNaissance, String formation,char sexe,String classe) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.formation = formation;
		this.sexe=sexe;
		this.classe=classe;
	}
	
	public Eleve(int id,String nom, String prenom, LocalDate dateNaissance, String formation,char sexe,String classe) {
		this.indentifiant = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.formation = formation;
		this.sexe=sexe;
		this.classe=classe;
	}
	
	
		
	/**
	 * @return the sexe
	 */
	public char getSexe() {
		return sexe;
	}


	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}



	/**
	 * @return the classe
	 */
	public String getClasse() {
		return classe;
	}



	/**
	 * @param classe the classe to set
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the age
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	/**
	 * @param age the age to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	/**
	 * @return the indentifiant
	 */
	public int getIndentifiant() {
		return indentifiant;
	}

	/**
	 * @param indentifiant the indentifiant to set
	 */
	public void setIndentifiant(int indentifiant) {
		this.indentifiant = indentifiant;
	}

	/**
	 * @return the formation
	 */
	public String getFormation() {
		return formation;
	}

	/**
	 * @param formation the formation to set
	 */
	public void setFormation(String formation) {
		this.formation = formation;
	}
	
	
	

}
