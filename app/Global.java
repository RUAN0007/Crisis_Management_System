import com.avaje.ebean.Ebean;

import controllers.EventCenter;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import play.Application;
import play.GlobalSettings;
import play.libs.XML;
import play.libs.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
	private  int periodForSummaryReportInMin = 30 ;
	private Timer summaryTimer = new Timer();

	@Override
	public void onStart(Application app) {
		//System.out.println("I hate YAML!!");
		if(!EventCenter.setDefaultEventCenter(getEventCenter())){
			System.err.println("Create eventCenter failed...");
		}

		//TODO
		//Waiting for testing
//		int periodInMin = this.periodForSummaryReportInMin * 60 * 1000;
//		summaryTimer.scheduleAtFixedRate(new TimerTask() {
//
//			@Override
//			public void run() {
//				EventCenter.getDefaultEventCenter().sendSummaryReport(periodInMin);
//			}
//		}, periodInMin,periodInMin);
	}

	private static EventCenter getEventCenter(){
		try{
			File file = new File("paras.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();

			EmailSender emailSender = getEmailSender(doc);
			SMSSender smsSender = getSMSSender(doc);
			FacebookSender fbSender = getFBSender(doc);
			TwitterSender twitterSender = getTwitterSender(doc);
			EventFormatter eventFormatter = new EventFormatter();
			PDFGenerator pdfGenerator = getReportGenerator(doc);
			
			return new EventCenter(emailSender, smsSender, fbSender, twitterSender, eventFormatter, pdfGenerator);
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private static FacebookSender getFBSender(Document doc) throws XPathExpressionException {
		XPathFactory xFactory = XPathFactory.newInstance();
		XPath xpath = xFactory.newXPath();		
		XPathExpression expr = xpath.compile("/paras/facebook/accessToken");
		String accessToken = (String) expr.evaluate(doc,XPathConstants.STRING);
	
		expr = xpath.compile("/paras/facebook/accessTokenSecret");
		String accessTokenSecret = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		return new FacebookSender(accessToken, accessTokenSecret);
	}
	
	private static TwitterSender getTwitterSender(Document doc) throws XPathExpressionException {
		XPathFactory xFactory = XPathFactory.newInstance();
		XPath xpath = xFactory.newXPath();		
		XPathExpression expr = xpath.compile("/paras/twitter/consumerKey");
		String consumerKey = (String) expr.evaluate(doc,XPathConstants.STRING);
	
		expr = xpath.compile("/paras/facebook/consumerSecret");
		String consumerSecret = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		expr = xpath.compile("/paras/facebook/accessToken");
		String accessToken = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		expr = xpath.compile("/paras/facebook/accessTokenSecret");
		String accessTokenSecret = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		return new TwitterSender(consumerKey,consumerSecret,accessToken, accessTokenSecret);
	
	}
	
	private static EmailSender getEmailSender(Document doc) throws XPathExpressionException {
		XPathFactory xFactory = XPathFactory.newInstance();
		XPath xpath = xFactory.newXPath();		
		XPathExpression expr = xpath.compile("/paras/email/account");
		String account = (String) expr.evaluate(doc,XPathConstants.STRING);
	
		expr = xpath.compile("/paras/email/password");
		String password = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		return new EmailSender(account, password);
	
	}
	
	private static PDFGenerator getReportGenerator(Document doc) throws XPathExpressionException{
		XPathFactory xFactory = XPathFactory.newInstance();
		XPath xpath = xFactory.newXPath();		
		XPathExpression expr = xpath.compile("/paras/email/emergency");
		String emergencyReportDir = (String) expr.evaluate(doc,XPathConstants.STRING);
	
		expr = xpath.compile("/paras/email/summary");
		String summaryReportDir = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		return new PDFGenerator(emergencyReportDir,summaryReportDir);
	}

	private static SMSSender getSMSSender(Document doc) throws XPathExpressionException{
		XPathFactory xFactory = XPathFactory.newInstance();
		XPath xpath = xFactory.newXPath();		
		XPathExpression expr = xpath.compile("/paras/sms/sid");
		String sid = (String) expr.evaluate(doc,XPathConstants.STRING);
	
		expr = xpath.compile("/paras/sms/token");
		String token = (String) expr.evaluate(doc,XPathConstants.STRING);
		
		return new SMSSender(sid,token);
	}
	
	@Override
	public void onStop(Application app) {
		if(this.summaryTimer != null){
			this.summaryTimer.cancel();
		}

	}

	static class InitialData {

		public static void insert(Application app) {
			//	            TODO
			//Start a timer to send Email for every 30 min
		}

	}
}
