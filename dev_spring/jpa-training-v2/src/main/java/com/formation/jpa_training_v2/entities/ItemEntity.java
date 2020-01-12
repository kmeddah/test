package com.formation.jpa_training_v2.entities;

import javax.persistence.*;

@Entity
public class ItemEntity {
	
	/*********************************************************************
	 * Properties
	 *********************************************************************/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Integer neededQuantity;
	private Integer currentQuantity;
	@ManyToOne
	private EventEntity events;
	
	
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
	
	public Integer getNeededQuantity() {
		return neededQuantity;
	}
	
	public void setNeededQuantity(Integer neededQuantity) {
		this.neededQuantity = neededQuantity;
	}
	
	public Integer getCurrentQuantity() {
		return currentQuantity;
	}
	
	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	
	public EventEntity getEvents() {
		return events;
	}
	
	public void setEvents(EventEntity events) {
		this.events = events;
	}
	
	
	/*********************************************************************
	 * Constructors
	 *********************************************************************/
	public ItemEntity() {
		
	}
	
	public ItemEntity (String name, Integer currentQuantity, Integer neededQuantity) {
		this.name 				= name;
		this.currentQuantity	= currentQuantity;
		this.neededQuantity		= neededQuantity;
	}
}
