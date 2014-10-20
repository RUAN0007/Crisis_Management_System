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
/**
 * This class processes events reported from call operators
 * @author ruanpingcheng
 *
 */
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
	/**
	 * This method enqueue the new event to event queue
	 * @param incomingEvent the new event to be reported
	 */
	public  void  enqueueEvent(Event incomingEvent){
		synchronized(eventQueue){
			 eventQueue.add(incomingEvent);
		}
	}
	/**
	 *This method returns the current queue size
	 @return event queue size
	 */
	public int getQueueSize(){
		synchronized(eventQueue){
			 return eventQueue.size();
		}
	}
	
	/**
	 * In this method, an infinite loops continuously check the status of queue
	 * If not empty, it will dequeue the first event and process it. 
	 */
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
	/**
	 * Constructor of IncomingEventHandler with necessary building blocks
	 * @param smsSender
	 * @param fbSender
	 * @param twitterSender
	 * @param eventFormatter
	 */
	public IncomingEventHandler(SMSSender smsSender, FacebookSender fbSender,
			TwitterSender twitterSender, EventFormatter eventFormatter) {
		super();
		this.smsSender = smsSender;
		this.fbSender = fbSender;
		this.twitterSender = twitterSender;
		this.eventFormatter = eventFormatter;
	}

	/**
	 * This method encapsulates the logic to handle the new event
	 * @param event the newly reported event
	 */
	private void handleIncomingEvent(Event event){
		
		event.save();
		
		//This event is already classified . 
		if(event.getEventType().getId() != 0){
			//Dispatch to the agency
			List<Agency> responsibleAgencies = event.getEventType().getResponsibleAgencies();
			dispatch(event,responsibleAgencies);
		}
		
		
		//Broadcast to the public
		if(event.getPriority() <= 2){
			broadcast(event);
		}
	}
	
	/**
	 * This method dispatches the events to its corresponding agencies
	 * @param event the newly reported event
	 * @param agencies the responsible agencies
	 */
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
	
	/**
	 * This method send SMS to agency to inform them of a new event 
	 * @param agencies repsonsible agencies
	 * @param sms the event to be smsed
	 * @return
	 */
	private boolean sendEventSMSToAgency(List<Agency> agencies,Event sms){
		List<String> phones = new ArrayList<>();
		for(Agency agency:agencies){
			phones.add(agency.getPhone());
		}
		
		return	smsSender.SendSMS("You have an incoming event", phones);
		
	}
	
	/**
	 * This method broadcast event to social media based on its priority
	 * @param event the event to be broadcasted
	 */
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
	
/**
 * This method broadcast events to social media
 * @param event the event to be broadcasted
 * @return
 */
	private boolean broadcastEventOnSocialMedia(Event event){
		String message = eventFormatter.formatSocialMedia(event);
		return 
			//	fbSender.postMessage(message) &&
				twitterSender.postMessage(message);
	}

}
