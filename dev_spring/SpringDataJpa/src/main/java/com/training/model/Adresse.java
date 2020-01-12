package com.training.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresse")
public class Adresse implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	private Integer numero_rue;
	
	private String rue ;
	
	private String code_postale;
	
	private String ville;
	  
	private String pays;
	
	@ManyToOne(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
	)
	@JoinColumn(name="employee_id")
	private Employee employee;

	
	public Integer getNumero_rue() {
		return numero_rue;
	}

	public void setNumero_rue(Integer numero_rue) {
		this.numero_rue = numero_rue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Adresse() {
	}

	public Adresse(Integer numero_rue, String rue, String code_postale, String ville, String pays) {
		this.numero_rue = numero_rue;
		this.rue = rue;
		this.code_postale = code_postale;
		this.ville = ville;
		this.pays = pays;
	}
	
	
	
	

}
