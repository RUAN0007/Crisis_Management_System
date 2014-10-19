package controllers;

import java.util.List;

import play.libs.Json;
import models.Event;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
/**
 * This class provides some utility functions for controllers
 * @author ruanpingcheng
 *
 */
public class ControllerUtil {
	/**
	 * Construct a json indicating a successful request
	 * @param message the message displayed to the client
	 * @return a json node
	 */
	static ObjectNode jsonNodeForSuccess(String message){

		return jsonNodeForMsg(0, message);
	}
	/**
	 * Construct a json indicating a unsuccessful request
	 * @param message the message displayed to the client
	 * @return a json node
	 */
	static ObjectNode jsonNodeForError(String message){

		return jsonNodeForMsg(1, message);
	}
	/**
	 * Construct a json indicating a boolean request result
	 * @param message the message displayed to the client
	 * @return a json node
	 */
	static ObjectNode jsonNodeForMsg(int id, String message){
		ObjectNode result = Json.newObject();
		result.put("error", id);
		result.put("message",message);
		return result;
	}

	/**
	 * This method converts events to a json array node. 
	 * @param events a list of events to be converted to json
	 * @return a json array node
	 */
	static ArrayNode getEventsArrayNode(List<Event> events) {
		ArrayNode eventsNode = new ArrayNode(JsonNodeFactory.instance);

		for(Event event:events){
			eventsNode.add(ControllerUtil.getEventJsonNode(event));
		}
		return eventsNode;
	}
	/**
	 * This method converts one event to a json  node. 
	 * @param event an event to be converted
	 * @return a json  node
	 */
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
