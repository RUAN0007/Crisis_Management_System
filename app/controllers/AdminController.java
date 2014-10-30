package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Admin;
import models.Agency;
import models.CallOperator;
import models.EventType;
import models.ServiceOperator;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.HelperClass;

public class AdminController extends Controller{


	private static final String AGENCY = "Agency";
	private static final String SERVICE_OPERATOR = "Service Operator";
	private static final String CALL_OPERATOR = "Call Operator";


	@Security.Authenticated(AdminSecured.class)
	public static Result main(){
		String message = flash("message");
		return ok(views.html.main.render(message));
	}
	
	@Security.Authenticated(AdminSecured.class)
	public static Result manageAgencyEventTypeRelationship(){
		List<EventType> types = EventType.find.where("id != 0").findList();
		List<Agency> agencies = Agency.find.where("id != 0").findList();
		return ok(views.html.relationship.render(types,agencies));
	}
	

	@Security.Authenticated(AdminSecured.class)
	public static Result manageRelationship(){
		List<EventType> eventTypes = EventType.find.where("id != 0").fetch("responsibleAgencies").findList();
		List<Agency> agencies = Agency.find.where("id != 0").fetch("responsibleEventTypes").findList();
		DynamicForm requestData = Form.form().bindFromRequest();
		for(EventType type:eventTypes){
			type.getResponsibleAgencies().clear();

			for(Agency agency:agencies){
				if(requestData.get("" + type.getId() + "." + agency.getId()) != null){
					type.getResponsibleAgencies().add(agency);
				}
			}
			type.save();

		}
		
		flash("message","New Agency-Event Type relationship saved...");

		return redirect("/main");
	}

	public static Result index(){
		String message = flash("message");
		if(message == null) {
			message = "Welcome to CMS!";
		}
		if(session("id") == null){
			return ok(views.html.index.render(message));
		}else{
			flash("message","You have already logged in as admin ...");
			return redirect("/main");
		}
	}

	public static Result validateAdmin(){
		DynamicForm requestData = Form.form().bindFromRequest();
		long userID = Long.parseLong(requestData.get("userID"));
		String pwd = requestData.get("password");
		
		Admin admin = Admin.authenticate(userID, pwd);
		if(admin != null){
			session("id","M" + admin.getId());
			flash("message","Welcome, " + admin.getName());
			return redirect("/main");
		}
		flash("message","Username/password is incorrect");
		return redirect("/"	);
	
	
	}

	@Security.Authenticated(AdminSecured.class)
	public static Result renderManageUserView(){
		List<String> types = new ArrayList<String>();
		types.add(CALL_OPERATOR);
		types.add(SERVICE_OPERATOR);
		types.add(AGENCY);

		return ok(views.html.manageUser.render(types));
	}

	@Security.Authenticated(AdminSecured.class)
	public static Result addUser(){
		DynamicForm requestData = Form.form().bindFromRequest();
		String name = requestData.get("name");
		String phone = requestData.get("phone");
		String type = requestData.get("type");

		Long id = HelperClass.getRandomPersonnelID();
		String pwd  = "000000";
		String message;
		if(type.equals(CALL_OPERATOR)){
			CallOperator co = new CallOperator();
			co.setID(id);
			co.setName(name);
			co.setPhone(phone);
			co.setPassword(pwd);
			co.save();
			message = "A record for Call Operator " + name + " has been generated...\n";
			message += "Its auto-generated UserID is " + id + " and password is " + pwd;
		}else if(type.equals(SERVICE_OPERATOR)){
			ServiceOperator so = new ServiceOperator();
			so.setId(id);
			so.setName(name);
			so.setPhone(phone);
			so.setPassword(pwd);
			so.save();
			message = "A record for Service Operator " + name + " has been generated...\n";
			message += "Its auto-generated UserID is " + id + " and password is " + pwd;
		}else if(type.equals(AGENCY)){
			Agency agency = new Agency();
			agency.setID(id);
			agency.setName(name);
			agency.setPhone(phone);
			agency.setPassword(pwd);
			agency.save();

			message = "A record for Agency " + name + " has been generated...\n";
			message += "Its auto-generated UserID is " + id + " and Password is " + pwd;

		}else{
			message = "Invalid User Type";
		}

		flash("message",message);
		return redirect("/main");

	}

	@Security.Authenticated(AdminSecured.class)
	public static Result deleteUser(){
		DynamicForm requestData = Form.form().bindFromRequest();
		Long id = Long.parseLong(requestData.get("userID"));
		String pwd = requestData.get("password");
		String type = requestData.get("type");
		String message = null;
		
		try{
			if(type.equals(CALL_OPERATOR)){
				CallOperator co = CallOperator.authenticate(id, pwd);
				String name = co.getName();
				co.delete();
				message = "A record for Call Operator " + name + " has been deleted...\n";
			}else if(type.equals(SERVICE_OPERATOR)){
				ServiceOperator so = ServiceOperator.authenticate(id, pwd);
				String name = so.getName();
				so.delete();
				message = "A record for Service Operator " + name + " has been deleted...\n";
			}else if(type.equals(AGENCY)){
				Agency agency = Agency.authenticate(id, pwd);
				String name = agency.getName();
				agency.delete();
				message = "A record for Agency " + name + " has been deleted...\n";

			}else{
				message = "Invalid User Type";
			}
		}catch(NullPointerException e){
			message = "The entry does not exist";
		}
		
		flash("message",message);
		return redirect("/main");
	}

	@Security.Authenticated(AdminSecured.class)
	public static Result renderManageEventTypesView(){
		List<EventType> types = EventType.find.where("id != 0").findList();
		return ok(views.html.manageEventType.render(types));
	}

	public static Result addEventType(){
		DynamicForm requestData = Form.form().bindFromRequest();	
		String name = requestData.get("name");
		String description = requestData.get("description");
		EventType type = new EventType();
		type.setEventType(name);
		type.setDescription(description);
		type.save();

		flash("message","Event Type " + name + " Added...");
		return redirect("/main");

	}

	public static Result deleteEventType(){
		DynamicForm requestData = Form.form().bindFromRequest();	
		Long typeID = Long.parseLong(requestData.get("type"));
		EventType type = EventType.find.byId(typeID);
		String name = type.getEventType();
		type.delete();

		flash("message","Event Type " + name + " removed...");
		return redirect("/main");
	}

}
