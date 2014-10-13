import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;

import models.Agency;
import models.Event;
import broadcaster.EmailSender;
import broadcaster.PDFGenerator;
import broadcaster.ResourceGenerator;

/**
 * RoutineEmailTask is a timertask that groups recent events, 
 * generate summary report and email to Prime Minister Office. 
 * @author ruanpingcheng
 *
 */
public class RoutineEmailTask extends TimerTask {
	private EmailSender emailSender = ResourceGenerator
			.getDefaultResourceGenerator()
			.getNewEmailSender();
	
	private PDFGenerator pdfGenerator = ResourceGenerator
			.getDefaultResourceGenerator()
			.getNewReportGenerator();
	
	private int periodForSummaryReportInMin;
	public RoutineEmailTask(int periodForSummaryReportInMin) {
		this.periodForSummaryReportInMin = periodForSummaryReportInMin;
	}

	@Override
	public void run() {
		System.out.println("Sending Report...");

		List<Event> events = getEventsWithinMin(periodForSummaryReportInMin);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_hh:mm",Locale.US);
		Date date = new Date();
		String time = dateFormat.format(date);
		
		String subject = "Summary Report";
		String text = "Dear Prime Minister, \nThis is a summary event at " + time 
				+ ". Refer to the attachment for details."; 
		String reportName = "SummaryReportAt" + time + ".pdf";
		
		File report = pdfGenerator.generateReport(events, reportName);
		String reportFilePath = pdfGenerator.getSummaryReportDirectory() + File.separator + report.getName();
		
		List<String> destinations = new ArrayList<String>();
		destinations.add(getPMEmail());
		 if(emailSender.sendMail(destinations, subject, text, reportFilePath)){
			 System.out.println("Sending succeeded...");
		 }else{
			 System.out.println("Sending failed...");
		 }
		
		
	}
	
	private List<Event> getEventsWithinMin(int periodInMin){
		Timestamp lowerTimeBound = new Timestamp(System.currentTimeMillis() - periodInMin * 60 * 1000);
		List<Event> events = Event.find.where()
									   .gt("callingTime", lowerTimeBound)
									   .orderBy("callingTime desc")

									   .findList();
		return events;
	}
	
	
	private String getPMEmail(){
		Agency primeMinster = Agency.find.byId((long)0);
		return primeMinster.getEmail();
	}

}
