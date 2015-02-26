package com.servicepays.services.exceptions;

public class PaysNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -636385240322677073L;

	private int id;
	private String nom;
	private String codepays;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the codepays
	 */
	public String getCodepays() {
		return codepays;
	}
	/**
	 * @param codepays the codepays to set
	 */
	public void setCodepays(String codepays) {
		this.codepays = codepays;
	}

}
