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
//    @Test
//    public void test() {
//        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
//            public void invoke(TestBrowser browser) {
//                browser.goTo("http://localhost:3333");
//                assertThat(browser.pageSource()).contains("Your new application is ready.");
//            }
//        });
//    }
	
	@Test
	public void testInServer() {
	  running(testServer(3333), new Runnable() {
	      public void run() {
	        		 JsonNode response =
	           WS.url("http://localhost:3333/calloperator/login").setQueryParameter("id", "4")
	           .setQueryParameter("password", "44")
	           .post("content").get().asJson();
	        		 System.out.println("Response = " + response);
	      }
	  });
	}

}
