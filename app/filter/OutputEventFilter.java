package filter;

import models.Event;

public class OutputEventFilter extends EventFilter {


	public OutputEventFilter(int queueSizeLimit, EventFilter nextFilter) {
		super(queueSizeLimit, nextFilter);
	}

	public OutputEventFilter(Integer queueSizeLimit ) {
		super(queueSizeLimit);
	}

	@Override
	protected void process(Event event) {
		EventFilter filter = new OutputEventFilter(10);
		System.out.println("Print out event " + event.getId());
	}

}
