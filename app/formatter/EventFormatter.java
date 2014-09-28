package formatter;


import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import models.*;
public class EventFormatter {
//	private String message;
	private static EventFormatter formatter = new EventFormatter();
	
	public static EventFormatter getDefaultFormatter(){
		return formatter;
	}
	
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
	
	
	public String formatSocialMedia(Event e){
		/*EXAMPLE:
		 *  ALERT
            Incident Location: Pioneer 
            Incident Name: Dengue
            Issued: 17/09/14 4:17 PM
            This alert is issued by National Crisis Management Centre.
            Emergency services are attending to a Dengue case in Pioneer. 
            There is currently no threat to the community, but you should continue to stay informed and monitor 
            conditions.
            The next update is expected at 18/09/14 9:00 AM or as the situation changes.
            Safety Instructions:
			If you are experiencing any symptoms that may be due to Dengue, seek medical advice or call 
			'Nurse on Call' on 1300 606 024.
			Stay Informed:
			Via www.nationalcrisismanagement.com.sg
			Tune into ABC Local Radio, commercial and designed community radio stations or TV news.
			For help with English, call the Translating and Interpreting Service on 131 450 (freecall) 
			and ask them to telephone VBIL. If you know someone who cannot speak English, provide them with this number.
			Follow NCMC on Twitter or Facebook.
		*/
		String message = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm a",Locale.US);
		Date date = new Date();
		
		if (e.getPriority() == 1){
			message = "EMERGENCY WARNING " +
					"\nIncident Location: " + e.getLocation() + 
					"\nIncident Name: " + e.getEventType()+ 
					"\nIssued: "+ dateFormat.format(date) + 
					"\nThis EMERGENCY WARNING is issued by National Crisis Management Centre."+
					"\nEmergency services are attending to a "+e.getEventType()+" case in Pioneer"+
					"\nThere is currently no threat to the community, but you should continue to stay informed and monitor conditions."+
					"\nThe next update is expected at 9:00 AM tomorrow or as the situation changes."+
					"\n"+
					"\nSafety Instructions:"+
					"\nIf you are experiencing any symptoms that may be due to Dengue, seek medical advice or call 995."+
					"\n"+
					"\nStay Informed:"+
			        "\nVia www.nationalcrisismanagement.com.sg"+
			        "\nTune into ABC Local Radio, commercial and designed community radio stations or TV news."+
			        "\nFor help with English, call the Translating and Interpreting Service on 131 450 (freecall) and ask them to telephone VBIL. If you know someone who cannot speak English, provide them with this number."+
			        "\nFollow NCMC on Twitter or Facebook.";
		}
		else if (e.getPriority() == 2){
			message = "WATCH AND ACT " +
					"\nIncident Location: " + e.getLocation() + 
					"\nIncident Name: " + e.getEventType()+ 
					"\nIssued: "+ dateFormat.format(date) + 
					"\nThis WATCH AND ACT is issued by National Crisis Management Centre."+
					"\nEmergency services are attending to a "+e.getEventType()+" case in Pioneer"+
					"\nThere is currently no threat to the community, but you should continue to stay informed and monitor conditions."+
					"\nThe next update is expected at 9:00 AM tomorrow or as the situation changes."+
					"\n"+
					"\nSafety Instructions:"+
					"\nIf you are experiencing any symptoms that may be due to Dengue, seek medical advice or call 'Nurse on Call' on 1300 606 024."+
					"\n"+
					"\nStay Informed:"+
			        "\nVia www.nationalcrisismanagement.com.sg"+
			        "\nTune into community radio stations or TV news."+
			        "\nFor help with English, call the Translating and Interpreting Service on 131 450 (freecall). If you know someone who cannot speak English, provide them with this number."+
			        "\nFollow NCMC on Twitter or Facebook.";
		}
		else if (e.getPriority() == 3){
			message = "ADVICE " +
					"\nIncident Location: " + e.getLocation() + 
					"\nIncident Name: " + e.getEventType()+ 
					"\nIssued: "+ dateFormat.format(date) + 
					"\nThis ADVICE is issued by National Crisis Management Centre."+
					"\nEmergency services are attending to a "+e.getEventType()+" case in Pioneer"+
					"\nThere is currently no threat to the community, but you should continue to stay informed and monitor conditions."+
					"\nThe next update is expected at 9:00 AM tomorrow or as the situation changes."+
					"\n"+
					"\nSafety Instructions:"+
					"\nIf you are experiencing any symptoms that may be due to Dengue, seek medical advice or call 'Nurse on Call' on 1300 606 024."+
					"\n"+
					"\nStay Informed:"+
			        "\nVia www.nationalcrisismanagement.com.sg"+
			        "\nTune into ABC Local Radio, commercial and designed community radio stations or TV news."+
			        "\nFor help with English, call the Translating and Interpreting Service on 131 450 (freecall) and ask them to telephone VBIL. If you know someone who cannot speak English, provide them with this number."+
			        "\nFollow NCMC on Twitter or Facebook.";
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