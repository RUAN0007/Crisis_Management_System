package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import util.HelperClass;
/**
 * The class to respond the general http request
 * @author ruanpingcheng
 *
 */
public class Application extends Controller {

	public static Result test() {
		long lowerTimeBound = System.currentTimeMillis() - 30 * 60 * 1000;
		List<Event> events = Event.find.where().lt("callingTime", new Timestamp(lowerTimeBound)).
				orderBy("callingTime asc")
				.findList();

		return ok(ControllerUtil.getEventsArrayNode(events));
		//		return ok("Yes, we can!!");
	}

	@Security.Authenticated(Secured.class)
	public static Result logout(){
		String id = session().get("id");
		if(id == null) return ok(ControllerUtil.jsonNodeForError("User is not currently logged in"));
		session().clear();
		return ok(ControllerUtil.jsonNodeForSuccess("User + " + id + " logged out successfully"));
	}

	/**
	 * Retrieve a list of events in json format that belongs to the type specified by <typeID> and with in <timePeriodInHour> hours.
	 * @returna a list of requested events
	 */
	public static Result getEventsBytypeID(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long typeID = Long.parseLong(requestData.get("typeID"));
			int timePeriodInMin = Integer.parseInt(requestData.get("timePeriodInHour")) * 60;

			String eventType = eventTypeByID(typeID);
			if(eventType == null){
				return ok(ControllerUtil.jsonNodeForError("Invalid Event Type ID..."));
			}

			//List<Event> events = Event.find.fetch("eventType").where("eventType.id=" + typeID).orderBy("callingTime desc").findList();
			//List<Event> events = EventCenter.getDefaultEventCenter().getEventsWithinMin(timePeriodInMin, typeID);
			long lowerTimeBound = System.currentTimeMillis() - timePeriodInMin * 60 * 1000;
			//TODO temporally comment it out the code for testing purpose
			List<Event> events = Event.find.where()
					//.gt("callingTime", lowerTimeBound)
					.eq("eventType.id", typeID)
					.orderBy("callingTime desc")
					.findList();

			ObjectNode results = Json.newObject();
			results.put("error", 0);
			ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
			results.put("events", eventsNode);
			return ok(results);

		}catch(Exception e){
			e.printStackTrace();
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}

	}

	private static String eventTypeByID(Long typeID){
		EventType type = Ebean.find(EventType.class, typeID);
		if(type == null){
			return null;
		}else{
			return type.getEventType();
		}
	}

	public static Result getEventTypes(){

		try{
			ObjectNode resultNode = Json.newObject();
			List<EventType> eventTypes = EventType.find.where("id != 0").findList();
			resultNode.put("error", 0);
			ArrayNode eventTypesNode = new ArrayNode(JsonNodeFactory.instance);

			for(EventType eventType:eventTypes){
				ObjectNode eventTypeNode = Json.newObject();
				eventTypeNode.put("id", eventType.getId());
				eventTypeNode.put("name", eventType.getEventType());
				eventTypesNode.add(eventTypeNode);
			}
			resultNode.put("eventTypes", eventTypesNode);
			return ok(resultNode);

		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}

	public static Result getAgencies(){

		try{
			ObjectNode resultNode = Json.newObject();
			List<Agency> agencies = Ebean.find(Agency.class).findList();
			resultNode.put("error", 0);
			ArrayNode agenciesNode = new ArrayNode(JsonNodeFactory.instance);

			for(Agency agency:agencies){
				ObjectNode agencyNode = Json.newObject();
				agencyNode.put("id", agency.getId());
				agencyNode.put("name", agency.getName());
				agenciesNode.add(agencyNode);
			}

			resultNode.put("Agencies", agenciesNode);
			return ok(resultNode);
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}

	//TODO
	//Temporarily comment it out

	public static Result reportBug(){
		return ok(views.html.ReportBug.render());
	}
	//    
	public static Result recordBug(){
		MultipartFormData body = request().body().asMultipartFormData();

		DynamicForm requestData = Form.form().bindFromRequest();
		String subject = requestData.get("subject");
		String description = requestData.get("description");
		FilePart screenCapture = body.getFile("screenCapture");


		try{
			Path dirPath = Paths.get("bug" + File.separator + HelperClass.getFormattedCurrentTime());;
			Files.createDirectory(dirPath);

			Path reportPath = dirPath.resolve("report.txt");
			Files.createFile(reportPath);

			//Write the report to a text file
			BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath.toFile()));
			writer.append("Subject: " + subject + "\n");
			writer.append("Description: " + description);
			writer.close();

			//Save the screen capture
			File screenCaptureFile = screenCapture.getFile();
			String screenCaptureName = screenCapture.getFilename();
			screenCaptureFile.renameTo(dirPath.resolve(screenCaptureName).toFile());
			flash("message", "Bug Recorded...");

		} catch (Exception e) {
			flash("message", "Bug Recorded Failed...");
		}

		return redirect("/main");
	}

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

		return ok(views.html.index.render(message));
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
		types.add("call operator");
		types.add("service operator");
		types.add("agency");

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
		if(type.equals("call operator")){
			CallOperator co = new CallOperator();
			co.setID(id);
			co.setName(name);
			co.setPhone(phone);
			co.setPassword(pwd);
			co.save();
			message = "A record for Call Operator " + name + " has been generated...\n";
			message += "Its auto-generated UserID is " + id + " and password is " + pwd;
		}else if(type.equals("service operator")){
			ServiceOperator so = new ServiceOperator();
			so.setId(id);
			so.setName(name);
			so.setPhone(phone);
			so.setPassword(pwd);
			so.save();
			message = "A record for Service Operator " + name + " has been generated...\n";
			message += "Its auto-generated UserID is " + id + " and password is " + pwd;
		}else if(type.equals("agency")){
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
		if(type.equals("call operator")){
			CallOperator co = CallOperator.authenticate(id, pwd);
			String name = co.getName();
			co.delete();
			message = "A record for Call Operator " + name + " has been deleted...\n";
		}else if(type.equals("service operator")){
			ServiceOperator so = ServiceOperator.authenticate(id, pwd);
			String name = so.getName();
			so.delete();
			message = "A record for Service Operator " + name + " has been deleted...\n";
		}else if(type.equals("agency")){
			Agency agency = Agency.authenticate(id, pwd);
			String name = agency.getName();
			agency.delete();
			message = "A record for Agency " + name + " has been deleted...\n";

		}else{
			message = "Invalid User Type";
		}

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
