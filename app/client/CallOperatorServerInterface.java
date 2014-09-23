package client;

import java.util.List;
import java.util.Map;

import client.CMSServerInterface.CMSServerException;

public class CallOperatorServerInterface extends CMSServerInterface {
	public CallOperatorServerInterface(String serverAddress, String id, String password) {
		super(serverAddress,id,password);
	}
	

    //Return CallOperator instance for successful login
	public CallOperator login() throws CMSServerException{
		String loginURL = getUrl("/calloperator/login");
		//POST request with parameters id and password;
		
		//If login is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaining the reason)
		//}
		//
		
		//If login is successful
		//Server returns a json object with four nodes:
		//{"error":0
		//	"id": *** (callOperator userID)
		//  "name": *** (callOperator Name)
		//   "phone": *** (callOperator's phone)
		//}
		
		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 2,message)
		return null;
	}
	
	//return whether the event report to server is successful or not
	public boolean report(String eventTypeID,
						  String priority,
						  String callOperatorID,
						  String postalCode,
						  String location,
						  String callerPhone,
						  String description) throws CMSServerException{
		
		String url = getUrl("/calloperator/report");
		//POST request with above parameters in the method arguments;
		//The server will return a json object with two nodes.
		
		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//"message": *****		(The message explaining the reason)
		//}
		
		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 2,message)
		return false;
		
	}
	
	//return a list of eventType's id and eventType's name key pair Map
	//return null for unsuccessful request or an exception has been thrown
	public Map<String,String> getEventTypes() throws CMSServerException{
		String url = getUrl("/getEventTypes");
		//GET request with no parameters;
		
		//If the request is successful,
		//The server will return a json object with a list of eventTypes
		//, each with their id and name
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
		
		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 2,message)
		return null;
	}
	
	
}
