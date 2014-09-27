package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
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
		if(id == null) return ok(ControllerUtil.jsonNodeForError("User is not currently logged in"));
		session().clear();
		return ok(ControllerUtil.jsonNodeForSuccess("User + " + id + " logged out successfully"));
	}

	public static Result getEventsBytypeID(Long typeID){
		List<Event> events = Event.find.fetch("eventType").where("eventType.id=" + typeID).orderBy("callingTime desc").findList();
		String eventType = eventTypeByID(typeID);



		if(eventType == null){
			return ok(ControllerUtil.jsonNodeForError("Invalid Event Type ID..."));
		}

		ObjectNode results = Json.newObject();
		results.put("error", 0);

		ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
		results.put("events", eventsNode);
		return ok(results);
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

	//    public static Result reportBug(){
	//    		return ok(views.html.ReportBug.render());
	//    }
	////    
	//    public static Result recordBug(){
	//		MultipartFormData body = request().body().asMultipartFormData();
	//
	//    		DynamicForm requestData = Form.form().bindFromRequest();
	//		String subject = requestData.get("subject");
	//		String description = requestData.get("description");
	//		FilePart screenCapture = body.getFile("screenCapture");
	//		
	//		
	//		try{
	//			Path dirPath = Paths.get("bug" + File.separator + HelperClass.getFormattedCurrentTime());;
	//			Files.createDirectory(dirPath);
	//
	//			Path reportPath = dirPath.resolve("report.txt");
	//			Files.createFile(reportPath);
	//			
	//			//Write the report to a text file
	//			BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath.toFile()));
	//			writer.append("Subject: " + subject + "\n");
	//			writer.append("Description: " + description);
	//			writer.close();
	//			
	//			//Save the screen capture
	//			File screenCaptureFile = screenCapture.getFile();
	//			String screenCaptureName = screenCapture.getFilename();
	//			screenCaptureFile.renameTo(dirPath.resolve(screenCaptureName).toFile());
	//		
	//		} catch (Exception e) {
	//			// TODO Auto-generated catch block
	//			return ok(views.html.failedBugReportMessage.render());
	//
	//		}
	//		
	//		
	//		return ok(views.html.successfulBugReportMessage.render());
	//    }
}
