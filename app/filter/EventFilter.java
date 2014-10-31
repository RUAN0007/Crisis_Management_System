package filter;

import java.util.LinkedList;

import models.Event;

/**
 * The filter to process the event
 * After the processing, the event will be passed to the next filter to process, if not null. 
 * @author ruanpingcheng
 *
 */
public abstract class EventFilter extends Thread {
	
	
	private LinkedList<Event> eventQueue = new LinkedList<Event>();
	private int queueSizeLimit;
	private EventFilter nextFilter= null;
	
	public EventFilter(int queueSizeLimit,EventFilter nextFilter) {
		this.queueSizeLimit = queueSizeLimit;
		this.nextFilter = nextFilter;
	} 
	
	public EventFilter(int queueSizeLimit){
		this(queueSizeLimit, null);
	}
	
	/**
	 * return the event queue
	 * @return
	 */
	public int getQueueLength(){
		int size;
		synchronized (eventQueue) {
			size = eventQueue.size();
		}
		return size;
	}
	
	/**
	 * Set the next filter to pass on the event
	 * @param nextFilter
	 */
	public void setNextFilter(EventFilter nextFilter){
		this.nextFilter = nextFilter;
	}
	
	/**
	 * Enqueue the event
	 * If the queue size is more than the limit,
	 * the event will not be enqueued and return false
	 * @param event
	 * @return whether the event has been enqueued
	 */
	public boolean enqueueEvent(Event event){
		boolean result = false;
		synchronized (eventQueue) {
			int size = eventQueue.size();
			if(size == queueSizeLimit){
				result = false;
			}else{
				this.eventQueue.add(event);
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * If the event queue is empty, sleep the thread for 100 ms
	 * If not, poll the first event, process it and pass it the next filter
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
				this.process(event);
				while(!this.nextFilter.enqueueEvent(event)){
					//Do nothing
				}//End of while
			}//End of if
		}//End of while(true)
	}//End of method
	
	protected abstract void process(Event event);
}
