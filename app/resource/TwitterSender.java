package resource;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**An concrete class of SocialMediaSender
 * Can post message to a specific twitter account
 */
public class TwitterSender extends SocialMediaSender {
	
	private  TwitterFactory tf;

	public TwitterSender(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		// TODO Auto-generated constructor stub
		
        ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(accessTokenSecret);
		
		this.tf = new TwitterFactory(cb.build());
		
		
	}
	/**
	 * This method will post the message into facebook account
	 * @param message The content to be posted
	 * @return boolean whether the operation is successful or not
	 */
	@Override
	public boolean postMessage(String message) {
		// TODO Auto-generated method stub
		twitter4j.Twitter tw = tf.getInstance();
		try {
			Status st = tw.updateStatus(message);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}			
		System.out.println("Twitter updated");
		return true;
	}

	

}
