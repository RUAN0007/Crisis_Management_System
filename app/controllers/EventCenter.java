package controllers;


import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import util.HelperClass;

import com.avaje.ebean.Ebean;

import broadcaster.*;
import formatter.*;
import models.*;
public class EventCenter {
	
	static EventCenter defaultCenter;
	
	private static String MEDIA_SMS = "SMS";
	private static String MEDIA_FB = "FACEBOOK";
	private static String MEDIA_TWITTER = "TWITTER";
	private static String MEDIA_Email = "Email";

	
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

	public static boolean setDefaultEventCenter(EventCenter ec){
		if(defaultCenter == null){
			defaultCenter = ec;
			return true;
		}else{
			return false;
		}
	}

	public static  EventCenter getDefaultEventCenter(){
		return defaultCenter;
	}
	
	
	public void handleIncomingEvent(Event event){
		//Dispatch to the agency
		List<Dispatch> dispatches = dispatch(event);
		Ebean.save(dispatches);
		
		//Broadcast to the public
		List<Notification> notifications = broadcast(event);
		Ebean.save(notifications);
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
		String location = event.getLocation();
		List<Public> citizens = Public.find
								.where()
								.eq("location =", location)
								.findList();
		
		List<String> phones = new ArrayList<>();
		for(Public citizen:citizens){
			phones.add(citizen.getHandPhone());
		}
		
		String message = eventFormatter.formatSMS(event);
		
		//Save the notification
		if(smsSender.SendSMS(message, phones)){
			Notification ntfc = new Notification();
			ntfc.setEvent(event);
			ntfc.setMediaType(MEDIA_SMS);
			ntfc.setSendTime(HelperClass.getCurrentTimestamp());
			ntfc.save();
			
			return true;
		}else{
			return false;
		}
		
	}



	
	//Broadcast both on facebook and twitter
	public boolean broadcastEventOnSocialMedia(Event event){
		String message = eventFormatter.formatSocialMedia(event);
		return fbSender.postMessage(message) && twitterSender.postMessage(message);
	}
	
	private String getPMEmail(){
		Agency primeMinster = Agency.find.byId((long)0);
		return primeMinster.getEmail();
	}
	
	public boolean sendEventReport(Event event){
		String reportName = "EmergencyReportOnEvent" + event.getId() + ".pdf";
		File report = pdfGenerator.generateEmergencyReport(event,reportName);
		String file = pdfGenerator.getEmergyReportDirectory() + File.separator + report.getName();
		
		String subject = "Emergency Report";
		String text = "Dear Prime Minister, \nThere is an emergent event on " + event.getLocation() 
						+ ". Refer to the attachment for details."; 
		List<String> destinations = new ArrayList<String>();
		destinations.add(getPMEmail());
		return emailSender.SendMail(destinations, subject, text, file);
	}
	
	public List<Event> getEventsWithinMin(int periodInMin){
		long lowerTimeBound = System.currentTimeMillis() - periodInMin * 60 * 1000;
		List<Event> events = Event.find.where()
									   .gt("callingTime", lowerTimeBound)
									   .orderBy("callingTime desc")

									   .findList();
		return events;
	}
	
	public List<Event> getEventsWithinMin(int periodInMin,Long typeID){
		long lowerTimeBound = System.currentTimeMillis() - periodInMin * 60 * 1000;
		List<Event> events = Event.find.where()
									   .gt("callingTime", lowerTimeBound)
									   .eq("eventType.id", typeID)
									   .orderBy("callingTime desc")
									   .findList();
		return events;
	}
	
	public boolean sendSummaryReport(int periodInMin){
		List<Event> events = getEventsWithinMin(periodInMin);
				
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy_hh:mm",Locale.US);
		Date date = new Date();
		String time = dateFormat.format(date);
		
		String subject = "Summary Report";
		String text = "Dear Prime Minister, \nThis is a summary event at " + time 
				+ ". Refer to the attachment for details."; 
		String reportName = "SummaryReportAt" + time;
		
		File report = pdfGenerator.generateReport(events, reportName);
		String reportFilePath = pdfGenerator.getSummaryReportDirectory() + File.separator + report.getName();
		
		List<String> destinations = new ArrayList<String>();
		destinations.add(getPMEmail());
		return emailSender.SendMail(destinations, subject, text, reportFilePath);
	}
	
	public  List<Notification> broadcast(Event event){
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		int priority = event.getPriority();
		if(priority <= 2){
			if(broadcastEventOnSocialMedia(event)){
				Notification fbNtfc = new Notification();
				fbNtfc.setEvent(event);
				fbNtfc.setSendTime(new Timestamp(System.currentTimeMillis()));
				fbNtfc.setMediaType(MEDIA_FB);
				notifications.add(fbNtfc);
				
				Notification twNtfc = new Notification();
				twNtfc.setEvent(event);
				twNtfc.setSendTime(new Timestamp(System.currentTimeMillis()));
				twNtfc.setMediaType(MEDIA_TWITTER);
				notifications.add(twNtfc);
			}
			
		}
		return notifications;
	}
	
	
	
}
