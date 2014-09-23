package client;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class ServiceOperatorServerInterface extends CMSServerInterface {

	public ServiceOperatorServerInterface(String serverAddress, String id,
			String password) {
		super(serverAddress, id, password);
	}

	//Return null for unsuccessful login or an exception has been thrown
	//Return ServiceOperator instance for successful login
	public CallOperator login(){
		String loginURL = getUrl("/serviceoperator/login");
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

	//return a list of eventType's id and eventType's name key pair Map
	//return null for unsuccessful request or an exception has been thrown
	public Map<String,String> getEventTypes(){
	
		String url = getUrl("/serviceoperator/getEventTypes");
		//GET request with no parameters;

		//If the request is successful,
		//The server will return a json object with a list of agencies
		//, each with their id and name.
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
	
	//return true if the update for event's priority and agencies is successful
	//return false if not or an exception has been thrown
	public boolean updateEvent(String eventID,int priority, List<String> relevantAgenciesIDs){
		//POST request with a json object as the only argument;
		String url = getUrl("/serviceoperator/updateEvent");

		
		//IMPORTANT NOTES: 
		//This method will send a POST request with JSON object as the only argument.
		//The Json object will encapsulate all the required parameters.
		//You need to check the online documents to learn 
		//how to construct a json node and how to send it as the only argument in POST request
		
		//The uploaded json object should be like
		//{
		// "eventID": ***,
		// "priority": **,
		//  "relevantAgenciesIDs":
		//		[agencyid1,
		//       agencyid2,
		//		 agencyid3,
		//			...
		//		]
		//}
		
		
		//The server will return a json object with two nodes.
		
				//{"error": 0/1 (error = 0 if successful, 1 if not)
				//"message": *****		(The message explaining the reason)
		//}
		return false;
	}
	
	//return a list of UNhandled events
	//return null for unsuccessful request or an exception has been thrown
	public List<Event> getUnhandledEvents(){
		//GET request with no arguments
		String url = getUrl("/serviceoperator/unhandledEvents");
		
		//If the request is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaning the reason)
		//}
		//
		
		

		//If request is successful
		//Server returns a json object with two nodes:
		//{"error":0
		// "events":
		//	[
		//     {"id":*,
		//       "eventType":***,	(Here eventType must be NULL)
		//		 "priority":***,   (Priority node may  exist if call operator has specified)
		//		 "callingTime":***, (Unix Timestamp,check online if you dont know)
		//		 "postalCode":***,
		//       "location":***,
		//		 "callerPhone":***,
		//		"description":***
		//	   },
		//
		//	     {"id":*,
		//       "eventType":***,	(Here eventType must be NULL)
		//		 "priority":***,   (Priority node may not exist if call operator has not specified)
		//		 "callingTime":***, (Unix Timestamp,check online if you dont know)
		//		 "postalCode":***,
		//       "location":***,
		//		 "callerPhone":***,
		//		"description":***
		//	   },
		//		...
		// 	]
		//}		
		return null;
	}
	
	//return a list of events of first priority
	//return null for unsuccessful request or an exception has been thrown
	public List<Event> getPriorityOneEvents(){
		//GET request with no arguments
		String url = getUrl("/serviceoperator/priorityOneEvents");
		
		//The server return a json object similar to that in getUnhandledEvents method
		return null;
	}
	
	//return true if the request is successful
	//return false if not or an exception has been thrown
	public boolean broadcastSMSForEvent(String eventID){
		//GET request with one argument: eventID
		String url = getUrl("/serviceoperator/broadcastSMS");
		//The server will return a json object with two nodes.
		
		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//	"message": *****		(The message explaining the reason)
		//}
		return false;
	}
	
	//return true if the request is successful
	//return false if not or an exception has been thrown
	public boolean sendReportForEvent(String eventID){
		//GET request with one argument: eventID
		String url = getUrl("/serviceoperator/sendReport");
		//The server will return a json object with two nodes.
		
		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//	"message": *****		(The message explaining the reason)
		//}
		return false;
	}
}
