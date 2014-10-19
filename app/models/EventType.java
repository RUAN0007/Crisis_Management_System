package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class EventType extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	 public static Finder<Long, EventType> find = new Finder<Long, EventType>(
			 Long.class, EventType.class
	    ); 
	 
	@Required
	private String eventType;
	
	@Lob
	private String description;
	
	@ManyToMany
	private List<Agency> responsibleAgencies;

	public Long getId() {
		return id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setResponsibleAgencies(List<Agency> responsibleAgencies) {
		this.responsibleAgencies = responsibleAgencies;
	}

	public String getDescription() {
		return description;
	}

	public List<Agency> getResponsibleAgencies() {
		return responsibleAgencies;
	}
	
	
}
