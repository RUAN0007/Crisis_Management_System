package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model.Finder;

@Entity
public class Dispatch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public static Finder<Long, Dispatch> find 
		= new Finder<Long, Dispatch>(Long.class, Dispatch.class);

	@ManyToOne
    @JoinColumn(name="eventID")
	private Event event;
	
	@ManyToOne
    @JoinColumn(name="agencyID")
	private Agency agency;
	
	@Required
	private String status;
	
	private Timestamp dispatchTime;
	
	private Timestamp readTime;
	
	private Timestamp solveTime;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDispatchTime() {
		return dispatchTime;
	}

	public void setDispatchTime(Timestamp dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	public Timestamp getReadTime() {
		return readTime;
	}

	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}

	public Timestamp getSolveTime() {
		return solveTime;
	}

	public void setSolveTime(Timestamp solveTime) {
		this.solveTime = solveTime;
	}
	
	
}
