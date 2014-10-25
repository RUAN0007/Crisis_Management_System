package ServerInterfaceTest;
import client.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ServiceOperatorServerInterfaceTest {

//	@Test
//	public void testLogin() throws Exception{
//		ServiceOperatorServerInterface sosi 
//			= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		assert(so.getName().equals("LY"));
//	}
//	
//	@Test
//	public void testGetUnclassifiedEvents() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		
//		List<Event> events = sosi.getUnclassifiedEvents();
//		assert(events.size() != 0);
//	}
//
//	@Test
//	public void testGetPriorityOneEvents() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		
//		List<Event> events = sosi.getPriorityOneEvents();
//		assert(events.size() != 0);
//	}
//	
//	@Test
//	public void testGetAgencies() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		
//		Map<String,String> agencyMaps = sosi.getAgencies();
//		assert(agencyMaps.size() != 0);
//	}
//	
//	@Test
//	public void testGetEventByID() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		
//		Event event = sosi.getEventFromID("44");
//		assert(event.getPriority() == 1);
//	}
//	
//	@Test
//	public void testUpdateEvent() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		
//		List<String> relevantAgenciesIDs = new ArrayList<String>();
//		relevantAgenciesIDs.add("1");
//		relevantAgenciesIDs.add("2");
//
//		assert(sosi.updateEvent("33", 3, relevantAgenciesIDs ));
//	}
//	
//	@Test
//	public void testGetEventStatuses() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		
//		List<EventStatus> result = sosi.getEventsStatus();
//		assert(result.size() != 0);
//	}
//	
//	@Test
//	public void testSMSForEvent() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		assert(sosi.broadcastSMSForEvent("11"));
//	}
//	
//	@Test
//	public void testEmailForEvent() throws Exception{
//		ServiceOperatorServerInterface sosi 
//		= new ServiceOperatorServerInterface("localhost:9000", "7", "77");
//		ServiceOperator so = sosi.login();
//		assert(sosi.sendReportForEvent("11"));
//	}
	
	
}
