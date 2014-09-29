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
public class CallOperatorTesting{

	/**
	 * add your integration test here
	 * in this example we just check if the welcome page is being shown
	 */


//	@Test
//	public void testSuccessfulCallOperatorLogin(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/calloperator/login");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","4");
//				paras.put("password", "44");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
//				String content = contentAsString(result);
//
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				assertThat(json.get("name").asText()).isEqualTo("RPC");
//			}
//		});
//	}
//	
//	@Test
//	public void testFailedCallOperatorLogin(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/calloperator/login");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("id","5");
//				paras.put("password", "54");
//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(1);
//			}
//		});
//	}
	
	@Test
	public void testReportPrority3Event(){

		running(fakeApplication(), new Runnable() {
			public void run() {
				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/calloperator/report");
				Map<String,String> paras = new HashMap<>();
				paras.put("eventTypeID", "1");
				paras.put("callOperatorID", "4");
				paras.put("priority", "3");
				paras.put("location", "Central");
				paras.put("postalCode", "666666");
				paras.put("callerPhone", "98989898");
				paras.put("description", "Hello World");

				Result result = Helpers.routeAndCall(fakeLogOutRequest.withSession("id", "C4")
														.withFormUrlEncodedBody(paras));

				String content = contentAsString(result);
				JsonNode json = Json.parse(content);
				System.out.println("Result = " + json.toString());
				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
				
				Event event = Event.find.where().eq("postalCode", "666666").findUnique();
				assertThat(event).isNotNull();
				event.delete();
			}
		});
	}
	
	//Test the following method when the facebook api token is ready
//	
//	@Test
//	public void testReportPrority2Event(){
//
//		running(fakeApplication(), new Runnable() {
//			public void run() {
//				FakeRequest fakeLogOutRequest = new FakeRequest("POST","/calloperator/report");
//				Map<String,String> paras = new HashMap<>();
//				paras.put("eventTypeID", "1");
//				paras.put("callOperatorID", "4");
//				paras.put("priority", "2");
//				paras.put("location", "Central");
//				paras.put("postalCode", "666666");
//				paras.put("callerPhone", "98989898");
//				paras.put("description", "Hello World");
//
//				Result result = Helpers.routeAndCall(fakeLogOutRequest.withSession("id", "C4")
//														.withFormUrlEncodedBody(paras));
//
//				String content = contentAsString(result);
//				JsonNode json = Json.parse(content);
//				System.out.println("Result = " + json.toString());
//				assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
//				
//				Event event = Event.find.where().eq("postalCode", "666666").findUnique();
//				assertThat(event).isNotNull();
//				event.delete();
//			}
//		});
//	}


}
