package client;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import client.CMSServerInterface.CMSServerException;

public class ServiceOperatorServerInterface extends CMSServerInterface {

	public ServiceOperatorServerInterface(String serverAddress, String id,
			String password) {
		super(serverAddress, id, password);
	}

	//Return ServiceOperator instance for successful login
	public ServiceOperator login() throws CMSServerException{
		String loginURL = getUrl("/serviceoperator/login");
		//POST request with parameters id and password;

		//If login is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaining the reason)
		//}

		//If login is successful
		//Server returns a json object with four nodes:
		//{"error":0
		//	"id": *** (callOperator userID)
		//  "name": *** (callOperator Name)
		//   "phone": *** (callOperator's phone)
		//}

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)
		return null;
	}

	//return a list of agency's id and agency's name key pair Map
	public Map<String,String> getAgencies() throws CMSServerException{

		String url = getUrl("/getAgencies");
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

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)

		return null;
	}

	//return true if the update for event's priority and agencies is successful
	public boolean updateEvent(String eventID,int priority, List<String> relevantAgenciesIDs)
			throws CMSServerException{
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
		//  "serviceOperatorID": ***
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

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)

		return false;
	}

	//return a list of Unhandled events
	public List<Event> getUnhandledEvents() throws CMSServerException{
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


		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)

		return null;
	}

	//return a list of events of first priority
	public List<Event> getPriorityOneEvents() throws CMSServerException{
		//GET request with no arguments
		String url = getUrl("/serviceoperator/priorityOneEvents");

		//The server return a json object similar to that in getUnhandledEvents method

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)
		return null;
	}

	//return true if the request is successful
	public boolean broadcastSMSForEvent(String eventID) throws CMSServerException{ 
		//GET request with one argument: eventID
		String url = getUrl("/serviceoperator/broadcastSMS");
		//The server will return a json object with two nodes.

		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//	"message": *****		(The message explaining the reason)
		//}

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)
		return false;
	}

	//return true if the request is successful
	public boolean sendReportForEvent(String eventID) throws CMSServerException{
		//GET request with one argument: eventID
		String url = getUrl("/serviceoperator/sendReport");
		//The server will return a json object with two nodes.

		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//	"message": *****		(The message explaining the reason)
		//}


		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)
		return false;
	}

	//return a list of EventStatus if the request is successful
	public List<EventStatus> getEventsStatus() throws CMSServerException{
		//Get request without argument

		//If the request is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaning the reason)
		//}
		//

		//If request is successful
		//Server returns a json object with two nodes:
		//{"error":0
		// "statues":
		//	[
		//     {"eventID":*,
		//      "agencyName": ***
		//       "status":***,	(can be SENT, READ,SOLVED)
		//		 "dispatchTime":***,  (Unix Timestamp) 
		//		 "readTime":***, (Unix Timestamp, this entry may be empty if the status is SENT)
		//		 "solveTime":***,(Unix Timestamp, this entry may be empty if the status is READ)
		//	   },
		//
		//	     {"eventID":*,
		//    	  "agencyName": ***
		//       "status":***,	(can be SENT, READ,SOLVED)
		//		 "dispatchTime":***,  (Unix Timestamp) 
		//		 "readTime":***, (Unix Timestamp, this entry may be empty if the status is SENT)
		//		 "solveTime":***,(Unix Timestamp, this entry may be empty if the status is READ)
		//	   },
		//		...
		// 	]

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 1,message)

		return null;
	}
}
