package broadcaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

	private String account = "cmsalert2@gmail.com";
	private String pwd = "cmsalert";

	public EmailSender(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}

	public EmailSender() {
	}

	public boolean SendMail(List<String> destinations, String subject,
			String text, String file) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(account, pwd);
					}
				});
		for (int i = 0; i < destinations.size(); i++) {

			String ToEmail = destinations.get(i);
//			System.out.println(destinations.size());
//			System.out.println(destinations.get(destinations.size()-1));

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("cmsalert2@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(ToEmail));
				message.setSubject(subject);
				message.setText(text); // message body
				Multipart multipart = new MimeMultipart();
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				String filename = file; // file must be in the workspace
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);

				// Send the complete message parts
				message.setContent(multipart);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				e.printStackTrace();
				return false;
			} catch (RuntimeException e) {
				e.printStackTrace();
				return false;
			}
		}

		// Return whether the transission is successful
		return true;
	}
	
//	public static void main(String[] args) {
//		
//		 List<String> email = new ArrayList<String>();
//		  email.add("benjie1812@gmail.com");
//		  email.add("yingfu01@gmail.com");
//		  email.add("yingfu03@hotmail.com");
//		  email.add("gong0029@gmail.com");
//		  
//		String subject = "testing email";
//		String text = "hello";
//		
//				
//		EmailSender email1 = new EmailSender();
//		email1.SendMail(email,subject,text, "SRS.pdf");
//
//        }

	// public void SendMail(String ToEmail, String FileToSend){
	// Properties props = new Properties();
	// props.put("mail.smtp.host", "smtp.gmail.com");
	// props.put("mail.smtp.socketFactory.port", "465");
	// props.put("mail.smtp.socketFactory.class",
	// "javax.net.ssl.SSLSocketFactory");
	// props.put("mail.smtp.auth", "true");
	// props.put("mail.smtp.port", "465");
	//
	// Session session = Session.getDefaultInstance(props,
	// new javax.mail.Authenticator() {
	// protected PasswordAuthentication getPasswordAuthentication() {
	// return new PasswordAuthentication(account,pwd);
	//
	// }
	// });
	//
	// try {
	//
	// Message message = new MimeMessage(session);
	// message.setFrom(new InternetAddress("cmsalert2@gmail.com"));
	// message.setRecipients(Message.RecipientType.TO,
	// InternetAddress.parse(ToEmail));
	// message.setSubject("Testing Subject");
	// message.setText("Dear Mail Crawler," +
	// "\n\n No spam to my email, please!");
	// Multipart multipart = new MimeMultipart();
	// MimeBodyPart messageBodyPart = new MimeBodyPart();
	// String filename = FileToSend; //file must be in the workspace
	// DataSource source = new FileDataSource(filename);
	// messageBodyPart.setDataHandler(new DataHandler(source));
	// messageBodyPart.setFileName(filename);
	// multipart.addBodyPart(messageBodyPart);
	//
	// // Send the complete message parts
	// message.setContent(multipart );
	//
	// Transport.send(message);
	//
	// System.out.println("Done");
	//
	// } catch (MessagingException e) {
	// throw new RuntimeException(e);
	// }
	// }
}
