package client;

public class ServiceOperator {

	private String id;
	private String name;
	private String phone;
	
	private ServiceOperator(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	

}
