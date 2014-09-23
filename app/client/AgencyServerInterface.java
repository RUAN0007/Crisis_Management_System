package client;

public class AgencyServerInterface extends CMSServerInterface {

	public AgencyServerInterface(String serverAddress, String id,
			String password) {
		super(serverAddress, id, password);
		// TODO Auto-generated constructor stub
	}
	
	//Return null for unsuccessful login or an exception has been thrown
    //Return Agency instance for successful login
	public Agency login(){
		String loginURL = getUrl("/agency/login");
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
	
	

}
