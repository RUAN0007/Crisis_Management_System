

import java.sql.Timestamp;
import java.util.*;

import com.avaje.ebean.Ebean;

import broadcaster.*;
import formatter.*;
import models.*;
public class EventCenter {
	
	static EventCenter defaultCenter = new EventCenter();
	
	private EmailSender emailSender;
	private SMSSender smsSender;
	private FacebookSender fbSender;
	private TwitterSender twitterSender;
	
	private EventFormatter eventFormatter;
	private PDFGenerator pdfGenerator;
	
	
	private EventCenter() {
		super();
	}

	

	public EventCenter(EmailSender emailSender, SMSSender smsSender,
			FacebookSender fbSender, TwitterSender twitterSender,
			EventFormatter eventFormatter, PDFGenerator pdfGenerator) {
		super();
		this.emailSender = emailSender;
		this.smsSender = smsSender;
		this.fbSender = fbSender;
		this.twitterSender = twitterSender;
		this.eventFormatter = eventFormatter;
		this.pdfGenerator = pdfGenerator;
	}



	public static  EventCenter getDefaultDispatchCenter(){
		return defaultCenter;
	}
	
	
	public void handleIncomingEvent(Event event){
		List<Dispatch> dispatches = dispatch(event);
		Ebean.save(dispatches);
	}
	
	private  List<Dispatch>  dispatch(Event event){
		List<Agency> responsibleAgencies = event.getEventType().getResponsibleAgencies();
		List<Dispatch> dispatches = new ArrayList<Dispatch>();
		for(Agency agency:responsibleAgencies){
			Dispatch dispatch = new Dispatch();
			dispatch.setAgency(agency);
			dispatch.setEvent(event);
			dispatch.setDispatchTime(new Timestamp(System.currentTimeMillis()));
		
			dispatches.add(dispatch);
			
		}
		//TODO
		//Send SMS to the responsible agencies
		sendEventSMSToAgency(responsibleAgencies, event);
		return dispatches;
	}
	
	public boolean sendEventSMSToAgency(List<Agency> agencies,Event sms){
		List<String> phones = new ArrayList<>();
		for(Agency agency:agencies){
			phones.add(agency.getPhone());
		}
		
		return	smsSender.SendSMS("You have an incomg event", phones);
		
	}
	
	//Only the citizen in related region will be notified
	public boolean broadcastSMSToPublic(Event event){
		return true;
	}
	
	public boolean broadcastEventOnSocialMedia(Event event){
		return true;
	}
	
	public boolean sendEventReport(Event event){
		return true;
	}
	
	public boolean sendPeriodicReport(int periodInMin){
		return true;
	}
	
	public  List<Notification> notify(Event event){
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
