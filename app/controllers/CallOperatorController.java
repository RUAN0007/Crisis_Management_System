package controllers;

import org.h2.engine.Session;

import com.fasterxml.jackson.databind.node.ObjectNode;

import util.HelperClass;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import models.*;
import play.mvc.*;

public class CallOperatorController extends Controller {
	public static Result loginAsCallOperator(){
		DynamicForm requestData = Form.form().bindFromRequest();
		String userID = requestData.get("userID");
		String pwd = requestData.get("password");
		Long id = null;
		try{
			 id = Long.parseLong(userID);
		}catch(NumberFormatException e){
			session().clear();
			return ok(HelperClass.jsonNodeForError("CallOperator " + userID + "  id should only consist of digits..."));
		}
		
		CallOperator callOperator = CallOperator.authenticate(id, pwd);
		if(callOperator == null){
			session().clear();
			return ok(HelperClass.jsonNodeForError("CallOperator " + userID + "  validation failed..."));
		}
		
		session().put("id", "C" + id); //Starting C refers to CallOperator

		ObjectNode callOperatorResult = Json.newObject();
		callOperatorResult.put("error", 0);
		callOperatorResult.put("id", "" + id);
		callOperatorResult.put("name",callOperator.getName());
		callOperatorResult.put("phone", callOperator.getPhone());
		return ok(callOperatorResult);
	}
	
	public static Result logout(){
		String id = session().get("id");
		if(id == null) return ok(HelperClass.jsonNodeForError("User is not currently logged in"));
		session().clear();
		return ok(HelperClass.jsonNodeForSuccess("CallOperator + " + id + " logged out successfully"));
	}
}
