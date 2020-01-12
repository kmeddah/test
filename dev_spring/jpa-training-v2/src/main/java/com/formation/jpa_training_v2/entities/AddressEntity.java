package com.formation.jpa_training_v2.entities;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="AddressEntity.findAll", query = "from AddressEntity"),
	@NamedQuery(name="AddressEntity.findById", query = "from AddressEntity where id = :myId")
})
public class AddressEntity {
	/*********************************************************************
	 * Properties
	 *********************************************************************/
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(nullable = false)
	private Integer id;
	private String name;
	private String street;
	private String comments;
	private String zipCode;
	private String city;

	
	/*********************************************************************
	 * Gettes / Setters
	 *********************************************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/*********************************************************************
	 * Constructors
	 *********************************************************************/
	
	public AddressEntity() {
		
	}
	
	
	public AddressEntity( String name, String street, String comments, String zipCode, String city) {
		this.name 		= name;
		this.street 	= street;
		this.comments 	= comments;
		this.zipCode 	= zipCode;
		this.city		= city;
	}
	

}
