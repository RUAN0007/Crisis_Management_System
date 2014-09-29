import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.CallOperatorController;
import models.CallOperator;

import org.junit.*;

import models.*;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.Json;
import play.libs.F.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationControllerTest {

   @Test
   public void testLogOut(){
	   
	   running(fakeApplication(), new Runnable() {
		    public void run() {
		    	  FakeRequest fakeLogOutRequest = new FakeRequest("GET","/logout");
		   	   
		   	   Result result = Helpers.routeAndCall(fakeLogOutRequest.withSession("id", "asfasfasdf"));
		   	   String content = contentAsString(result);
		   	   JsonNode json = Json.parse(content);
		   	   assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);
		   	   }
		 });
   }
//   
   @Test
   public void testGetEventsBytypeID(){
	   
	   running(fakeApplication(), new Runnable() {
		    public void run() {
		    	  FakeRequest fakeLogOutRequest = new FakeRequest("POST","/events");
		   	   Map<String,String> paras = new HashMap<>();
		   	   paras.put("typeID","1");
		   	   paras.put("timePeriodInHour", "1");
		   	   Result result = Helpers.routeAndCall(fakeLogOutRequest.withFormUrlEncodedBody(paras));
		   	   String content = contentAsString(result);
		   	   JsonNode json = Json.parse(content);
		   	   
		   	   assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);

		   	   assertThat(json.get("events").size()).isEqualTo(2);
		   	   }
		 });
   }
//   
   @Test
   public void testGetEventTypes(){
	   
	   running(fakeApplication(), new Runnable() {
		    public void run() {
		    	  FakeRequest fakeLogOutRequest = new FakeRequest("GET","/getEventTypes");
		   	 
		   	   Result result = Helpers.routeAndCall(fakeLogOutRequest);
		   	   String content = contentAsString(result);
		   	   JsonNode json = Json.parse(content);
		   	   assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);

		   	   assertThat(json.get("eventTypes").size()).isEqualTo(5);
		    }	   
		 });
	   
   }
	
  @Test
  public void testGetAgencies(){
	   
	   running(fakeApplication(), new Runnable() {
		    public void run() {
		    	  FakeRequest fakeLogOutRequest = new FakeRequest("GET","/getAgencies");
//		   	 
		   	   Result result = Helpers.routeAndCall(fakeLogOutRequest);
		   	   String content = contentAsString(result);
		   	   JsonNode json = Json.parse(content);
		   	   assertThat(Integer.parseInt(json.get("error").toString())).isEqualTo(0);

		   	   assertThat(json.get("Agencies").size()).isEqualTo(5);

		   	   }
		 });
  }

}
