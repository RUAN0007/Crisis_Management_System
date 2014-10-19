import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.sql.Timestamp;

import models.CallOperator;
import models.Event;
import models.EventType;

import org.junit.Test;

import util.HelperClass;
import broadcaster.*;

public class SocialMediaSenderTest {

//	@Test
//	public void test1() {
//		ResourceGenerator rg = ResourceGenerator.getDefaultResourceGenerator();
//		TwitterSender twitter = rg.getNewTwitterSender();
//
//		Event newEvent = new Event();
//		newEvent.setCallerPhone("123456");
//		newEvent.setCallingTime(new Timestamp(System.currentTimeMillis()));
//
//		CallOperator co = new CallOperator();
//		co.setID((long) 1);
//		co.setName("23");
//		co.setPassword("123");
//		co.setPhone("1234");
//		newEvent.setCallOperator(co);
//		newEvent.setDescription("bla bla bla");
//
//		EventType type = new EventType();
//		type.setEventType("hi");
//		type.setDescription("No desc");
//		newEvent.setEventType(type);
//		
//		newEvent.setLocation("Central");
//		newEvent.setPostalCode("666666");;
//		newEvent.setPriority(3);
//		newEvent.setId(HelperClass.getRandomLong());
//
//		EventFormatter formatter = new EventFormatter();
//		assert(twitter.postMessage(formatter.formatSocialMedia(newEvent)));
//	}



}
