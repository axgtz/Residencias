package residencias;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarMail {
    public static void EnviarMail(final String subject, final String mensaje, final String mail)
    {
		  // El correo gmail de envío
		  final String username = "residenciasteamss@gmail.com";
		  final String password = "amss12345";
		  
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("residenciasteamss@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject(subject);
			message.setText(mensaje);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}
