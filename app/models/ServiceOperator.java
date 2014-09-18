package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class ServiceOperator extends Model {
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
		
		@OneToMany(mappedBy = "serviceOperator",cascade=CascadeType.PERSIST)
		private List<Event> events;
		
		public static Finder<Long, ServiceOperator> find 
			= new Finder<Long, ServiceOperator>(Long.class, ServiceOperator.class);
		
		public Long getId() {
			return id;
		}
		public void setId(Long iD) {
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
