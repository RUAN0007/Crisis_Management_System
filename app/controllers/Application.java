package controllers;

import com.avaje.ebean.Ebean;

import models.*;
import play.mvc.*;

public class Application extends Controller {

    public static Result index() {
    	CallOperator callOperator = Ebean.find(CallOperator.class,4);
    		Event e = callOperator.getEvents().get(0);
    		
    		return ok("Event Type: " + e.getEventType());
    //    return ok(index.render("Your new application is ready. Where is my DB??"));
    }

}
