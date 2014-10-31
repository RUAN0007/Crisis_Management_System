package filter;

import models.Event;
/**
 * DatabaseEventFilter is responsible to save the event to database.
 * @author ruanpingcheng
 *
 */
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
