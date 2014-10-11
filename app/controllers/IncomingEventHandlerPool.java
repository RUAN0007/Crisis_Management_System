package controllers;

import java.util.ArrayList;

import models.Event;
import broadcaster.EventFormatter;
import broadcaster.ResourceGenerator;

public class IncomingEventHandlerPool {

	public static IncomingEventHandlerPool defaultIncomingEventHandlerPool = null;

	public static IncomingEventHandlerPool getDefault(){
		if(defaultIncomingEventHandlerPool == null){
			defaultIncomingEventHandlerPool = new IncomingEventHandlerPool(10,1);
		}
		return defaultIncomingEventHandlerPool;
	}

	private  ArrayList<IncomingEventHandler> incomingEventHandlers;

	private int maxEventCountInQueue;
	
	private IncomingEventHandlerPool(int maxEventCountInQueue,int eventHandlerCount){

		this.maxEventCountInQueue = maxEventCountInQueue;
		
		this.incomingEventHandlers = new ArrayList<>();
		ResourceGenerator defaultResourceGenerator = ResourceGenerator.getDefaultResourceGenerator();

		for(int eventHanderID = 0;eventHanderID < eventHandlerCount;eventHanderID++){
			
			IncomingEventHandler eventHandler = new IncomingEventHandler(
																		defaultResourceGenerator.getNewSMSSender(),
																		defaultResourceGenerator.getNewFBSender(), 
																		defaultResourceGenerator.getNewTwitterSender(), 
																		new EventFormatter()
																		);
			
			eventHandler.start();
			this.incomingEventHandlers.add(eventHandler);	
		}
		

	}

	public void handleIncomingEvent(Event incomingEvent) {
		IncomingEventHandler eventHandler = getEventHanlderWithMinQueueLength();
		eventHandler.enqueueEvent(incomingEvent);
	}
	
	private IncomingEventHandler getEventHanlderWithMinQueueLength(){
		IncomingEventHandler eventHanlderWithMinQueueLength = null;
		int minEventInQueueCount = Integer.MAX_VALUE;
		
		for(IncomingEventHandler eventHandler:this.incomingEventHandlers){
			if(eventHandler.getQueueSize() < minEventInQueueCount){
				minEventInQueueCount = eventHandler.getQueueSize();
				eventHanlderWithMinQueueLength = eventHandler;
			}
		}
		
		assert(eventHanlderWithMinQueueLength != null);
		return eventHanlderWithMinQueueLength;
	}

}
