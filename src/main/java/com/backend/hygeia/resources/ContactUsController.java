package com.backend.hygeia.resources;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUsController {
	static {
		System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
		
	}
	private static final Logger logger = LogManager.getLogger("ContactUsController");

	@RequestMapping("/MailSend")
	public String getLogin(HttpServletRequest request, HttpServletResponse response){
		
        final String username = "saadetelif@outlook.com.tr";
        final String password = "***********************";
		String Email = request.getParameter("email");
		
		String PhoneNumber = request.getParameter("phonenumber");
		String Mesaj = request.getParameter("message");
		String Konu = request.getParameter("subject");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("saadetelif@outlook.com.tr"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("saadetelif@outlook.com.tr"));
			message.setSubject("Konu");
			message.setText("Konu:" + Konu + "\n\nMail Adresi:" + Email + "\n\n Telefon Numarası:" + PhoneNumber
					+ "\n\n Mesaj:" + Mesaj);
			String returnValue = "<!DOCTYPE html><html><head><title>Page Title</title></head><body><div style=\"background-image: url('https://p1.pxfuel.com/preview/128/2/373/twilight-aurora-orange-abstract.jpg');\r\n"
					+ "background-size: cover; height:700px; padding-top: 80px; text-align: center;\"><img src=\"https://domf5oio6qrcr.cloudfront.net/medialibrary/11499/3b360279-8b43-40f3-9b11-604749128187.jpg\" style=\"height:150px; border-radius: 50%; border: 10px solid #FEDE00;\"><p style=\"font-size:25px; color:white; margin:10px;\">Mailiniz aşağıdaki bilgiler ile gönderilmiştir;</p>"
					+ "<p style=\"font-size:20px; color:white; margin:10px;\">" + "<br>\n\nKonu;" + Konu
					+ "<br>\n\nMail Adresi:" + Email + "<br>\n\n Telefon Numarası:" + PhoneNumber + "<br>\n\n Mesaj:\n"
					+ Mesaj + "<br>\n\n<a href=\"http://localhost:8080\"> anasayfaya dönmek için tıklayınız</a>"
					+ "</body>\r\n" + "</html>";

			Transport.send(message);

			System.out.println("Mail gönderildi.");
			return returnValue;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}