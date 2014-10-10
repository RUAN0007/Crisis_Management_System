import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import broadcaster.EmailSender;
import broadcaster.FacebookSender;
import broadcaster.SMSSender;
import broadcaster.TwitterSender;
import formatter.PDFGenerator;


public class ResourceGenerator {
	private static ResourceGenerator defaultResourceGenerator = null;
	public static ResourceGenerator getDefaultResourceGenerator(){
		if(defaultResourceGenerator == null){
			defaultResourceGenerator = new ResourceGenerator
					("conf" + File.separator + "paras.xml");
		}
		assert(defaultResourceGenerator != null);
		return defaultResourceGenerator;
	}

	private Document doc = null;
	private ResourceGenerator(String parasPath) {
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(parasPath);
			doc.getDocumentElement().normalize();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public FacebookSender getNewFBSender(){

		try{
			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();		
			XPathExpression expr = xpath.compile("/paras/facebook/accessToken");
			String accessToken = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/facebook/accessTokenSecret");
			String accessTokenSecret = (String) expr.evaluate(doc,XPathConstants.STRING);
			//TODO Testing
			//	return new FacebookSender(accessToken, accessTokenSecret);
			return null;
		}catch(XPathExpressionException e){
			e.printStackTrace();		
			return null;

		}



	}

	public  TwitterSender getNewTwitterSender() {
		try{

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();		
			XPathExpression expr = xpath.compile("/paras/twitter/consumerKey");
			String consumerKey = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/twitter/consumerSecret");
			String consumerSecret = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/twitter/accessToken");
			String accessToken = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/twitter/accessTokenSecret");
			String accessTokenSecret = (String) expr.evaluate(doc,XPathConstants.STRING);

			return new TwitterSender(consumerKey,consumerSecret,accessToken, accessTokenSecret);
		}catch(XPathExpressionException e){
			e.printStackTrace();		
			return null;

		}
	}

	public EmailSender getNewEmailSender(){
		try{

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();		
			XPathExpression expr = xpath.compile("/paras/email/account");
			String account = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/email/password");
			String password = (String) expr.evaluate(doc,XPathConstants.STRING);

			return new EmailSender(account, password);
		}catch(XPathExpressionException e){
			e.printStackTrace();		
			return null;

		}
	}

	public  PDFGenerator getNewReportGenerator() {
		try{

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();		
			XPathExpression expr = xpath.compile("/paras/email/emergency");
			String emergencyReportDir = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/email/summary");
			String summaryReportDir = (String) expr.evaluate(doc,XPathConstants.STRING);

			return new PDFGenerator(emergencyReportDir,summaryReportDir);
		}catch(XPathExpressionException e){
			e.printStackTrace();		
			return null;

		}
	}

	private SMSSender getNewSMSSender()  {
		try{

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();		
			XPathExpression expr = xpath.compile("/paras/sms/sid");
			String sid = (String) expr.evaluate(doc,XPathConstants.STRING);

			expr = xpath.compile("/paras/sms/token");
			String token = (String) expr.evaluate(doc,XPathConstants.STRING);

			return new SMSSender(sid,token);
		}catch(XPathExpressionException e){
			e.printStackTrace();		
			return null;

		}
	}

}
