package util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class HelperClass {
	
	
	public static ObjectNode jsonNodeForSuccess(String message){
		  
        return jsonNodeForMsg(0, message);
	}
	
	public static ObjectNode jsonNodeForError(String message){
  
        return jsonNodeForMsg(1, message);
	}
	
	private static ObjectNode jsonNodeForMsg(int id, String message){
		 ObjectNode result = Json.newObject();
	        result.put("error", id);
	        result.put("message",message);
	        return result;
	}
}
