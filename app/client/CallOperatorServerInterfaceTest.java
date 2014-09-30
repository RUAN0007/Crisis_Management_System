package client;

import static org.junit.Assert.*;

import org.junit.Test;

public class CallOperatorServerInterfaceTest {

	@Test
	public void testLoginSucceeded() throws Exception{
		CallOperatorServerInterface serverInterface =
				new CallOperatorServerInterface("localhost:9000", "4", "44");
		CallOperator co = serverInterface.login();
		assert(co.getName().equals("RPC"));
	}
	
	@Test
	public void testReportEvent() throws Exception{
		CallOperatorServerInterface serverInterface =
				new CallOperatorServerInterface("localhost:9000", "4", "44");
		CallOperator co = serverInterface.login();
		String eventTypeID = "1";
		String callOperatorID = "4";
		String priority = "3";
		String location = "Central";
		String postalCode = "666666";
		String callerPhone = "98989898";
		String description = "Hello World";
		boolean result = serverInterface.report(eventTypeID,
												priority, 
												callOperatorID,
												postalCode, 
												location, 
												callerPhone, 
												description);
		assert(result);
	}	
	
	

}
