package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model.Finder;
@Entity

public class CallOperator {
	@Id
	private Long id;
	@Required
	private String name;
	@Required
	private String password;
	@Required
	private String phone;
	
	public static Finder<Long, CallOperator> find 
		= new Finder<Long, CallOperator>(Long.class, CallOperator.class);
	
	public Long getId() {
		return id;
	}
	public void setID(Long iD) {
		id = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
