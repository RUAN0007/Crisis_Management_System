package filter;

import models.Event;

public class DatabaseEventFilter extends EventFilter {

	public DatabaseEventFilter(int queueSizeLimit, EventFilter nextFilter) {
		super(queueSizeLimit, nextFilter);
	}

	public DatabaseEventFilter(int queueSizeLimit) {
		super(queueSizeLimit);
	}

	/**
	 * Save the event to database
	 */
	@Override
	protected void process(Event event) {
		event.save();
	}

}
