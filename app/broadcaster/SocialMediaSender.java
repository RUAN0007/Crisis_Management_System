package broadcaster;

import twitter4j.TwitterException;

public abstract class SocialMediaSender {
	
	
	//return whether the post is successful or not
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;
	
	
	public SocialMediaSender(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
	}


	public abstract boolean postMessage(String message);

}