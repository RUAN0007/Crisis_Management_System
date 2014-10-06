package controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import models.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;



public class ServiceOperatorController extends Controller {
	public static Result login(){
		DynamicForm requestData = Form.form().bindFromRequest();
		String userID = requestData.get("id");
		String pwd = requestData.get("password");
		Long id = null;
		try{
			id = Long.parseLong(userID);
		}catch(NumberFormatException e){
			session().clear();
			return ok(ControllerUtil.jsonNodeForError("CallOperator " + userID + "  id should only consist of digits..."));
		}

		ServiceOperator serviceOperator = ServiceOperator.authenticate(id, pwd);
		if(serviceOperator == null){
			session().clear();
			return ok(ControllerUtil.jsonNodeForError("CallOperator " + userID + "  validation failed..."));
		}

		session().put("id", "S" + id); //Starting C refers to CallOperator

		ObjectNode serviceOperatorResult = Json.newObject();


		serviceOperatorResult.put("error", 0);
		serviceOperatorResult.put("id", "" + id);
		serviceOperatorResult.put("name",serviceOperator.getName());
		serviceOperatorResult.put("phone", serviceOperator.getPhone());
		return ok(serviceOperatorResult);
	}

	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result getUnclassifiedEvents(){
		try{
			List<Event> unclassfiedEvents = Event.find
					.where()
					.eq("eventType.id", 0)
					.isNull("serviceOperator")
					.orderBy("callingTime asc")
					.findList();

			ObjectNode result = Json.newObject();
			result.put("error", 0);
			result.put("events", ControllerUtil.getEventsArrayNode(unclassfiedEvents));
			return ok(result);
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}

	}

	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result updateEvent(){
		try{
			
			JsonNode paras = request().body().asJson();
			Long eventID = Long.parseLong(paras.get("eventID").toString());
			Long serviceOperatorID = Long.parseLong(paras.get("serviceOperatorID").toString());
			int priority = Integer.parseInt(paras.get("priority").toString());

			Event event = Event.find.byId(eventID);
			ServiceOperator serviceOperator = ServiceOperator.find.byId(serviceOperatorID);

			event.setPriority(priority);			
			event.setServiceOperator(serviceOperator);
			event.save();

			JsonNode agenciesID = paras.get("relevantAgenciesIDs");
			int agencyCount = agenciesID.size();

			List<Agency> agencies = new ArrayList<>();
			for(int agencyIndex = 0;agencyIndex < agencyCount;agencyIndex++){
				Long agencyID = Long.parseLong(agenciesID.get(agencyIndex).toString());
				Agency agency = Agency.find.byId(agencyID);
				agencies.add(agency);
			}
			EventCenter.getDefaultEventCenter().handleClassifiedEvents(event,agencies);

			return ok(ControllerUtil.jsonNodeForSuccess("Update for Event " + eventID + " successfully..."));
		}catch(Exception e){
			e.printStackTrace();
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}

	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result getPriorityOneEvents(){
		int withInDay = 1;
		//Get Event of Priority One event on that day
		Timestamp lowerTimeBound = new Timestamp(System.currentTimeMillis()
													-withInDay * 24 * 60 * 60 * 1000);
		try{
			List<Event> priorityOneEvent = Event.find
					.where()
					.eq("priority", 1)
			//TODO Temporally comment it out for testing
			//		.gt("callingTime", lowerTimeBound)
					.orderBy("callingTime asc")
					.findList();

			ObjectNode result = Json.newObject();
			result.put("error", 0);
			result.put("events", ControllerUtil.getEventsArrayNode(priorityOneEvent));
			return ok(result);
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}

	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result smsEvent(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long	 eventID = Long.parseLong(requestData.get("eventID"));
			Event event = Event.find.byId(eventID);
			if(event == null){
				return ok(ControllerUtil.jsonNodeForError("The EventID " + eventID + " is invalid..."));
			}
			if(event.getPriority() != 1){
				return ok(ControllerUtil.jsonNodeForError("The EventID " + eventID + " is qualified for broadcasting sms..."));
			}
			if(EventCenter.getDefaultEventCenter().broadcastSMSToPublic(event)){
				return ok(ControllerUtil.jsonNodeForSuccess("SMS Event " + eventID + " Succeeded..."));
			}else{
				return ok(ControllerUtil.jsonNodeForError("SMS Event " + eventID + " Failed..."));
			}
			
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}
	
	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result emailEvent(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long	 eventID = Long.parseLong(requestData.get("eventID"));
			Event event = Event.find.byId(eventID);
			if(event == null){
				return ok(ControllerUtil.jsonNodeForError("The EventID " + eventID + " is invalid..."));
			}
			if(event.getPriority() != 1){
				return ok(ControllerUtil.jsonNodeForError("The EventID " + eventID + " is qualified for emergent report..."));
			}
			if(EventCenter.getDefaultEventCenter().sendEventReport(event)){
				return ok(ControllerUtil.jsonNodeForSuccess("Email Event " + eventID + " Succeeded..."));
			}else{
				return ok(ControllerUtil.jsonNodeForError("Email Event " + eventID + " Failed..."));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}
	
	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result getEventByID(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long	 eventID = Long.parseLong(requestData.get("eventID"));
			Event event = Event.find.byId(eventID);
			if(event == null)  {
				return ok(ControllerUtil.jsonNodeForError("Invalid Event ID " + eventID)); 
			}
			ObjectNode eventResult = Json.newObject();
			eventResult.put("error", 0);
			eventResult.put("event", ControllerUtil.getEventJsonNode(event));
			return ok(eventResult);
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}
	
	@Security.Authenticated(ServiceOperatorSecured.class)
	public static Result getEventsStatus(){
		try{
			int withInDay = 1;
			Timestamp lowerTimeBound = new Timestamp(System.currentTimeMillis()
														- withInDay * 24 * 60 * 60 * 1000);
			
			List<Dispatch> dispatches = Dispatch.find
			//TODO Uncomment the following two lines to only retrieve dispatches within one day
//												.where()
//												.gt("dispatchTime",lowerTimeBound)
												.orderBy("dispatchTime asc")
												.findList();
			ObjectNode statuesResult = Json.newObject();
			statuesResult.put("error", 0);
			
			ArrayNode dispatchesNode = new ArrayNode(JsonNodeFactory.instance);
			
			for(Dispatch dispatch:dispatches){
				
				ObjectNode dispatchNode = Json.newObject();
				dispatchNode.put("eventID",dispatch.getEvent().getId());
				dispatchNode.put("agencyName",dispatch.getAgency().getName());
				dispatchNode.put("status",dispatch.getStatus());
				dispatchNode.put("dispatchTime",dispatch.getDispatchTime().getTime());
				if(!dispatch.getStatus().equals(Dispatch.STATUS_SENT)){
					dispatchNode.put("readTime",dispatch.getReadTime().getTime());
				}
				if(dispatch.getStatus().equals(Dispatch.STATUS_SOLVED)){
					dispatchNode.put("solveTime",dispatch.getSolveTime().getTime());
				}

				dispatchesNode.add(dispatchNode);
			}
			statuesResult.put("statues",dispatchesNode);
			return ok(statuesResult);
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
		
		
		
	}
	
}
