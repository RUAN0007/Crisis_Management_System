package controllers;

import java.util.LinkedList;
import java.util.List;

import models.*;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

public class AgencyController extends Controller {


	public static Result login(){
		DynamicForm requestData = Form.form().bindFromRequest();
		String userID = requestData.get("id");
		String pwd = requestData.get("password");
		Long id = null;
		try{
			id = Long.parseLong(userID);
		}catch(NumberFormatException e){
			session().clear();
			return ok(ControllerUtil.jsonNodeForError("Agency " + userID + "  id should only consist of digits..."));
		}

		Agency agency = Agency.authenticate(id, pwd);
		if(agency == null){
			session().clear();
			return ok(ControllerUtil.jsonNodeForError("Agency " + userID + "  validation failed..."));
		}

		session().put("id", "A" + id); //Starting C refers to CallOperator

		ObjectNode agencyResult = Json.newObject();


		agencyResult.put("error", 0);
		agencyResult.put("id", "" + id);
		agencyResult.put("name",agency.getName());
		agencyResult.put("phone", agency.getPhone());
		return ok(agencyResult);
	}

	@Security.Authenticated(AgencySecured.class)
	public static Result getSentEvents(){
		DynamicForm requestData = Form.form().bindFromRequest();
		Long agencyID = Long.parseLong(requestData.get("id"));
		return getEventsByStatus(agencyID,Dispatch.STATUS_SENT);
	}

	public static Result getReadEvents(){
		DynamicForm requestData = Form.form().bindFromRequest();
		Long agencyID = Long.parseLong(requestData.get("id"));
		return getEventsByStatus(agencyID,Dispatch.STATUS_READ);
	}

	public static Result getSolvedEvents(){
		DynamicForm requestData = Form.form().bindFromRequest();
		Long agencyID = Long.parseLong(requestData.get("id"));
		return getEventsByStatus(agencyID,Dispatch.STATUS_SOLVED);
	}

	private static Result getEventsByStatus(Long agencyID,String status){
		try{
		
			List<Event> events = getEvents(agencyID,status);

			ObjectNode results = Json.newObject();
			results.put("error", 0);

			ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
			results.put("events", eventsNode);
			return ok(results);

		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}
	}

	private static List<Event> getEvents(Long agencyID,String status){
		List<Dispatch> dispatches = Dispatch.find.fetch("event")
				.fetch("agency")
				.where("agency.id = " + agencyID)
				.where()
				.eq("status", status)
				.findList();
		List<Event> events = new LinkedList<>();
		for(Dispatch	 dispatch:dispatches){
			events.add(dispatch.getEvent());
		}
		return events;
	}
}
