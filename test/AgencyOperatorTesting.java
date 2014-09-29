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
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
public class AgencyOperatorTesting {

//	@Test
//	public void testSuccessfulCallOperatorLogin(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/login");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","1");
//				paras.put("password", "11");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
//				String content = contentAsString(result);
//
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				assertThat(json.get("name").asText()).isEqualTo("Emergency Ambulance");
//			}
//		});
//	}
//	
//	@Test
//	public void testFailedCallOperatorLogin(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/login");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","2");
//				paras.put("password", "23");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(1);
//			}
//		});
//	}
	
//	@Test
//	public void testGetSentEvents(){
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/sentEvents");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","1");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//														.withSession("id", "A1")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				//System.out.println("Content = " + content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				assertThat(json.get("events").size()).isEqualTo(2);
//			}
//		});
//	}
	
//	@Test
//	public void testGetReadEventsWithEmptyList(){
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/readEvents");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","1");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//														.withSession("id", "A1")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				System.out.println("Content = " + content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				assertThat(json.get("events").size()).isEqualTo(0);
//			}
//		});
//	}
	
//	@Test
//	public void testGetReadEventsWithNonEmptyList(){
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/readEvents");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","2");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//														.withSession("id", "A1")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//			//	System.out.println("Content = " + content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				assertThat(json.get("events").size()).isEqualTo(1);
//			}
//		});
//	}
	
//	@Test
//	public void testGetSolvedEventsWithNonEmptyList(){
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/solvedEvents");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","3");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//														.withSession("id", "A1")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//			//	System.out.println("Content = " + content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				assertThat(json.get("events").size()).isEqualTo(1);
//			}
//		});
//	}
	
//	@Test
//	public void testReadEvent(){
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/readEvent");
//				Map<String,String> paras = new HashMap<>();
//				
//				int testEventID = 11;
//				int testAgencyID = 1;
//				
//				paras.put("eventID","" + testEventID);
//				paras.put("agencyID","" + testAgencyID);
//
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//														.withSession("id", "A1")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				//System.out.println("Content = " + content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//
//				Dispatch dispatch = Dispatch.find
//										.where()
//										.eq("event.id",testEventID)
//										.eq("agency.id", testAgencyID)
//										.findUnique();
//				
//				assertThat(dispatch).isNotNull();
//				assertThat(dispatch.getStatus()).isEqualTo(Dispatch.STATUS_READ);
//				assertThat(dispatch.getReadTime()).isNotNull();
//				
//				dispatch.setStatus(Dispatch.STATUS_SENT);
//				dispatch.setReadTime(null);
//				dispatch.save();
//			}
//		});
//	}
	
//	@Test
//	public void testSolveEvent(){
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/agency/solveEvent");
//				Map<String,String> paras = new HashMap<>();
//				
//				int testEventID = 11;
//				int testAgencyID = 2;
//				
//				paras.put("eventID","" + testEventID);
//				paras.put("agencyID","" + testAgencyID);
//
//				Result result = Helpers.routeAndCall(fakeLogOutRequest
//														.withSession("id", "A1")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				System.out.println("Content = " + content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//
//				Dispatch dispatch = Dispatch.find
//										.where()
//										.eq("event.id",testEventID)
//										.eq("agency.id", testAgencyID)
//										.findUnique();
//				
//				assertThat(dispatch).isNotNull();
//				assertThat(dispatch.getStatus()).isEqualTo(Dispatch.STATUS_SOLVED);
//				assertThat(dispatch.getSolveTime()).isNotNull();
//				
//				dispatch.setStatus(Dispatch.STATUS_READ);
//				dispatch.setSolveTime(null);
//				dispatch.save();
//			}
//		});
//	}

}
