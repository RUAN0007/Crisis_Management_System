package client;

import java.sql.Timestamp;

public class EventStatus {
	
	private String eventID;
	
	private String agencyName;
	
	private String status;
	
	private Timestamp dispatchTime;
	
	private Timestamp readTime;
	
	private Timestamp solveTime;
	
	

	

	private EventStatus(String eventID, String agencyName, String status,
			Timestamp dispatchTime, Timestamp readTime, Timestamp solveTime) {
		super();
		this.eventID = eventID;
		this.agencyName = agencyName;
		this.status = status;
		this.dispatchTime = dispatchTime;
		this.readTime = readTime;
		this.solveTime = solveTime;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public String getEventID() {
		return eventID;
	}

	public String getStatus() {
		return status;
	}

	public Timestamp getDispatchTime() {
		return dispatchTime;
	}

	public Timestamp getReadTime() {
		return readTime;
	}

	public Timestamp getSolveTime() {
		return solveTime;
	}

	
	
}
