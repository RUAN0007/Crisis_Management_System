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
//	            TODO
	        	//Start a timer to send Email for every 30 min
	        }

	    }
}
