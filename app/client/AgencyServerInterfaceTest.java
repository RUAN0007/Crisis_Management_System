package client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AgencyServerInterfaceTest {

	@Test
	public void testLoginSucceeded() throws Exception{
		AgencyServerInterface serverInterface =
				new AgencyServerInterface("localhost:9000", "1", "11");
		Agency co = serverInterface.login();
		assert(co.getName().equals("Emergency Ambulance"));
	}
	
	@Test
	public void testGetSentEvents() throws Exception{
		AgencyServerInterface serverInterface =
				new AgencyServerInterface("localhost:9000", "1", "11");
		Agency co = serverInterface.login();
		List<Event> events = serverInterface.getSentEvents();
		assert(events.size() != 0);
	}
	
	@Test
	public void testGetReadEvents() throws Exception{
		AgencyServerInterface serverInterface =
				new AgencyServerInterface("localhost:9000", "1", "11");
		Agency co = serverInterface.login();
		List<Event> events = serverInterface.getReadEvents();
		assert(events.size() != 0);
	}
	
	@Test
	public void testGetSolvedEvents() throws Exception{
		AgencyServerInterface serverInterface =
				new AgencyServerInterface("localhost:9000", "1", "11");
		Agency co = serverInterface.login();
		List<Event> events = serverInterface.getSolvedEvents();
		assert(events.size() != 0);
	}
	
	@Test
	public void testReadEvent() throws Exception{
		AgencyServerInterface serverInterface =
				new AgencyServerInterface("localhost:9000", "1", "11");
		Agency co = serverInterface.login();
		assert(serverInterface.readEvent("11"));
	}
	
	@Test
	public void testSolveEvent() throws Exception{
		AgencyServerInterface serverInterface =
				new AgencyServerInterface("localhost:9000", "2", "22");
		Agency co = serverInterface.login();
		assert(serverInterface.solveEvent("11"));
	}
}
