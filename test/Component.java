import static org.junit.Assert.*;
import models.*;

import org.junit.Test;

import resource.ResourceGenerator;


public class Component {

	@Test
	public void test() throws InterruptedException {
		
		EventType type = new EventType();
		type.setEventType("Dengue");
		
		Event event = new Event();
		event.setEventType(type);
		event.setId(835);
		ResourceGenerator resource = ResourceGenerator.getDefaultResourceGenerator();
		resource.getNewRoutingEventFilter().enqueueEvent(event);
		Thread.sleep(10000);
	}

}
