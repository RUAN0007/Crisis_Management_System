package controllers;

import java.util.ArrayList;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import util.HelperClass;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Security;
import models.*;
import play.mvc.*;

public class CallOperatorController extends Controller {
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
		
		CallOperator callOperator = CallOperator.authenticate(id, pwd);
		if(callOperator == null){
			session().clear();
			return ok(ControllerUtil.jsonNodeForError("CallOperator " + userID + "  validation failed..."));
		}
		
		session().put("id", "C" + id); //Starting C refers to CallOperator

		ObjectNode callOperatorResult = Json.newObject();
		
		
		callOperatorResult.put("error", 0);
		callOperatorResult.put("id", "" + id);
		callOperatorResult.put("name",callOperator.getName());
		callOperatorResult.put("phone", callOperator.getPhone());
		return ok(callOperatorResult);
	}
	
	
    @Security.Authenticated(CallOperatorSecured.class)
	public static Result report(){
		DynamicForm requestData = Form.form().bindFromRequest();
		
		try{
			EventType eventType = Ebean.find(EventType.class,Long.parseLong(requestData.get("eventTypeID")));
			
			CallOperator callOperator = Ebean.find(CallOperator.class,Long.parseLong(requestData.get("callOperatorID")));
			
			String priorityStr = requestData.get("priority");
			
			String postalCode = requestData.get("postalCode");
			
			String location = requestData.get("location");
			
			String callerPhone = requestData.get("callerPhone");

			String description = requestData.get("description");

			Event reportedEvent = new Event();
			
			reportedEvent.setId(HelperClass.getRandomLong());
			reportedEvent.setEventType(eventType);
			reportedEvent.setCallOperator(callOperator);
			reportedEvent.setCallerPhone(callerPhone);
			reportedEvent.setCallingTime(HelperClass.getCurrentTimestamp());
			reportedEvent.setDescription(description);
			reportedEvent.setLocation(location);
			reportedEvent.setPostalCode(postalCode);
			reportedEvent.setPriority(Integer.parseInt(priorityStr));

			reportedEvent.save();

			if(eventType.getId() != 0){
				EventCenter.getDefaultEventCenter().handleIncomingEvent(reportedEvent);
			}

		}catch(Exception e){
				e.printStackTrace();
				return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
			//	return ok(ControllerUtil.jsonNodeForError("Uploading failed..."));
		}
		return ok(ControllerUtil.jsonNodeForSuccess("Uploading succeeded..."));
	}
	
}
