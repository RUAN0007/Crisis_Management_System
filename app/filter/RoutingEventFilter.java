package filter;

import java.util.Map;

import models.Event;

public class RoutingEventFilter extends EventFilter{
	
	private Map<String,EventFilter> typeEventFilterMap;
	
	public RoutingEventFilter(int queueSizeLimit,Map<String,EventFilter> typeEventFilterMap) {
		super(queueSizeLimit);
		this.typeEventFilterMap = typeEventFilterMap;
	}

	@Override
	protected void process(Event event) {
		String typeName = event.getEventType().getEventType();
		EventFilter nextFilter = this.typeEventFilterMap.get(typeName);
		if(nextFilter == null){
			this.setNextFilter(null);
		}else{
			this.setNextFilter(nextFilter);
		}
	}
	
	
	

}
