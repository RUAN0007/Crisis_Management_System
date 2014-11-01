package resource;

import com.restfb.*;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import static java.lang.System.out;
/**
 * An concrete class of SocialMediaSender
 * Can post message to a specific facebook account
 * @author Lu You
 */
public class FacebookSender extends SocialMediaSender {
	
	private  FacebookClient fbClient;
	private  User me;
	
	public FacebookSender(String accessToken, String accessTokenSecret) {
		super(null,null,accessToken,accessTokenSecret);	
		//Login
		this.fbClient = new DefaultFacebookClient(accessToken);
		this.me = fbClient.fetchObject(accessTokenSecret, com.restfb.types.User.class);
		
	}
	
	
	
	/**
	 * This method will post the message into facebook account
	 * @param message The content to be posted
	 * @return boolean whether the operation is successful or not
	 */
	@Override
	public boolean postMessage(String message){
		FacebookType publishMessageResponse =
				  fbClient.publish("me/feed", FacebookType.class,
				    Parameter.with("message", message));

				out.println("Published message ID: " + publishMessageResponse.getId());

		return true;
	}
	

}
