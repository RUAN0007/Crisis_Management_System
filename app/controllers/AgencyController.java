package controllers;

import java.sql.Timestamp;
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
import util.HelperClass;
/**
 * The class to response the request from agency
 * @author ruanpingcheng
 *
 */
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
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long agencyID = Long.parseLong(requestData.get("id"));

			List<Dispatch> dispatches = Dispatch.find
					.fetch("event")
					.fetch("agency")
					.where("agency.id = " + agencyID)
					.where()
					.eq("status", Dispatch.STATUS_SENT)
					.orderBy("dispatchTime asc")
					.findList();
			List<Event> events = new LinkedList<>();

			for(Dispatch	 dispatch:dispatches){
				events.add(dispatch.getEvent());
			}

			ObjectNode results = Json.newObject();
			results.put("error", 0);

			ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
			results.put("events", eventsNode);
			return ok(results);

		}catch(NumberFormatException e){
			return ok(ControllerUtil.jsonNodeForError("Has error on Number Format"));
		}catch(Exception e){
			e.printStackTrace();
			return ok(ControllerUtil.jsonNodeForError("An exception has occured in the server"));
		}
	}

	@Security.Authenticated(AgencySecured.class)
	public static Result getReadEvents(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long agencyID = Long.parseLong(requestData.get("id"));

			List<Dispatch> dispatches = Dispatch.find
					.fetch("event")
					.fetch("agency")
					.where("agency.id = " + agencyID)
					.where()
					.eq("status", Dispatch.STATUS_READ)
					.orderBy("readTime asc")
					.findList();
			List<Event> events = new LinkedList<>();

			for(Dispatch	 dispatch:dispatches){
				events.add(dispatch.getEvent());
			}

			ObjectNode results = Json.newObject();
			results.put("error", 0);

			ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
			results.put("events", eventsNode);
			return ok(results);

		}catch(NumberFormatException e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}catch(Exception e){
			e.printStackTrace();
			return ok(ControllerUtil.jsonNodeForError("An exception has occured in the server"));
		}
	}

	@Security.Authenticated(AgencySecured.class)
	public static Result getSolvedEvents(){
		try{
			int withInDay = 1;
			Timestamp lowerTimerBound = new Timestamp(System.currentTimeMillis() 
					- withInDay * 24 * 60 * 60 * 1000);

			DynamicForm requestData = Form.form().bindFromRequest();
			Long agencyID = Long.parseLong(requestData.get("id"));

			//Get the solved events within 1 day
			List<Dispatch> dispatches = Dispatch.find
					.fetch("event")
					.fetch("agency")
					.where("agency.id = " + agencyID)
					.where()
					.eq("status", Dispatch.STATUS_SOLVED)
					//TODO Temporally comment it out for testing
					//				.gt("solveTime",lowerTimerBound)
					.orderBy("solveTime asc")
					.findList();
			List<Event> events = new LinkedList<>();

			for(Dispatch	 dispatch:dispatches){
				events.add(dispatch.getEvent());
			}

			ObjectNode results = Json.newObject();
			results.put("error", 0);

			ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
			results.put("events", eventsNode);
			return ok(results);

		}catch(NumberFormatException e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}catch(Exception e){
			e.printStackTrace();
			return ok(ControllerUtil.jsonNodeForError("An exception has occured in the server"));
		}
	}

	//	private static ObjectNode getEventsByStatusResult(Long agencyID,String status,int withInDay){
	//		try{
	//
	//			List<Event> events = getEvents(agencyID,status,withInDay);
	//
	//			if(events.size() == 0){
	//				return ControllerUtil.jsonNodeForError("No qualified events...");
	//			}
	//
	//			ObjectNode results = Json.newObject();
	//			results.put("error", 0);
	//
	//			ArrayNode eventsNode = ControllerUtil.getEventsArrayNode(events);
	//			results.put("events", eventsNode);
	//			return results;
	//
	//		}catch(Exception e){
	//			return ControllerUtil.jsonNodeForError(e.getMessage());
	//		}
	//	}

	//Testing this method
	//	private static List<Event> getEvents(Long agencyID,String status,int withInDay){
	//		long lowerTimerBound = System.currentTimeMillis() - withInDay * 24 * 60 * 60 * 1000;
	//
	//		List<Dispatch> dispatches = Dispatch.find
	//				.fetch("event")
	//				.fetch("agency")
	//				.where("agency.id = " + agencyID)
	//				.where()
	//				.eq("status", status)
	//				.gt("dispatchTime", lowerTimerBound)
	//				.findList();
	//		List<Event> events = new LinkedList<>();
	//
	//		for(Dispatch	 dispatch:dispatches){
	//			events.add(dispatch.getEvent());
	//		}
	//		return events;
	//	}

	@Security.Authenticated(AgencySecured.class)
	public static Result readEvent(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long eventID = Long.parseLong(requestData.get("eventID"));
			Long agencyID = Long.parseLong(requestData.get("agencyID"));
			Dispatch dispatch = getDispatch(agencyID,eventID);
			if(dispatch == null){
				return ok(ControllerUtil.
						jsonNodeForError(
								"Record on Event " +
										eventID + 
										" for Agency " + 
										agencyID + 
										" does not exist..."
								)
						); 
			}

			if(setDispatchStatus(dispatch, Dispatch.STATUS_READ)){
				return ok(ControllerUtil.
						jsonNodeForSuccess(
								"Set Event " + eventID + 
								" for Agency " + agencyID +  
								" to READ succeeded..."
								)
						); 
			}else{
				return ok(ControllerUtil.
						jsonNodeForError(
								"Set Event " + eventID + 
								" for Agency " + agencyID +  
								" to READ failed..."								)
						);
			}
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}	
	}


	@Security.Authenticated(AgencySecured.class)
	public static Result solveEvent(){
		try{
			DynamicForm requestData = Form.form().bindFromRequest();
			Long eventID = Long.parseLong(requestData.get("eventID"));
			Long agencyID = Long.parseLong(requestData.get("agencyID"));
			Dispatch dispatch = getDispatch(agencyID,eventID);
			if(dispatch == null){
				return ok(ControllerUtil.
						jsonNodeForError(
								"Record on Event " +
										eventID + 
										" for Agency " + 
										agencyID + 
										" does not exist..."
								)
						); 
			}
			if(setDispatchStatus(dispatch, Dispatch.STATUS_SOLVED)){
				return ok(ControllerUtil.
						jsonNodeForSuccess(
								"Set Event " + eventID + 
								" for Agency " + agencyID +  
								" to SOLVED succeeded..."
								)
						); 
			}else{
				return ok(ControllerUtil.
						jsonNodeForError(
								"Set Event " + eventID + 
								" for Agency " + agencyID +  
								" to SOLVED failed..."								)
						);
			}
		}catch(Exception e){
			return ok(ControllerUtil.jsonNodeForError(e.getMessage()));
		}	
	}

	private static boolean setDispatchStatus(Dispatch dispatch,String status){
		if(status.equals(Dispatch.STATUS_READ)){
			if(dispatch.getStatus().equals(Dispatch.STATUS_SENT)){
				dispatch.setStatus(Dispatch.STATUS_READ);
				dispatch.setReadTime(HelperClass.getCurrentTimestamp());
				dispatch.save();
				return true;
			}else{
				return false;
			}
		}else if(status.equals(Dispatch.STATUS_SOLVED)){
			dispatch.setStatus(Dispatch.STATUS_SOLVED);
			dispatch.setSolveTime(HelperClass.getCurrentTimestamp());
			dispatch.save();
			return true;

		}else{
			return false;
		}
	}


	private static Dispatch getDispatch(Long agencyID, Long eventID) {
		Dispatch dispatch = Dispatch.find
				//							.fetch("event")
				//							.fetch("agency")
				//							.where("event.id = " + eventID)
				.where()
				.eq("event.id", eventID)
				//							.where("agency.id = " + agencyID)
				.where()
				.eq("agency.id", agencyID)
				.findUnique();
		return dispatch;
	}

}
