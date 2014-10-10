package controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import broadcaster.EventFormatter;
import broadcaster.FacebookSender;
import broadcaster.SMSSender;
import broadcaster.TwitterSender;

import com.avaje.ebean.Ebean;

import models.Agency;
import models.Dispatch;
import models.Event;
import models.Notification;

public class IncomingEventHandler extends Thread{
	private static String MEDIA_SMS = "SMS";
	private static String MEDIA_FB = "FACEBOOK";
	private static String MEDIA_TWITTER = "TWITTER";
	private static String MEDIA_Email = "Email";

	
	private SMSSender smsSender;
	private FacebookSender fbSender;
	private TwitterSender twitterSender;
	
	private EventFormatter eventFormatter;

	private LinkedList<Event> eventQueue = new LinkedList<>();
	
	public  void  enqueueEvent(Event incomingEvent){
		synchronized(eventQueue){
			 eventQueue.add(incomingEvent);
		}
	}
	
	public int getQueueSize(){
		synchronized(eventQueue){
			 return eventQueue.size();
		}
	}
	
	@Override
	public void run(){
		Event event = null;
		while(true){

			synchronized(eventQueue){
				event = this.eventQueue.pollFirst();
			}
			if(event == null){
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}else{
				this.handleIncomingEvent(event);
			}
		}
	
	}
	
	public IncomingEventHandler(SMSSender smsSender, FacebookSender fbSender,
			TwitterSender twitterSender, EventFormatter eventFormatter) {
		super();
		this.smsSender = smsSender;
		this.fbSender = fbSender;
		this.twitterSender = twitterSender;
		this.eventFormatter = eventFormatter;
	}

	private void handleIncomingEvent(Event event){
		
		event.save();
		
		//This event is already classified . 
		if(event.getEventType().getId() != 0){
			//Dispatch to the agency
			List<Agency> responsibleAgencies = event.getEventType().getResponsibleAgencies();
			dispatch(event,responsibleAgencies);
		}
		
		
		//Broadcast to the public
		broadcast(event);
	}
	
	private  void  dispatch(Event event,List<Agency> agencies){
		List<Dispatch> dispatches = new ArrayList<Dispatch>();

		for(Agency agency:agencies){
			Dispatch dispatch = new Dispatch();
			dispatch.setAgency(agency);
			dispatch.setStatus(Dispatch.STATUS_SENT);
			dispatch.setEvent(event);
			dispatch.setDispatchTime(new Timestamp(System.currentTimeMillis()));
		
			dispatches.add(dispatch);
			
		}
		Ebean.save(dispatches);
		sendEventSMSToAgency(agencies, event);		
	}
	
	private boolean sendEventSMSToAgency(List<Agency> agencies,Event sms){
		List<String> phones = new ArrayList<>();
		for(Agency agency:agencies){
			phones.add(agency.getPhone());
		}
		
		return	smsSender.SendSMS("You have an incoming event", phones);
		
	}
	
	private  void broadcast(Event event){
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		int priority = event.getPriority();
		if(priority <= 2){
			if(broadcastEventOnSocialMedia(event)){
				//
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
		Ebean.save(notifications);
	}
	
	//Broadcast both on facebook and twitter
	private boolean broadcastEventOnSocialMedia(Event event){
		String message = eventFormatter.formatSocialMedia(event);
		return 
				//fbSender.postMessage(message) &&
				twitterSender.postMessage(message);
	}

}
