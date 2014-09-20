package controllers;

import java.sql.Timestamp;
import java.util.*;

import models.*;
public class EventCenter {
	private static EventCenter defaultCenter = new EventCenter();

	
	
	private EventCenter() {
		super();
	}


	public static EventCenter getDefaultDispatchCenter(){
		return defaultCenter;
	}
	
	public List<Dispatch> dispatch(Event event){
		List<Agency> responsibleAgencies = event.getEventType().getResponsibleAgencies();
		List<Dispatch> dispatches = new ArrayList<Dispatch>();
		for(Agency agency:responsibleAgencies){
			Dispatch dispatch = new Dispatch();
			dispatch.setAgency(agency);
			dispatch.setEvent(event);
			dispatch.setDispatchTime(new Timestamp(System.currentTimeMillis()));
		
			dispatches.add(dispatch);
			//TODO
			//Send SMS to the agency
			//Should be a pipe-and-filter architecture
		}
		return dispatches;
	}
	
	public List<Notification> notify(Event event){
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		int priority = event.getPriority();
		if(priority >= 2){
			//TODO
			//Send to social media
			//Should be a pipe-and-filter architecture

			Notification ntfc = new Notification();
			ntfc.setEvent(event);
			//TODO
			//ntfc.setMediaType(mediaType);
			ntfc.setSendTime(new Timestamp(System.currentTimeMillis()));
		}
		return notifications;
	}
	
	
	
}
