package com.formation.jpa_training_v2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class UserEntity {

	/*********************************************************************
	 * Properties
	 *********************************************************************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	private String login;
	private String email;
	private String password;
	@OneToMany(mappedBy="user")
	private List<EventEntity> eventList;
	
	/*********************************************************************
	 * Gettes / Setters
	 *********************************************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List getEventList() {
		return eventList;
	}

	public void setEventList(List eventList) {
		eventList = eventList;
	}
	
	/*********************************************************************
	 * Constructors
	 *********************************************************************/
	public UserEntity() {
		
	}

	public UserEntity(String login, String email, String password) {
		this.login = login;
		this.email = email;
		this.password = password;
		this.eventList = new ArrayList<EventEntity>();
	}
}
