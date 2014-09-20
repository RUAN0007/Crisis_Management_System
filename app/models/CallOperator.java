package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class CallOperator extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	@Required
	private String name;
	@Required
	private String password;
	@Required
	private String phone;
	
	@OneToMany(mappedBy = "callOperator",cascade = CascadeType.PERSIST)
	private List<Event> events;
	
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
	
	public List<Event> getEvents(){
		return this.events;
	}
	
	//Return null if can not find the record
	//Return the callOperator object is found. 
	public static CallOperator authenticate(Long id,String pwd){
		CallOperator callOperator = Ebean.find(CallOperator.class, id);
		if(callOperator == null) return null;
		if(!callOperator.getPassword().equals(pwd)) return null;
		return callOperator;
	}
	
}
