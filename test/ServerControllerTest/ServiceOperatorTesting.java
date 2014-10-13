package ServerControllerTest;
import models.CallOperator;
import models.Dispatch;
import models.Event;
import models.EventType;

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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
public class ServiceOperatorTesting {

	//	@Test
	//	public void testSuccessfulServiceOperatorLogin(){
	//
	//		running(fakeApplication(), new Runnable() {
	//			public void run() {
	//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/serviceoperator/login");
	//				Map<String,String> paras = new HashMap<>();
	//				paras.put("id","7");
	//				paras.put("password", "77");
	//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
	//				String content = contentAsString(result);
	//
	//				JsonNode json = Json.parse(content);
	//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
	//				assertThat(json.get("name").asText()).isEqualTo("LY");
	//			}
	//		});
	//	}
	//	
	//	@Test
	//	public void testFailedCallOperatorLogin(){
	//
	//		running(fakeApplication(), new Runnable() {
	//			public void run() {
	//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/serviceoperator/login");
	//				Map<String,String> paras = new HashMap<>();
	//				paras.put("id","8");
	//				paras.put("password", "89");
	//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
	//
	//				String content = contentAsString(result);
	//				JsonNode json = Json.parse(content);
	//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(1);
	//			}
	//		});
	//	}

	//	@Test
	//	public void testGetUnclassifiedEvents(){
	//		running(fakeApplication(), new Runnable() {
	//			public void run() {
	//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/unhandledEvents");
	//			
	//				Result result = Helpers.routeAndCall(fakeLogOutRequest
	//														.withSession("id", "S1")
	//														//.withFormUrlEncodedBody(paras)
	//														);
	//
	//				String content = contentAsString(result);
	//				JsonNode json = Json.parse(content);
	//				//System.out.println("Content = " + content);
	//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
	//				JsonNode events = json.get("events");
	//				assertThat(events.size()).isEqualTo(1);
	//				assertThat(Integer.parseInt(events.get(0).get("id").asText())).isEqualTo(33);
	//
	//				
	//			}
	//		});
	//	}

//		@Test
//		public void testUpdateEvents(){
//			running(fakeApplication(), new Runnable() {
//				public void run() {
//					FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/updateEvent");
//					Long agencyID1 = (long)1;
//					Long agencyID2 = (long)2;
//					Long eventID = (long) 33;
//					Long serviceOperatorID = (long)7;
//					int priority = 3;
//	
//					ObjectNode paras = Json.newObject();
//					paras.put("eventID",eventID);
//					paras.put("serviceOperatorID",serviceOperatorID);
//					paras.put("priority",priority);
//	
//					ArrayNode agencyNodes = new ArrayNode(JsonNodeFactory.instance);
//					agencyNodes.add(agencyID1);
//					agencyNodes.add(agencyID2);
//					paras.put("relevantAgenciesIDs", agencyNodes);
//	
//					Result result = Helpers.routeAndCall(fakeLogOutRequest
//							.withSession("id", "S1")
//							.withJsonBody(paras)
//							);
//	
//					String content = contentAsString(result);
//					JsonNode json = Json.parse(content);
//					//System.out.println("Content = " + content);
//					assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//	
//					Event updatedEvent = Event.find.byId(eventID);
//					assertThat(updatedEvent.getServiceOperator().getId()).isEqualTo(serviceOperatorID);
//					assertThat(updatedEvent.getPriority()).isEqualTo(priority);
//	
//					Dispatch dispatch1 = Dispatch.find
//							.where().eq("event.id", eventID)
//							.where().eq("agency.id", agencyID1)
//							.findUnique();
//					assertThat(dispatch1).isNotNull();
//					assertThat(dispatch1.getStatus()).isEqualTo(Dispatch.STATUS_SENT);
//					assertThat(dispatch1.getDispatchTime()).isNotNull();
//					assertThat(dispatch1.getReadTime()).isNull();
//					assertThat(dispatch1.getSolveTime()).isNull();
//	
//	
//					Dispatch dispatch2 = Dispatch.find
//							.where().eq("event.id", eventID)
//							.where().eq("agency.id", agencyID2)
//							.findUnique();
//					assertThat(dispatch2).isNotNull();
//					assertThat(dispatch2.getStatus()).isEqualTo(Dispatch.STATUS_SENT);
//					assertThat(dispatch2.getDispatchTime()).isNotNull();
//					assertThat(dispatch2.getReadTime()).isNull();
//					assertThat(dispatch2.getSolveTime()).isNull();
//					
//					dispatch1.delete();
//					dispatch2.delete();
//					updatedEvent.setServiceOperator(null);
//					updatedEvent.save();
//				}
//			});
//		}

	//	@Test
	//	public void testGetPriorityOneEvents(){
	//		running(fakeApplication(), new Runnable() {
	//			public void run() {
	//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/priorityOneEvents");
	//
	//				Result result = Helpers.routeAndCall(fakeLogOutRequest
	//						.withSession("id", "S1")
	//						//.withFormUrlEncodedBody(paras)
	//						);
	//
	//				String content = contentAsString(result);
	//				JsonNode json = Json.parse(content);
	//			//	System.out.println("Content = " + content);
	//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
	//				JsonNode events = json.get("events");
	//				assertThat(events.size()).isEqualTo(2);
	//
	//
	//			}
	//		});
	//	}

	//	@Test
	//	public void testGetEventsStatus(){
	//		running(fakeApplication(), new Runnable() {
	//			public void run() {
	//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/eventsStatus");
	//
	//				Result result = Helpers.routeAndCall(fakeLogOutRequest
	//						.withSession("id", "S1")
	//						//.withFormUrlEncodedBody(paras)
	//						);
	//
	//				String content = contentAsString(result);
	//				JsonNode json = Json.parse(content);
	//				//System.out.println("Content = " + content);
	//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
	//				JsonNode events = json.get("statues");
	//				assertThat(events.size()).isEqualTo(4);
	//
	//
	//			}
	//		});
	//	}

//	@Test
//	public void testGetEventByIDWithValidID(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/eventFromID");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("eventID","11");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//												.withSession("id", "S1")
//												.withFormUrlEncodedBody(paras));
//				String content = contentAsString(result);
//				System.out.println("Content = " + content);
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//
//			}
//		});
//	}
	
//	@Test
//	public void testGetEventByIDWithInValidID(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/eventFromID");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("eventID","12");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//												.withSession("id", "S1")
//												.withFormUrlEncodedBody(paras));
//				String content = contentAsString(result);
//				System.out.println("Content = " + content);
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//
//			}
//		});
//	}
	
//	@Test
//	public void testSMSEvent(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/broadcastSMS");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("eventID","11");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//												.withSession("id", "S1")
//												.withFormUrlEncodedBody(paras));
//				String content = contentAsString(result);
//				System.out.println("Content = " + content);
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//
//			}
//		});
//	}
	
//	@Test
//	public void testEmailEvent(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("GET","/serviceoperator/sendReport");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("eventID","44");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//												.withSession("id", "S1")
//												.withFormUrlEncodedBody(paras));
//				String content = contentAsString(result);
//			//	System.out.println("Content = " + content);
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//
//			}
//		});
//	}
	
	


}
