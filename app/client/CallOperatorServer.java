package client;

public class CallOperatorServer {
	private String serverAddress;
	private String id;
	private String password;
	
	public CallOperatorServer(String serverAddress, String id, String password) {
		super();
		this.serverAddress = serverAddress;
		this.id = id;
		this.password = password;
	}
	

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    private String getUrl(String url) {
        String ret = serverAddress + url;
        return ret;
    }
    
	public boolean login(){
		String loginURL = getUrl("/calloperator/login");
		//Post request with parameters id and password;
		//Server returns a json object with two nodes
		//{error: 0/1	 (0 means login successfully,1 means not successful)
		//message: *****		(The message about the login)
		//}
		//
		return false;
	}
	
	public boolean report(){
		
	}
}
