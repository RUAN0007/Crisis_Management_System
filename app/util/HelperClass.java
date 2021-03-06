package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.libs.Time;

public class HelperClass {
	
	
	public static Long getRandomPersonnelID(){
		Random rand =new Random(System.currentTimeMillis());
		long value = rand.nextInt(1_000);

		return value;
	}
	
	
	public static Long getRandomLong(){
		Random rand =new Random(System.currentTimeMillis());
		long value = rand.nextInt(1_000_000);

		return value;
	}
	
	public static Timestamp getCurrentTimestamp(){
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static String getFormattedCurrentTime(){
		Date currentDate = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss-ddMMy/");
		return formatter.format(currentDate);
	}
}
