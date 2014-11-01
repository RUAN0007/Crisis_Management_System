package resource;

import twitter4j.TwitterException;
/**
 * An abstract class to handling the post to social media
 */
public abstract class SocialMediaSender {
	
	
	//return whether the post is successful or not
	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;
	
	/**
	 * Contructor for socialMediaSender
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 */
	public SocialMediaSender(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.accessToken = accessToken;
		this.accessTokenSecret = accessTokenSecret;
	}

/**
 * An abstract class to post message to social media.
 * Its abstract shall overrides its method to make it work
 * @param message The content to be posted
 * @return boolean whether the operation is successful or not
 */
	public abstract boolean postMessage(String message);

}