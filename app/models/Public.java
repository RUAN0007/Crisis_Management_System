package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Public extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String handPhone;
	private String location;
	@Required
	private String name;
	
	public String getHandPhone() {
		return handPhone;
	}
	public void setHandPhone(String handPhone) {
		this.handPhone = handPhone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
