package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Agency extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Required
	private String password;
	
	@Required
	private String name;
	
	@Required
	private String phone;
	
	@Required
	private String email;
	
	@OneToMany(mappedBy="agency",cascade = CascadeType.REMOVE)
	private List<Dispatch> dispatches;
	
	@ManyToMany(mappedBy = "responsibleAgencies")
	private List<EventType> responsibleEventTypes;
	
	
	
   public List<EventType> getResponsibleEventTypes() {
		return responsibleEventTypes;
	}

public static Finder<Long, Agency> find = new Finder<Long, Agency>(
		   Long.class, Agency.class
    ); 
	
	public Long getId() {
		return id;
	}
	public void setID(Long iD) {
		id = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Dispatch> getDispatches(){
		return this.dispatches;
	}
	
	//Return null if can not find the record
	//Return the callOperator object is found. 
	public static Agency authenticate(Long id,String pwd){
		Agency agency = Ebean.find(Agency.class, id);
		if(agency == null) return null;
		if(!agency.getPassword().equals(pwd)) return null;
		return agency;
	}
	
	
}
