package resource;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import scala.collection.generic.BitOperations.Int;
import filter.EventFilter;
import filter.RoutingEventFilter;

/**
 * ResourceGenerator construct building blocks based on the parameters in para.xml file,
 * Other components can reference building blocks through ResourceGenerator. 
 * @author ruanpingcheng
 *
 */
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
	
	private  Map<String,EventFilter> typeEventFilterMap = new HashMap<String,EventFilter>();
	
	private ResourceGenerator(String parasPath) {
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(parasPath);
			doc.getDocumentElement().normalize();
			
			getEventFilterMap();
						
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void getEventFilterMap() throws Exception{
		NodeList eventTypeNodes = doc.getElementsByTagName("eventtype");
		for(int i = 0;i < eventTypeNodes.getLength();i++){
			Element eventTypeNode = (Element)eventTypeNodes.item(i);
			String typeName = eventTypeNode.getAttribute("name");
			
			NodeList filterNodes = eventTypeNode.getElementsByTagName("filter");
			
			EventFilter preEventFilter = null;
			EventFilter firstEventFilter = null;
			for(int filterID = 0;filterID < filterNodes.getLength();filterID++){
				 String filterClassName = filterNodes.item(filterID).getTextContent();
				 Class<? extends EventFilter> eventFilterClass = (Class<? extends EventFilter>)Class.forName(filterClassName);
				 Constructor<? extends EventFilter> eventFilterConstructor = eventFilterClass.getConstructor(Integer.class);
				 EventFilter eventFilter = eventFilterConstructor.newInstance(1000);
				 
			//	 EventFilter eventFilter = (EventFilter)Class.forName(filterClassName).newInstance();
				 eventFilter.start();
				 if(firstEventFilter == null){
					 assert(preEventFilter == null);
					 firstEventFilter = eventFilter;
					 preEventFilter = eventFilter;
				 }else{
					 preEventFilter.setNextFilter(eventFilter);
				 }		
			}
			
			typeEventFilterMap.put(typeName, firstEventFilter);
			
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

	public SMSSender getNewSMSSender()  {
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
	
	public EventFormatter getEventFormatter(){
		return new EventFormatter();
	}
	
	public RoutingEventFilter getNewRoutingEventFilter(){
		RoutingEventFilter routingEventFilter = new RoutingEventFilter(10000, this.typeEventFilterMap);
		return routingEventFilter;
	}

}
