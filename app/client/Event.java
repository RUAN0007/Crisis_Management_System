package client;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;



public class Event {

	
	private long id;

	private String eventType;
	private int priority;
	
	private Timestamp callingTime;
	private String postalCode;

	private String location;
	private String callerPhone;
	private String description;
	
   

	public Event(long id, String eventType, int priority,
			Timestamp callingTime, String postalCode, String location,
			String callerPhone, String description) {
		super();
		this.id = id;
		this.eventType = eventType;
		this.priority = priority;
		this.callingTime = callingTime;
		this.postalCode = postalCode;
		this.location = location;
		this.callerPhone = callerPhone;
		this.description = description;
	}

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

}
