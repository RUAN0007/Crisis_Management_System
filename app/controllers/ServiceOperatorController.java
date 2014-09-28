package controllers;

import java.util.ArrayList;
import java.util.List;

import models.*;

import com.fasterxml.jackson.databind.JsonNode;
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
			int priority = Integer.parseInt(paras.get("serviceOperatorID").toString());
			
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
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}
    
    @Security.Authenticated(ServiceOperatorSecured.class)
   	public static Result getPriorityOneEvents(){
    	try{
		List<Event> priorityOneEvent = Event.find
					.where()
					.eq("priority", 1)
					.findList();
			
			ObjectNode result = Json.newObject();
			result.put("error", 0);
			result.put("events", ControllerUtil.getEventsArrayNode(priorityOneEvent));
			return ok(result);
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
    }
	
}
