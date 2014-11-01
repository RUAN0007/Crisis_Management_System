import com.avaje.ebean.Ebean;

import controllers.CallOperatorController;
import controllers.EventHandlerPool;
import controllers.ServiceHandler;
import controllers.ServiceOperatorController;
import models.Agency;
import models.CallOperator;
import models.Event;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import play.Application;
import play.GlobalSettings;
import play.libs.XML;
import play.libs.Yaml;
import resource.ResourceGenerator;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import formatter.*;

public class Global extends GlobalSettings {
	private class RoutineEmailSender{
		/**
		 * This method starst the RoutineEmailSender to send the summary email in a speficied frequency
		 * @param frequencyInMin The frequenct in minute
		 */
		private Timer summaryTimer = new Timer();

		public  void start(int frequencyInMin){
			//TODO
			//Finish testing
			//Comment it out 
//			int periodInMs = frequencyInMin * 60 * 1000;
//			summaryTimer.scheduleAtFixedRate(new RoutineEmailTask(frequencyInMin), 0,periodInMs);
			
			
			
		}
		
		public void stop(){
			if(this.summaryTimer != null){
				this.summaryTimer.cancel();
			}
		}
	}
	private  int periodForSummaryReportInMin = 30 ;
	private RoutineEmailSender rtms = new RoutineEmailSender();
	@Override
	public void onStart(Application app) {
		//System.out.println("I hate YAML!!");
	//	rtms.start(periodForSummaryReportInMin);
		
		ResourceGenerator defaultResourceGenerator = ResourceGenerator.getDefaultResourceGenerator();

		CallOperatorController.setEventHandlerPool(new EventHandlerPool(5));
		ServiceHandler updatedEventHandler = new ServiceHandler(
				defaultResourceGenerator.getNewEmailSender(), 
				defaultResourceGenerator.getNewSMSSender(), 
				defaultResourceGenerator.getEventFormatter(), 
				defaultResourceGenerator.getNewReportGenerator());

		ServiceOperatorController.setUpdatedEventHandler(updatedEventHandler);
		
		
	}

	
	
	@Override
	public void onStop(Application app) {
		
		rtms.stop();
	}

	
}
