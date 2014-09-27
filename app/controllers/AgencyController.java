package controllers;

import models.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import util.HelperClass;

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
			return ok(HelperClass.jsonNodeForError("Agency " + userID + "  id should only consist of digits..."));
		}
		
		Agency agency = Agency.authenticate(id, pwd);
		if(agency == null){
			session().clear();
			return ok(HelperClass.jsonNodeForError("Agency " + userID + "  validation failed..."));
		}
		
		session().put("id", "A" + id); //Starting C refers to CallOperator

		ObjectNode agencyResult = Json.newObject();
		
		
		agencyResult.put("error", 0);
		agencyResult.put("id", "" + id);
		agencyResult.put("name",agency.getName());
		agencyResult.put("phone", agency.getPhone());
		return ok(agencyResult);
	}
	
//    @Security.Authenticated(AgencySecured.class)
//    public static Result getSentEvents(){
//    		
//    }
}
