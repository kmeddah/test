package com.formation.jpa_training_v2.entities;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "EventEntity.findAll", query = "from EventEntity"),
	@NamedQuery(name = "EventEntity.findById", query = "from EventEntity where id = :myId")
})
public class EventEntity {
	
	/*********************************************************************
	 * Properties
	 *********************************************************************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;
	@Basic(fetch = FetchType.LAZY, optional = true)
	private String title;
	private String description;
	@Temporal(TemporalType.DATE)
	private Calendar beginDate;
	private boolean allDay;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(
				name= "events_addressID",
				referencedColumnName="id"
			)
	private AddressEntity address;
	@ManyToOne(
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
	)
	@JoinColumn(name="events_userID")
	private UserEntity user;
	
	@OneToMany(mappedBy="events")
	private List<ItemEntity> items;
	
	@ManyToMany(mappedBy = "events")
	private List<GuestEntity> guests;
	
	
	/*********************************************************************
	 * Gettes / Setters
	 *********************************************************************/
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Calendar getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}
	
	public boolean isAllDay() {
		return allDay;
	}
	
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	
	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	
	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public List<GuestEntity> getGuests() {
		return guests;
	}

	public void setGuests(List<GuestEntity> guests) {
		this.guests = guests;
	}
	
	
	/*********************************************************************
	 * Constructors
	 *********************************************************************/
	
	public EventEntity() {
		
	}
	
	public EventEntity(String title, String description, boolean allDay) {
		this.title 			= title;
		this.description 	= description;
		this.allDay			= allDay;
		this.beginDate		= Calendar.getInstance();
		
		/*this.beginDate 		= new GregorianCalendar(
								new SimpleTimeZone(3600000, "Europe/Paris", 
										Calendar.MARCH, -1, Calendar.SUNDAY, 3600000, SimpleTimeZone.UTC_TIME,
										Calendar.OCTOBER, -1, Calendar.SUNDAY, 3600000, SimpleTimeZone.UTC_TIME,
										3600000)
								);*/ 
	}
}
