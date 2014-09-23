import org.junit.*;

import play.mvc.*;
import play.test.*;
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
public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */

	
	@Test
	public void testCallOperatorLogin() {
	  running(testServer(3333), new Runnable() {
	      public void run() {
	        		 JsonNode response =
	           WS.url("http://localhost:3333/calloperator/login")
	           .setQueryParameter("id", "4")
	           .setQueryParameter("password", "44")
	           .post("content").get().asJson();
	        		 System.out.println("Response = " + response);
	      }
	  });
	}
	
	@Test
	public void testCallOperatorReport() {
	  running(testServer(3333), new Runnable() {
	      public void run() {

	        		 JsonNode reportUploadingResult =
	           WS.url("http://localhost:3333/calloperator/report")
	           .setQueryParameter("typeID", "1")
	           .setQueryParameter("callOperatorID", "4")
	           .setQueryParameter("priority", "1")
	           .setQueryParameter("postalCode", "666666")
	           .setQueryParameter("location", "Central")
	           .setQueryParameter("callerPhone", "98989898")
	           .setQueryParameter("description", "Hello World")
	           .post("content").get().asJson();
	        		
	        		System.out.println("Response = " + reportUploadingResult);
	      }
	  });
	}
	
	
}
