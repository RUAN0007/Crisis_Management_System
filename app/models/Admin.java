package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
@Entity
public class Admin extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Required
	private String name;
	@Required
	private String password;
	
	
	 public static Finder<Long, Admin> find = new Finder<Long, Admin>(
			 Long.class, Admin.class
	    ); 
	 
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public static Admin authenticate(Long id,String pwd){
		Admin admin = Ebean.find(Admin.class, id);
		if(admin == null) return null;
		if(!admin.getPassword().equals(pwd)) return null;
		return admin;
	}	
	
	
	
}
