package controllers;

import java.util.ArrayList;

import models.Event;
import broadcaster.ResourceGenerator;
import filter.BroadcastEventFilter;
import filter.DatabaseEventFilter;
import filter.DispatchEventFilter;
import filter.EventFilter;

/**
 * EventHandlerPool is responsible to handle the reported event from call operator.
 * EventHandlerPool holds multiple eventFilter pipes.
 * It will pass the event to the pipe with the shortest queue. 
 * @author ruanpingcheng
 *
 */
public class EventHandlerPool {
	private  ArrayList<EventFilter> eventFilterPipes;
	public EventHandlerPool(int eventFilterPipeCount) {
		this.eventFilterPipes = new ArrayList<EventFilter>();
		
		for(int i = 0;i < eventFilterPipeCount;i++){
			this.eventFilterPipes.add(constructEventFilterPipe());
		}
		
	}
	private EventFilter constructEventFilterPipe() {
		ResourceGenerator resourceGenerator = ResourceGenerator.getDefaultResourceGenerator();
		DatabaseEventFilter firstEventFilter = new DatabaseEventFilter(10);
		firstEventFilter.start();
		
		BroadcastEventFilter secondEventFilter = new BroadcastEventFilter(10,
																		resourceGenerator.getEventFormatter(),
																		resourceGenerator.getNewTwitterSender(),
																		resourceGenerator.getNewFBSender()
																		);
		secondEventFilter.start();
		
		DispatchEventFilter thirdEventFilter = new DispatchEventFilter(10,resourceGenerator.getNewSMSSender());
		thirdEventFilter.start();
		
		firstEventFilter.setNextFilter(secondEventFilter);
		secondEventFilter.setNextFilter(thirdEventFilter);
		
		//TODO
		//Add the event type dependent filter later
		return firstEventFilter;
	}
	
	/**
	 * Pass the reported event to process
	 * @param reportedEvent
	 * @return the result whether the event is accepted. 
	 */
	public boolean  handleReportedEvent(Event reportedEvent) {
		EventFilter selectedPipe = findPipeWithMinQueue();
		return selectedPipe.enqueueEvent(reportedEvent);
	}
	
	/**
	 * Find the event filter pipe with minumun queue
	 * @return
	 */
	private EventFilter findPipeWithMinQueue(){
		int minEventInQueueCount = Integer.MAX_VALUE;
		EventFilter filterWithMinQueue = null;
		
		for(EventFilter filterPipe:this.eventFilterPipes){
			int queueSize = filterPipe.getQueueLength();
			if(queueSize < minEventInQueueCount){
				minEventInQueueCount = queueSize;
				filterWithMinQueue = filterPipe;
			}
		}
		
		assert(filterWithMinQueue != null);
		return filterWithMinQueue;
	}

}
