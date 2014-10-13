package broadcaster;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
/**
 * This is class to uses Twillo gate to send SMS
 */
public class SMSSender {
	private   String ACCOUNT_SID = "AC48a7e73848fc1196696514a9dab0c65e";
	private   String AUTH_TOKEN = "2257118ecf6cb2e4da4c46d603a9552c";




	public SMSSender(String aCCOUNT_SID, String aUTH_TOKEN) {
		super();
		ACCOUNT_SID = aCCOUNT_SID;
		AUTH_TOKEN = aUTH_TOKEN;
	}

/**
 * This method can send SMS.
 * @param msg The message to be sent via sms
 * @param listPhonenum The destinations phone number
 * @return the boolean indicating whehter the operation is successful or not. 
 */


	public boolean SendSMS(String msg, List<String> ListPhonenum){
		try{
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

			for (int i=0; i<ListPhonenum.size(); i++){
				String PhoneNumber = ListPhonenum.get(i);
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("Body", msg));
				params.add(new BasicNameValuePair("To", "+"+ PhoneNumber));
				params.add(new BasicNameValuePair("From", "+14842407107"));
				MessageFactory messageFactory = client.getAccount().getMessageFactory();
				Message message = messageFactory.create(params);
				//System.out.println(message.getSid());
			}
			return true;
		}catch(Exception e){
			return false;
		}
		

	}
}
