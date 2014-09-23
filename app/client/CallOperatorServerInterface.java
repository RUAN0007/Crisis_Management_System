package client;

import java.util.Map;

public class CallOperatorServerInterface extends CMSServerInterface {
	public CallOperatorServerInterface(String serverAddress, String id, String password) {
		super(serverAddress,id,password);
	}
	

	//Return null for unsuccessful login
    //Return CallOperator instance for successful login
	public CallOperator login(){
		String loginURL = getUrl("/calloperator/login");
		//POST request with parameters id and password;
		
		//If login is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaning the reason)
		//}
		//
		
		//If login is successful
		//Server returns a json object with four nodes:
		//{"error":0
		//	"id": *** (callOperator userID)
		//  "name": *** (callOperator Name)
		//   "phone": *** (callOperator's phone)
		//}
		return null;
	}
	
	//return whether the event report to server is successful or not
	public boolean report(String eventTypeID,
						  String callOperatorID,
						  String priority,
						  String postalCode,
						  String location,
						  String callerPhone,
						  String description){
		
		String loginURL = getUrl("/calloperator/report");
		//POST request with above parameters in the method arguments;
		
		//The server will return a json object with two nodes.
		
		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//"message": *****		(The message explaning the reason)
		//}
		return false;
		
	}
	
	//return a list of eventType id and eventType name Map
	//return null for unsuccessful request
	public Map<String,String> getEventTypes(){
		String loginURL = getUrl("/calloperator/getEventTypes");
		//GET request with no parameters;
		
		//If the request is successful,
		//The server will return a json object with a list of eventTypes
		//, each with their id, name and description
		//{
		//	"error":0
		//	"eventTypes":
		//		[
		//			{"id":**,"name":**},
		//			{"id":**,"name":**},
		//			{"id":**,"name":**},
		// ...
		//		]
		//}
		
		//If not successful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaining the reason)
		//}
		//
		
		
		return null;
	}
}
