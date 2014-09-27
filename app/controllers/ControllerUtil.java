package controllers;

import java.util.List;

import play.libs.Json;
import models.Event;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ControllerUtil {
	 static ObjectNode jsonNodeForSuccess(String message){
		  
        return jsonNodeForMsg(0, message);
	}
	
	 static ObjectNode jsonNodeForError(String message){
  
        return jsonNodeForMsg(1, message);
	}
	
	 static ObjectNode jsonNodeForMsg(int id, String message){
		 ObjectNode result = Json.newObject();
	        result.put("error", id);
	        result.put("message",message);
	        return result;
	}
	
	static ArrayNode getEventsArrayNode(List<Event> events) {
		ArrayNode eventsNode = new ArrayNode(JsonNodeFactory.instance);
	
		for(Event event:events){
			eventsNode.add(ControllerUtil.getEventJsonNode(event));
		}
		return eventsNode;
	}

	static ObjectNode getEventJsonNode(Event event){
		ObjectNode eventNode = Json.newObject();
		String eventType = event.getEventType().getEventType();
	
		eventNode.put("id", event.getId());
		eventNode.put("eventType", eventType);
		eventNode.put("priority", event.getPriority());
		eventNode.put("callingTime",event.getCallingTime().getTime());
		eventNode.put("postalCode", event.getPostalCode());
		eventNode.put("location",event.getLocation());
		eventNode.put("callerPhone",event.getCallerPhone());
		eventNode.put("description",event.getDescription());
		return eventNode;
	}

	

}
