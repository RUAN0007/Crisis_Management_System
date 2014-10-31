package filter;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.avaje.ebean.Ebean;

import broadcaster.EventFormatter;
import broadcaster.FacebookSender;
import broadcaster.TwitterSender;
import models.Event;
import models.Notification;

/**
 * BroadcastEventFilter is responsible to broadcast the event to social media.
 * The event with Priority One or Two will be broadcasted. 
 * @author ruanpingcheng
 *
 */
public class BroadcastEventFilter extends EventFilter {
	private static String MEDIA_FB = "FACEBOOK";
	private static String MEDIA_TWITTER = "TWITTER";
	
	private TwitterSender twitter;
	private FacebookSender facebook;
	private EventFormatter formatter;
	
	public BroadcastEventFilter(int queueSizeLimit, EventFilter nextFilter) {
		super(queueSizeLimit, nextFilter);
	}

	public BroadcastEventFilter(int queueSizeLimit) {
		super(queueSizeLimit);
	}

	private BroadcastEventFilter(int queueSizeLimit, 
								EventFormatter formatter,
								TwitterSender twitter, 
								FacebookSender facebook) {
		super(queueSizeLimit);
		this.twitter = twitter;
		this.facebook = facebook;
		this.formatter = formatter;
	}
	
	private BroadcastEventFilter(int queueSizeLimit, 
								EventFilter nextFilter,
								EventFormatter formatter,
								TwitterSender twitter, 
								FacebookSender facebook) {
		super(queueSizeLimit, nextFilter);
		this.twitter = twitter;
		this.facebook = facebook;
		this.formatter = formatter;
	}

	@Override
	protected void process(Event event) {
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		int priority = event.getPriority();
		
		if(priority <= 2){
			String message = formatter.formatSocialMedia(event);
			if(facebook.postMessage(message)){
				Notification fbNtfc = new Notification();
				fbNtfc.setEvent(event);
				fbNtfc.setSendTime(new Timestamp(System.currentTimeMillis()));
				fbNtfc.setMediaType(MEDIA_FB);
				notifications.add(fbNtfc);
			}
			if(twitter.postMessage(message)){
				Notification twNtfc = new Notification();
				twNtfc.setEvent(event);
				twNtfc.setSendTime(new Timestamp(System.currentTimeMillis()));
				twNtfc.setMediaType(MEDIA_TWITTER);
				notifications.add(twNtfc);
			}
			
			
		}
		Ebean.save(notifications);
	}

}
