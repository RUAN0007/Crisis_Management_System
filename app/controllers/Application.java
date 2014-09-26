package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import util.HelperClass;

public class Application extends Controller {

    public static Result index() {
   // 		Event e = callOperator.getEvents().get(0);
//    		
//    		ObjectNode testNode = Json.newObject();
//    		testNode.put("Name", "RPC");
//    		testNode.put("Age",20);
//    		
//    		ObjectNode nestedNode = Json.newObject();
//    		nestedNode.put("Sports","Pingpong");
//    		nestedNode.put("Music","Flute");
//    		testNode.put("Hobby", nestedNode);
//    		
//    		ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
//    		arrayNode.add(1);
//    		arrayNode.add(2);
//    		arrayNode.add(3);
//    		testNode.put("Count", arrayNode);
//    		return ok(testNode);
        return ok("Hello World");
    }
    
    @Security.Authenticated(Secured.class)
    public static Result logout(){
		String id = session().get("id");
		if(id == null) return ok(HelperClass.jsonNodeForError("User is not currently logged in"));
		session().clear();
		return ok(HelperClass.jsonNodeForSuccess("CallOperator + " + id + " logged out successfully"));
	}
    
    public static Result reportBug(){
    		return ok(views.html.ReportBug.render());
    }
//    
    public static Result recordBug(){
    		DynamicForm requestData = Form.form().bindFromRequest();
		String subject = requestData.get("subject");
		String description = requestData.get("description");
		
    		return ok("subject: " + subject + " description: " + description);
    }
}
