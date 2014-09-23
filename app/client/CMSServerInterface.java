package client;

public abstract class CMSServerInterface {

	private String serverAddress;
	private String id;
	private String password;

	
	
	public CMSServerInterface(String serverAddress, String id, String password) {
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

	protected String getUrl(String url) {
	    String ret = serverAddress + url;
	    return ret;
	}

}