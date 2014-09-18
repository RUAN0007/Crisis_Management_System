package models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model.Finder;

@Entity
public class Event {
	@Id
	private long id;
	
	public static Finder<Long, Event> find 
		= new Finder<Long, Event>(Long.class, Event.class);
	private String eventType;
	private int priority;
	
	@Required
	private Timestamp callingTime;
	@Required
	private String postalCode;
	@Required
	private String location;
	@Required
	private String callerPhone;
	@Lob
	private String description;
	
    @ManyToOne
	@JoinColumn(name="callOperator_id")
    private CallOperator callOperator;
    
	@ManyToOne
	@JoinColumn(name="serviceOperator_id")
	private ServiceOperator serviceOperator;
	
	@OneToMany(mappedBy="event",cascade = CascadeType.REMOVE)
	private List<Dispatch> dispatches;
	
	@OneToMany(mappedBy="event", cascade = CascadeType.REMOVE)
	private List<Notification> notifications;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Timestamp getCallingTime() {
		return callingTime;
	}

	public void setCallingTime(Timestamp callingTime) {
		this.callingTime = callingTime;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCallerPhone() {
		return callerPhone;
	}

	public void setCallerPhone(String callerPhone) {
		this.callerPhone = callerPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CallOperator getCallOperator() {
		return callOperator;
	}

	public void setCallOperator(CallOperator callOperator) {
		this.callOperator = callOperator;
	}

	public ServiceOperator getServiceOperator() {
		return serviceOperator;
	}

	public void setServiceOperator(ServiceOperator serviceOperator) {
		this.serviceOperator = serviceOperator;
	}

	public List<Dispatch> getDispatches() {
		return dispatches;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}
	
	
	
}
