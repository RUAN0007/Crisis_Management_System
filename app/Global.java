import com.avaje.ebean.Ebean;

import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

import models.Public;

public class Global extends GlobalSettings {
	@Override
	 public void onStart(Application app) {
		//System.out.println("I hate YAML!!");
	}

	    static class InitialData {

	        public static void insert(Application app) {
//	            if(Ebean.find(Public.class).findRowCount() == 0) {
//	                Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("CMS_init_data.yml");
//
//	                Ebean.save(all.get("public"));
//	                Ebean.save(all.get("agencies"));
//	                Ebean.save(all.get("callOperators"));
//	                Ebean.save(all.get("serviceOperators"));
//	                Ebean.save(all.get("events"));
//	                Ebean.save(all.get("dispatches"));
//	                Ebean.save(all.get("Notifications"));
//	                System.out.println("Database Finished!");
//
//	            }
	        }

	    }
}
