package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
@Entity
public class Account extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String type;
	@Required
	private String accountName;
	@Required
	private String password;
	
	
	 public static Finder<String, Account> find = new Finder<String, Account>(
			 String.class, Account.class
	    ); 
	 
	 public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String account) {
		this.accountName = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
