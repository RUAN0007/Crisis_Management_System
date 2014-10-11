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
	
	@Test
	public void test() {
		

	
		running(fakeApplication(), new Runnable() {

			@Override
			public void run() {
				IncomingEventHandlerPool handlersPool = IncomingEventHandlerPool.getDefault();
			
				int eventCount = 10000;
				
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
				for(Event incomingEvent:incomingEvents){
					handlersPool.handleIncomingEvent(incomingEvent);
				}
				while(!handlersPool.isIdle());
				
				long after = System.currentTimeMillis();
				System.out.println("Handling " + eventCount + " Events in ms: " + (after - before));
				
				//Delete the record
				List<Event> testEvents = Event.find.where().eq("postal_code", "666666").findList();
				for(Event event:testEvents){
					event.delete();
				}
			}
		});
			
		
	}
}
