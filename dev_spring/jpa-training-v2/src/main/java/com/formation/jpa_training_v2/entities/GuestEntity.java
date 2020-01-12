package com.formation.jpa_training_v2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class GuestEntity {
	
	/*********************************************************************
	 * Properties
	 *********************************************************************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name; 
	private String email;
	
	@ManyToMany(
		cascade= { CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinTable(
			joinColumns=@JoinColumn(name="guestId"),
			inverseJoinColumns=@JoinColumn(name="eventId")
	)
	private List<EventEntity> events;
	
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<EventEntity> getEvents() {
		return events;
	}

	public void setEvents(List<EventEntity> events) {
		this.events = events;
	}
	
	/*********************************************************************
	 * Constructors
	 *********************************************************************/
	public GuestEntity() {
		
	}
	
	public GuestEntity (String email, String name) {
		super();
		this.email 	= email;
		this.name 	= name;
		this.events = new ArrayList<EventEntity>();
		
	}
	
	
}
