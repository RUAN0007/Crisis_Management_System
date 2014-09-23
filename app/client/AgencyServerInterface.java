package client;

import java.util.List;

import client.CMSServerInterface.CMSServerException;

public class AgencyServerInterface extends CMSServerInterface {

	public AgencyServerInterface(String serverAddress, String id,
			String password) {
		super(serverAddress, id, password);
		// TODO Auto-generated constructor stub
	}

	//Return Agency instance for successful login
	public Agency login() throws CMSServerException{
		String loginURL = getUrl("/agency/login");
		//POST request with parameters id and password;

		//If login is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaning the reason)
		//}

		//If login is successful
		//Server returns a json object with four nodes:
		//{"error":0
		//	"id": *** (callOperator userID)
		//  "name": *** (callOperator Name)
		//   "phone": *** (callOperator's phone)
		//}

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 3,message)
		return null;
	}

	//return a list of events assigned to this agency whose statuses are Sent 
	public List<Event> getSentEvents() throws CMSServerException{
		//POST request with one argument: "agencyID"
		String url = getUrl("/agency/sentEvents");

		//If the request is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaining the reason)
		//}


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
		//Then throw CMSServerException with (id = 3,message)
		return null;
	}

	//return a list of events assigned to this agency whose statuses are READ 
	public List<Event> getReadEvents() throws CMSServerException{
		//POST request with one argument: "agencyID"
		String url = getUrl("/agency/readEvents");

		//If encounter any connection exception
		throw new CMSServerException(1,"Message here");

		//If the request is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaining the reason)
		//}

		//If request is successful
		//Server returns a json object with two nodes:
		//{"error":0
		// "events":
		//	[
		//     {"id":*,
		//       "eventType":***,	
		//		 "priority":***,   
		//		 "callingTime":***,
		//		 "postalCode":***,
		//       "location":***,
		//		 "callerPhone":***,
		//		"description":***
		//	   },
		//
		//	     {"id":*,
		//       "eventType":***,	
		//		 "priority":***,   
		//		 "callingTime":***, 
		//		 "postalCode":***,
		//       "location":***,
		//		 "callerPhone":***,
		//		"description":***
		//	   },
		//		...
		// 	]
		//}	

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 3,message)
	}

	//return a list of events assigned to this agency whose statuses are SOVLED 
	public List<Event> getSolvedEvents() throws CMSServerException{
		//POST request with one argument: "agencyID"
		String url = getUrl("/agency/solvedEvents");

		//If encounter any connection exception
		throw new CMSServerException(1,"Message here");

		//If the request is unsuccessful,
		//Server returns a json object with two nodes
		//{"error": 1	 
		//"message": *****		(The message explaining the reason)
		//}

		//If request is successful
		//Server returns a json object with two nodes:
		//{"error":0
		// "events":
		//	[
		//     {"id":*,
		//       "eventType":***,	
		//		 "priority":***,   
		//		 "callingTime":***, 
		//		 "postalCode":***,
		//       "location":***,
		//		 "callerPhone":***,
		//		"description":***
		//	   },
		//
		//	     {"id":*,
		//       "eventType":***,	
		//		 "priority":***,   
		//		 "callingTime":***, 
		//		 "postalCode":***,
		//       "location":***,
		//		 "callerPhone":***,
		//		"description":***
		//	   },
		//		...
		// 	]
		//}	

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 3,message)
	}

	public boolean readEvent(String eventID) throws CMSServerException{
		//POST request with two arguments: "eventID" and "agencyID"
		String url = getUrl("/agency/readEvent");

		//If encounter any connection exception
		throw new CMSServerException(1,"Message here");

		//The server will return a json object with two nodes.

		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//	"message": *****		(The message explaining the reason)
		//}

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 3,message)
	}

	public boolean solveEvent(String eventID) throws CMSServerException{


		//POST request with two arguments: "eventID" and "agencyID"
		String url = getUrl("/agency/solveEvent");

		//If encounter any connection exception
		throw new CMSServerException(1,"Message here");
		//The server will return a json object with two nodes.

		//{"error": 0/1 (error = 0 if successful, 1 if not)
		//	"message": *****		(The message explaining the reason)
		//}

		//if error = 1 or any exception thrown during the http connection
		//Then throw CMSServerException with (id = 3,message)
	}


}
