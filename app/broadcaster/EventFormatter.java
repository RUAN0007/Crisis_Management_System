package broadcaster;


import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import models.*;
/**
 * This class is to convert the event to a string, 
 * which can be sent via sms or social media. 
 */
public class EventFormatter {
//	private String message;
	private static EventFormatter formatter = new EventFormatter();
	
	public static EventFormatter getDefaultFormatter(){
		return formatter;
	}
	/**
	 * Format the event to String, intended for sms sendng
	 * @param e Event to be formatted
	 * @return formatted String
	 */
	public String formatSMS(Event e){
		/*EXAMPLE:
		 *  URGENT-National Crisis Management Centre 20/09/14 6:34 AM
            Residents in Central: ALERT! There is a Dengue case in 88888888. 
            Details of the event: Dengue here 
		 */
		String message = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm a",Locale.US);
		Date date = new Date();
		
		if (e.getPriority() == 1){
			message = "URGENT-National Crisis Management Centre "+dateFormat.format(date)+ "\nResidents in "
			          +e.getLocation() +": ALERT! There is a Dengue case in " + e.getPostalCode() + ". \nDetails of the event: " + e.getDescription() ;
		}
		return message;
	}
	
	/**
	 * Format the event to String, intended for social media broadcasting
	 * @param e Event to be formatted
	 * @return formatted String
	 */
	public String formatSocialMedia(Event e){
		/*EXAMPLE:
		 *  EMERGENCY WARNING
			Location: Pioneer 
			Incident Name: Dengue
			Emergency services are attending to this case.  www.nationalcrisismanagement.com.sg
		*/
		String message = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm a",Locale.US);
		Date date = new Date();
		
		if (e.getPriority() == 1){
			message = "EMERGENCY WARNING " +
					"\nLocation: " + e.getLocation() + 
					"\nIncident Name: " + e.getEventType()+ 
					"\nIssued: "+ dateFormat.format(date) + 
					"\nEmergency services are attending to this case.  ";
		}
		else if (e.getPriority() == 2){
			message = "WATCH AND ACT " +
					"\nLocation: " + e.getLocation() + 
					"\nIncident Name: " + e.getEventType()+ 
					"\nIssued: "+ dateFormat.format(date) + 
					"\nEmergency services are attending to this case. ";
		}
		else if (e.getPriority() == 3){
			message = "ADVICE " +
					"\nLocation: " + e.getLocation() + 
					"\nIncident Name: " + e.getEventType()+ 
					"\nIssued: "+ dateFormat.format(date);
		}
		return message;
	}
	
	
//	public static void main(String[] args){
//		Event e = Event.getExample();
//		EventFormatter ef = new EventFormatter();
//		
//		System.out.println(ef.formatSMS(e));
//		System.out.println("\n");
//		System.out.println(ef.formatSocialMedia(e));
//	}
}

//social media automatic?