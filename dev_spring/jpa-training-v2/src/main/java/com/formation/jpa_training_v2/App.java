package com.formation.jpa_training_v2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.formation.jpa_training_v2.utils.HibernateUtils;
import com.formation.jpa_training_v2.entities.AddressEntity;
import com.formation.jpa_training_v2.entities.EventEntity;
import com.formation.jpa_training_v2.entities.GuestEntity;
import com.formation.jpa_training_v2.entities.ItemEntity;
import com.formation.jpa_training_v2.entities.UserEntity;

public class App 
{

	/*
	 * Declare variables
	 */
	private static Session s = null;
	private static Transaction tx = null;

	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        s = HibernateUtils.getSession();
    	tx = s.beginTransaction();
        testCreate();
        
    }
    
    private static void testCreate() {
    	
    	// Persistante objects created
    	EventEntity event 		= new EventEntity("Event title", "This is the description", true);
    	EventEntity secondEvent	= new EventEntity("Event without address", "this is my new description", false);
    	
    	// Create Address for one event
    	AddressEntity address 	= new AddressEntity("Address name", "20 Ferte Alle ", " Street comment", "23445", "Louise");
    	
    	// Create user
    	UserEntity user			= new UserEntity("gavoda", "gavoda@gmail.com", "password!gav");
    	UserEntity nuser		= new UserEntity("navoda", "navoda@gmail.com", "password!nav");
    	
    	// Create Item
    	ItemEntity item			= new ItemEntity("Orange Juce", 5, 0);
    	ItemEntity secondItem	= new ItemEntity("Chips", 3, 0);
    	ItemEntity thirdItem	= new ItemEntity("Pasta", 4, 0);
    	
    	// Create Guess
    	GuestEntity guest		= new GuestEntity("first@ajc.fr", "First guest");
    	GuestEntity secondGuest	= new GuestEntity("second@ajc.fr", "second guest");

    	
    	
    	item.setEvents(secondEvent);
    	secondItem.setEvents(secondEvent);
    	thirdItem.setEvents(secondEvent);
    	
    	event.setAddress(address);  // Set address for first event 
    	event.setUser(user);		// Set user for first event 
    	secondEvent.setUser(user);  // Only user for second event 
    	
    	// Liste des events
    	ArrayList<EventEntity> eventList 		= new ArrayList<EventEntity>(); // Event list for one user 
    	eventList.add(event);				// Add first event to listEvent
    	eventList.add(secondEvent);			// Add second event to list 
    	ArrayList<EventEntity> secondEventList	= new ArrayList<EventEntity>(); // Event list for one user 
    	secondEventList.add(event);				// Add first event to listEvent

    	// Liste des guests
    	ArrayList<GuestEntity> guestList		= new ArrayList<GuestEntity>();
    	guestList.add(secondGuest);
    	ArrayList<GuestEntity> secondGuestList		= new ArrayList<GuestEntity>();
    	secondGuestList.add(secondGuest);
    	
    	//////////////////////////////////////////
    	// Liaison Event & Items
    	////////////////////////////////////////
    	ArrayList<ItemEntity> itemList	=	new ArrayList<ItemEntity>();
    	itemList.add(item);
    	itemList.add(secondItem);
    	itemList.add(thirdItem);
    	secondEvent.setItems(itemList);
    	
    	
    	//////////////////////////////////////////
    	// Liaison Event et User
    	////////////////////////////////////////
    	user.setEventList(eventList);		// Set this event list to user
    	
    	
    	////////////////////////////////////////
    	// Liaison Guest & Event
    	////////////////////////////////////////
    	guest.setEvents(eventList);			// This guest is invited to two events
    	secondGuest.setEvents(secondEventList);	// This guest is invited to only one event
    	
    	////////////////////////////////////////
    	// Liaison Event & Guest
    	////////////////////////////////////////
    	event.setGuests(guestList);
    	secondEvent.setGuests(secondGuestList);
    	
    	
    	// Start transactions
    	s.persist(item);
    	s.persist(secondItem);
    	s.persist(thirdItem);
    	s.persist(guest);
    	s.persist(secondGuest);
    	s.persist(event);
    	s.persist(secondEvent);
    	s.persist(nuser);
    	
    	// Save data
    	
    	tx.commit();
    	// Show data.
    	printAddressEntity();
    	printEventEntity();
    	//printUsers();
    	printItems();
    	//printGuests();
    	
    }
    
    private static void printEventEntity() {
    	System.out.println("[EventsEntities]");
    	
    	// Create Query
//    	Query _query 						= s.createQuery("from EventEntity");
    	Query _query 						= s.createNamedQuery("EventEntity.findAll", EventEntity.class);
    	ArrayList<EventEntity> _eventList 	= (ArrayList<EventEntity>)_query.list(); 
    	
    	// Show data
    	for (EventEntity eventEntity : _eventList) {
    		System.out.println (
	    				"[id] 			= " + eventEntity.getId() + "\t" + 
	    				"[title] 		= " + eventEntity.getTitle() + "\t" +
	    				"[desc] 		= " + eventEntity.getDescription() + "\t" +
	    				"[date] 		= " + eventEntity.getBeginDate().getTime().toString()  + "\t" +
	    				"[allDay] 		= " + eventEntity.isAllDay()  
        			);
    		
    		if(eventEntity.getAddress() !=null)
    			System.out.println("[Address] 		= " + eventEntity.getAddress());
    		
    		if(eventEntity.getUser() != null)
    			System.out.println("[User] 		= " + eventEntity.getUser().getId());
		}
    	
    }
    
    
    private static void printAddressEntity() {
    	
    	System.out.println("[AddressEntity]");
    	
    	//Query _query 							= s.createQuery("from AddressEntity");
    	//Query _query 							= s.createNamedQuery("AddressEntity.findAll", AddressEntity.class);
    	Query _query 							= s.createNamedQuery("AddressEntity.findById", AddressEntity.class)
    												.setParameter("myId", 1);
    	
    	AddressEntity data = (AddressEntity)_query.uniqueResult();
    	
    	ArrayList<AddressEntity> _addressList 	= (ArrayList<AddressEntity>)_query.list(); 
    	
    	// Show data
    	for (AddressEntity addressEntity : _addressList) {
    		System.out.println (
	    				"[id] 							= " + addressEntity.getId() + "\t" + 
	    				"[Name] 						= " + addressEntity.getName() + "\t" +
	    				"[street] 						= " + addressEntity.getStreet() + "\t" +
	    				"[comments]						= " + addressEntity.getComments() + "\t" +
	    				"[zipcode] 						= " + addressEntity.getZipCode() + "\t" +
	    				"[city] 						= " + addressEntity.getCity()  
        			);
		}
    	
    }
    
    private static void printUsers() {
    	
    	System.out.println("[Users]");
    	
    	// Create Query
    	Query _query 							= s.createQuery("from UserEntity");
    	ArrayList<UserEntity> _userList 	= (ArrayList<UserEntity>)_query.list(); 
    	
    	// Show data
    	for (UserEntity userEntity : _userList) {
    		System.out.println (
	    				"[id] 							= " + userEntity.getId() + "\t" + 
	    				"[login] 						= " + userEntity.getLogin() + "\t" +
	    				"[email] 						= " + userEntity.getEmail() + "\t" +
	    				"[pass]							= " + userEntity.getPassword()
        			);
    		
    		if(userEntity.getEventList() != null) {
    			System.out.println("------------- Events ---------------");
    			for (EventEntity event : (List<EventEntity>)userEntity.getEventList()) {
    				System.out.println("------------- Event Id : ---------------" + event.getId() + " title => " + event.getTitle());
				}
    		}
		}
    	
    }
    
    private static void printGuests() {
    	
    	System.out.println("-------- [Guests] ------------");
    	
    	// Create Query
    	Query _query 						= s.createQuery("from GuestEntity");
    	ArrayList<GuestEntity> _guestList 	= (ArrayList<GuestEntity>)_query.list(); 
    	
    	// Show data
    	for (GuestEntity guestEntity : _guestList) {
    		System.out.println (
    						"[id] 							= " + guestEntity.getId() + "\t" + 
    						"[name] 						= " + guestEntity.getName() + "\t" +
    						"[email] 						= " + guestEntity.getEmail() 
    				);
    		
    		if(guestEntity.getEvents() != null) {
    			System.out.println("------------- Events ---------------");
    			for (EventEntity event : (List<EventEntity>)guestEntity.getEvents()) {
    				System.out.println("------------- Event Id : ---------------" + event.getId() + " title => " + event.getTitle());
    			}
    		}
    	}
    	
    }
    
    private static void printItems() {
    	
    	System.out.println("[Items]");
    	
    	// Create Query
    	// Query _query 						= s.createQuery("from ItemEntity");
    	
    	///////////////////////////////////////////
    	// Native query : TO SHOW
    	///////////////////////////////////////////
    	Query _query 						= s.createNativeQuery("select * from ItemEntity", ItemEntity.class);

    	ArrayList<ItemEntity> _itemList 	= (ArrayList<ItemEntity>)_query.list(); 
    	
    	// Show data
    	for (ItemEntity itemEntity : _itemList) {
    		System.out.println (
    						"[id] 							= " + itemEntity.getId() + "\t" + 
    						"[name] 						= " + itemEntity.getName() + "\t" +
    						"[currentQuantity] 			= " + itemEntity.getCurrentQuantity() + "\t" +
    						"[neededQuantity]				= " + itemEntity.getNeededQuantity()
    				);
    		
    	}
    	
    }
}
