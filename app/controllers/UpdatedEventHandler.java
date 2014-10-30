package controllers;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.HelperClass;
import models.Agency;
import models.Dispatch;
import models.Event;
import models.Notification;
import models.Public;
import broadcaster.EmailSender;
import broadcaster.EventFormatter;
import broadcaster.FacebookSender;
import broadcaster.PDFGenerator;
import broadcaster.ResourceGenerator;
import broadcaster.SMSSender;
import broadcaster.TwitterSender;

import com.avaje.ebean.Ebean;
/**
 * This class provides high level service for service operator
 * @author ruanpingcheng
 *
 */
public class UpdatedEventHandler {
//	private static UpdatedEventHandler defaultUpdatedEventHandler = null;
//	public static UpdatedEventHandler getDefault(){
//		if(defaultUpdatedEventHandler == null){
//			ResourceGenerator defaultResourceGenerator = ResourceGenerator.getDefaultResourceGenerator();
//			defaultUpdatedEventHandler = new UpdatedEventHandler(
//															defaultResourceGenerator.getNewEmailSender(), 
//															defaultResourceGenerator.getNewSMSSender(), 
//															new EventFormatter(), 
//															defaultResourceGenerator.getNewReportGenerator());
//		}
//		assert(defaultUpdatedEventHandler != null);
//		return defaultUpdatedEventHandler;
//	}
	
	
	private static String MEDIA_SMS = "SMS";
	private static String MEDIA_FB = "FACEBOOK";
	private static String MEDIA_TWITTER = "TWITTER";
	private static String MEDIA_Email = "Email";


	private EmailSender emailSender;
	private SMSSender smsSender;
	private EventFormatter eventFormatter;

	private PDFGenerator pdfGenerator;



	public UpdatedEventHandler(EmailSender emailSender, SMSSender smsSender,
			EventFormatter eventFormatter, PDFGenerator pdfGenerator) {
		super();
		this.emailSender = emailSender;
		this.smsSender = smsSender;
		this.eventFormatter = eventFormatter;
		this.pdfGenerator = pdfGenerator;
	}

	/**
	 * This method dispatches the event to the list of selected agencies from service operators
	 * @param event the updated event to be dispatched
	 * @param agencies the selected agencies to dispatch by service operator
	 */
	public void  dispatch(Event event,List<Agency> agencies){
		List<Dispatch> dispatches = new ArrayList<Dispatch>();

		for(Agency agency:agencies){
			Dispatch dispatch = new Dispatch();
			dispatch.setAgency(agency);
			dispatch.setStatus(Dispatch.STATUS_SENT);
			dispatch.setEvent(event);
			dispatch.setDispatchTime(new Timestamp(System.currentTimeMillis()));

			dispatches.add(dispatch);

		}
		Ebean.save(dispatches);
		sendEventSMSToAgency(agencies, event);		
	}

	/**
	 * This method sends sms to agencies to notify them of a new event
	 * @param agencies The list of selected agencies
	 * @param sms the event to be smsed. 
	 * @return the boolean value indication whether the operation is successful or not
	 */
	private boolean sendEventSMSToAgency(List<Agency> agencies,Event sms){
		List<String> phones = new ArrayList<>();
		for(Agency agency:agencies){
			phones.add(agency.getPhone());
		}

		return	smsSender.SendSMS("You have an incoming event", phones);

	}
	/**
	 * This method broadcast Event to the residents in the same region
	 * @param event Event to be broadcasted 
	 * @return the boolean indicating whether the operation is succesful or not
	 */
	public boolean broadcastSMSToPublic(Event event){
		String location = event.getLocation();
		List<Public> citizens = Public.find
				.where()
				.eq("location", location)
				.findList();

		List<String> phones = new ArrayList<>();
		for(Public citizen:citizens){
			phones.add(citizen.getHandPhone());
		}

		String message = eventFormatter.formatSMS(event);

		//Save the notification
		if(smsSender.SendSMS(message, phones)){
			Notification ntfc = new Notification();
			ntfc.setEvent(event);
			ntfc.setMediaType(MEDIA_SMS);
			ntfc.setSendTime(HelperClass.getCurrentTimestamp());
			ntfc.save();

			return true;
		}else{
			return false;
		}

	}
	/**
	 * This method email a report for Event to the Prime Minster Office
	 * @param event Event to be emailed 
	 * @return the boolean indicating whether the operation is succesful or not
	 */
	public boolean sendEventReport(Event event){
		String reportName = "EmergencyReportOnEvent" + event.getId() + ".pdf";
		File report = pdfGenerator.generateEmergencyReport(event,reportName);
		String file = pdfGenerator.getEmergentReportDirectory() + File.separator + report.getName();

		String subject = "Emergency Report";
		String text = "Dear Prime Minister, \nThere is an emergent event on " + event.getLocation() 
				+ ". Refer to the attachment for details."; 
		List<String> destinations = new ArrayList<String>();
		destinations.add(getPMEmail());
		return emailSender.sendMail(destinations, subject, text, file);
	}	

	/**
	 * This method retrieves the email address of Prime Minister Office from database
	 * @return The email address of Prime Minister Office
	 */
	private String getPMEmail(){
		Agency primeMinster = Agency.find.byId((long)0);
		return primeMinster.getEmail();
	}
}
