import com.avaje.ebean.Ebean;
import org.w3c.dom.Document;

import play.Application;
import play.GlobalSettings;
import play.libs.XML;
import play.libs.Yaml;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.*;

import models.Public;

public class Global extends GlobalSettings {
	@Override
	 public void onStart(Application app) {
		//System.out.println("I hate YAML!!");

//		File file = new File("broadcaster.xml");
//		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		  DocumentBuilder db = dbf.newDocumentBuilder();
//		  Document doc = db.parse(file);
//		  
	}
	
	

	    static class InitialData {

	        public static void insert(Application app) {
//	            TODO
	        	//Start a timer to send Email for every 30 min
	        }

	    }
}
