package controllers;

import com.avaje.ebean.Ebean;

import models.*;
import play.mvc.*;
import util.HelperClass;

public class Application extends Controller {

    public static Result index() {
    	CallOperator callOperator = Ebean.find(CallOperator.class,4);
   // 		Event e = callOperator.getEvents().get(0);
    		
    		return ok("Save successful... ");
    //    return ok(index.render("Your new application is ready. Where is my DB??"));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result logout(){
		String id = session().get("id");
		if(id == null) return ok(HelperClass.jsonNodeForError("User is not currently logged in"));
		session().clear();
		return ok(HelperClass.jsonNodeForSuccess("CallOperator + " + id + " logged out successfully"));
	}
}
