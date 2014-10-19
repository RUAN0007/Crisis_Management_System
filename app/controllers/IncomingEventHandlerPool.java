package controllers;

import java.util.ArrayList;

import models.Event;
import broadcaster.EventFormatter;
import broadcaster.ResourceGenerator;
/**
 * IncomingEventHandlerPool holds multiple IncomingEventHandlers. 
 * It has the mechanism to dispatch a new event to a incomingEventHandlers
 * @author ruanpingcheng
 *
 */
public class IncomingEventHandlerPool {

	public static IncomingEventHandlerPool defaultIncomingEventHandlerPool = null;

	public synchronized static IncomingEventHandlerPool getDefault(){
		if(defaultIncomingEventHandlerPool == null){
			defaultIncomingEventHandlerPool = new IncomingEventHandlerPool(10);
		}
		return defaultIncomingEventHandlerPool;
	}

	private  ArrayList<IncomingEventHandler> incomingEventHandlers;

	/**
	 * Constructor IncomingEventHandlerPool
	 * @param eventHandlerCount the number of initial eventHandler
	 */
	public IncomingEventHandlerPool(int eventHandlerCount){

		
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

	/**
	 * This method handles the incoming event
	 * It will enqueue the event to the idlest event handler
	 * @param incomingEvent the newly reported event
	 */
	public void  handleIncomingEvent(Event incomingEvent) {
		IncomingEventHandler eventHandler = getEventHanlderWithMinQueueLength();
		eventHandler.enqueueEvent(incomingEvent);
	}
	
	/**
	 * 
	 * @return whether the event queue is empty
	 */
	//For performance testing
	public boolean isIdle(){
		for(IncomingEventHandler eventHandler:this.incomingEventHandlers){
			if(eventHandler.getQueueSize() > 0) return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return the IncomingEventHandler with the shortest queue
	 */
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
