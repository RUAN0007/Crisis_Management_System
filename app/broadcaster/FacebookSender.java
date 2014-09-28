package broadcaster;

import com.restfb.*;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import static java.lang.System.out;

public class FacebookSender extends SocialMediaSender {
	
	private  FacebookClient fbClient;
	private  User me;
	
	public FacebookSender(String accessToken, String accessTokenSecret) {
		super(null,null,accessToken,accessTokenSecret);	
		//Login
		this.fbClient = new DefaultFacebookClient(accessToken);
		this.me = fbClient.fetchObject(accessTokenSecret, com.restfb.types.User.class);
		
	}
	
	
	
	
	@Override
	public boolean postMessage(String message){
		FacebookType publishMessageResponse =
				  fbClient.publish("me/feed", FacebookType.class,
				    Parameter.with("message", message));

				out.println("Published message ID: " + publishMessageResponse.getId());

		return true;
	}
	

}
