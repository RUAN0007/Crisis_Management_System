package controllers;

import models.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;



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
	

}
