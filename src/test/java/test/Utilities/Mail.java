package test.Utilities;

import java.io.File;
import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

import cucumber.Framework.WEBHelper;

public class Mail extends WEBHelper {

	public static void SendReport(String ReportName, String URLKey, String Subject) throws Exception {

		String BrowserType = GetPropertValue("Data/TestProperties.xml", "BrowserType");
		String filename = "target/" + ReportName;

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timeStamp = sdf.format(date);

		String subject = Subject + timeStamp;
		String to = GetPropertValue("Data/EmailProperties.xml", "recipients");// change accordingly
		String from = GetPropertValue("Data/EmailProperties.xml", "from");
		String host = GetPropertValue("Data/EmailProperties.xml", "SMTP_HOST_NAME");// or IP address
		String Port = GetPropertValue("Data/EmailProperties.xml", "SMTP_PORT");
		String password = GetPropertValue("Data/EmailProperties.xml", "password");

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", Port);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);// change accordingly
			}
		});

		// Compose the message
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			String[] recipientList = to.split(",");
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient.trim());
				counter++;
			}
			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setSubject(subject);

			String content = "Hi All," + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()

					+ "Attached is the Test Automation execution summary as of " + timeStamp + System.lineSeparator()
					+ System.lineSeparator()

					+ "TestMachine = " + Inet4Address.getLocalHost().getHostAddress() + System.lineSeparator()
					+ "TestEnv = " + URLKey + System.lineSeparator() + "Browser Name = " + BrowserType
					+ System.lineSeparator()

					+ System.lineSeparator() + System.lineSeparator() +

					"regards," + System.lineSeparator() + "Test Automation Team." + System.lineSeparator()

					+ System.lineSeparator() + System.lineSeparator() +

					"Note: Please Use Chrome browser for attached result view for better experiance";

			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText(content);

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();

			// Data source
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(ReportName);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart, "text/html");
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void SendFailedReport(String ReportName, String URLKey, String Subject) throws Exception {

		String BrowserType = GetPropertValue("Data/TestProperties.xml", "BrowserType");
		String URL = URLKey;
		String filename = "target/" + ReportName;

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timeStamp = sdf.format(date);

		String subject = Subject + timeStamp;
		String to = GetPropertValue("Data/EmailProperties.xml", "failedrecipients");// change accordingly
		String from = GetPropertValue("Data/EmailProperties.xml", "from");
		String host = GetPropertValue("Data/EmailProperties.xml", "SMTP_HOST_NAME");// or IP address
		String Port = GetPropertValue("Data/EmailProperties.xml", "SMTP_PORT");
		String password = GetPropertValue("Data/EmailProperties.xml", "password");

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", Port);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);// change accordingly
			}
		});

		// Compose the message
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			String[] recipientList = to.split(",");
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient.trim());
				counter++;
			}
			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setSubject(subject);

			String content = "Hi All," + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
					+ "Attached is the Test Automation execution summary as of " + timeStamp + System.lineSeparator()
					+ System.lineSeparator() + "Browser Name = " + BrowserType + System.lineSeparator() + "TestEnv = "
					+ URL + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() +

					"regards," + System.lineSeparator() + "Test Automation Team."

					+ System.lineSeparator() + System.lineSeparator() + System.lineSeparator() +

					"Note: Please Use Chrome browser for attached result view for better experiance";

			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText(content);

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();

			// Data source
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(ReportName);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart, "text/html");
			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void SendReports(String ReportName, String URLKey, String Subject) throws Exception {

		String BrowserType = GetPropertValue("Data/TestProperties.xml", "BrowserType");
		String URL = GetPropertValue("Data/TestProperties.xml", URLKey);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timeStamp = sdf.format(date);

		String subject = Subject + timeStamp;
		String to = GetPropertValue("Data/EmailProperties.xml", "recipients");// change accordingly
		String from = GetPropertValue("Data/EmailProperties.xml", "from");
		String host = GetPropertValue("Data/EmailProperties.xml", "SMTP_HOST_NAME");// or IP address
		String Port = GetPropertValue("Data/EmailProperties.xml", "SMTP_PORT");
		String password = GetPropertValue("Data/EmailProperties.xml", "password");

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", Port);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);// change accordingly
			}
		});

		// Compose the message
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			String[] recipientList = to.split(",");
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient.trim());
				counter++;
			}
			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setSubject(subject);

			String content = "Hi All," + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
					+ "Attached is the Test Automation execution summary as of " + timeStamp + System.lineSeparator()
					+ System.lineSeparator() + "Browser Name =" + BrowserType + System.lineSeparator() + "TestEnv ="
					+ URL + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() +

					"regards," + System.lineSeparator() + "Test Automation Team."

					+ System.lineSeparator() + System.lineSeparator() + System.lineSeparator() +

					"Note: Please Use Chrome browser for attached result view for better experiance";

			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText(content);

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();

			// DataSource source;
			File dir = new File("target/");
			String list[] = dir.list();

			for (int i = 0, n = list.length; i < n; i++) {
				File f = new File(list[i]);

				if (f.toString().contains("html")) {
					messageBodyPart = new MimeBodyPart();
					System.out.println(f);
					DataSource source = new FileDataSource("target/" + f);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(f.toString());
					multipart.addBodyPart(messageBodyPart);
				}
			}

			// Send the complete message parts
			message.setContent(multipart, "text/html");
			Transport.send(message);
			WEBHelper.log.info("message sent successfully....");
			System.out.println("message sent successfully....");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
