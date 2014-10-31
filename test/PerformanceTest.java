import models.Dispatch;
import models.Event;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import controllers.*;
import models.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.routes;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import util.HelperClass;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class PerformanceTest {

	/**
	 * Performance-1
	 */
	
//	@Test 
//	public void deleteEvent(){
//		running(fakeApplication(), new Runnable() {
//
//			@Override
//			public void run() {
//		//Delete the record
//		List<Event> testEvents = Event.find.where().eq("postal_code", "666666").findList();
//		for(Event event:testEvents){
//			event.delete();
//		}
//			
//			
//			}});
//	}
	
//	@Test
//	public void Performance1Test(){
//		test(100,1,1000);
//	}
	
//	/**
//	 * Performance-2
//	 */
//	@Test
//	public void Performance2Test(){
//		test(100,5,500);
//	}
//	
//	/**
//	 * Performance-3
//	 */
//	@Test
//	public void Performance3Test(){
//		test(100,10,250);
//	}
//	
//	/**
//	 * Performance-4
//	 */
//	@Test
//	public void Performance4Test(){
//		test(1000,1,3000);
//	}
	
//	/**
//	 * Performance-5
//	 */
//	@Test
//	public void Performance5Test(){
//		test(1000,5,1500);
//	}
//	
//	/**
//	 * Performance-6
//	 */
//	@Test
//	public void Performance6Test(){
//		test(1000,10,1000);
//	}
//	
	/**
	 * Performance-7
	 */
//	@Test
//	public void Performance7Test(){
//		test(10000,1,20_000);
//	}
//	
//	/**
//	 * Performance-8
//	 */
//	@Test
//	public void Performance8Test(){
//		test(10000,5,10_000);
//	}
//	
	/**
	 * Performance-9
	 */
	@Test
	public void Performance9Test(){
		test(10000,10,10_000);
	}
	
	public void test(int eventCount,int eventHandlerCount,int timeLimitInMs) {
		
		
	
		running(fakeApplication(), new Runnable() {

			@Override
			public void run() {
				EventHandlerPool handlersPool = new EventHandlerPool(eventHandlerCount);
							
				List<Event> incomingEvents = new ArrayList<Event>();
				for(int i = 0;i < eventCount;i++){
					Event newEvent = new Event();
					newEvent.setCallerPhone("123456");
					newEvent.setCallingTime(new Timestamp(System.currentTimeMillis()));
					
					newEvent.setCallOperator(CallOperator.find.byId((long) 4));
					newEvent.setDescription("bla bla bla");
					newEvent.setEventType(EventType.find.byId((long)0));
					newEvent.setLocation("Central");
					newEvent.setPostalCode("666666");;
					newEvent.setPriority(3);
					newEvent.setId(HelperClass.getRandomLong());
					incomingEvents.add(newEvent);
				}
				
				
				long before = System.currentTimeMillis();
				int count = 0;
				for(Event incomingEvent:incomingEvents){
					if(!handlersPool.handleReportedEvent(incomingEvent)){
						count++;
						System.out.println("" + count + " events is not accepted...");
					}
				}
				while(!handlersPool.isIdle());
				
				long after = System.currentTimeMillis();
				System.out.println("Handling " + eventCount + " Events with " +  eventHandlerCount + " event pipes in ms: " + (after - before));
				
				//Delete the record
				List<Event> testEvents = Event.find.where().eq("postal_code", "666666").findList();
				for(Event event:testEvents){
					event.delete();
				}
				assert((after - before) < timeLimitInMs);
			}
		});
			
		
	}
}
