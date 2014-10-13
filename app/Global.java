import com.avaje.ebean.Ebean;

import models.Agency;
import models.Event;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import play.Application;
import play.GlobalSettings;
import play.libs.XML;
import play.libs.Yaml;

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

import broadcaster.*;
import formatter.*;

public class Global extends GlobalSettings {
	private class RoutineEmailSender{
		/**
		 * This method starst the RoutineEmailSender to send the summary email in a speficied frequency
		 * @param frequencyInMin The frequenct in minute
		 */
		public  void start(int frequencyInMin){
			//TODO
			//Finish testing
			//Comment it out 
			int periodInMs = frequencyInMin * 60 * 1000;
			summaryTimer.scheduleAtFixedRate(new RoutineEmailTask(frequencyInMin), 0,periodInMs);

		}
	}
	private  int periodForSummaryReportInMin = 30 ;
	private Timer summaryTimer = new Timer();
	
	@Override
	public void onStart(Application app) {
		//System.out.println("I hate YAML!!");
		new RoutineEmailSender().start(periodForSummaryReportInMin);
	}

	
	
	@Override
	public void onStop(Application app) {
		if(this.summaryTimer != null){
			this.summaryTimer.cancel();
		}

	}

	
}
