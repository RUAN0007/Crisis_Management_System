package filter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;

import broadcaster.SMSSender;
import models.Agency;
import models.Dispatch;
import models.Event;

/**
 * DispatchEventFilter will dispatch the event to the responsible agencies based on event type
 * The responsible agency will be notified via SMS for reported event. 
 * @author ruanpingcheng
 *
 */
public class DispatchEventFilter extends EventFilter {

	private SMSSender sms;
	public DispatchEventFilter(int queueSizeLimit, EventFilter nextFilter) {
		super(queueSizeLimit, nextFilter);
	}

	public DispatchEventFilter(int queueSizeLimit) {
		super(queueSizeLimit);
	}
	
	public DispatchEventFilter(int queueSizeLimit, EventFilter nextFilter,SMSSender sms) {
		super(queueSizeLimit, nextFilter);
		this.sms = sms;
	}

	public DispatchEventFilter(int queueSizeLimit,SMSSender sms) {
		super(queueSizeLimit);
		this.sms = sms;
	}
	
	@Override
	protected void process(Event event) {
		
		List<Dispatch> dispatches = new ArrayList<Dispatch>();
		List<Agency> agencies = event.getEventType().getResponsibleAgencies();
		for(Agency agency:agencies){
			Dispatch dispatch = new Dispatch();
			dispatch.setAgency(agency);
			dispatch.setStatus(Dispatch.STATUS_SENT);
			dispatch.setEvent(event);
			dispatch.setDispatchTime(new Timestamp(System.currentTimeMillis()));
		
			dispatches.add(dispatch);
			
		}
		Ebean.save(dispatches);
		notifyAgencyOfEvent(agencies, event);
		
	}
	
	private boolean notifyAgencyOfEvent(List<Agency> agencies,Event event){
		List<String> phones = new ArrayList<>();
		String message = "You have a new Event with ID " + event.getId() + ". ";
		for(Agency agency:agencies){
			phones.add(agency.getPhone());
		}
		
		return	this.sms.SendSMS(message, phones);
		
	}

}
