package MyApp.Service;

import MyApp.Model.Login;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("revlearnteam@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.print("Mail Send...");
    }

    protected void sendVerificationEmail(Login login) throws MessagingException, UnsupportedEncodingException, jakarta.mail.MessagingException {
        String toAddress = login.getEmail();
        String fromAddress = "revlearnteam@gmail.com";
        String senderName = "RevLearn";
        String subject = "Welcome to RevLearn!";
        String content = "Welcome to RevLearn!<br>"
                + "Please login and update your Profile.<br>"
                + "Thank you,<br>"
                + "RevLearn Team.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);


       helper.setText(content, true);
       mailSender.send(message);
        System.out.print("Verification Send...");

    }

    protected  void sendPasswordReset(Login login, String randomCode) throws MessagingException, UnsupportedEncodingException, jakarta.mail.MessagingException {
        String toAddress = login.getEmail();
        String fromAddress = "revlearnteam@gmail.com";
        String senderName = "RevLearn";
        String subject = "RevLearn Password Reset";
        String content = "Dear [[name]], <br>"
                + "Your temporary password is: <br>"
                + "[[password]]  <br>"
                + "Please login and change your password. <br>"
                + "Thank you,<br>"
                + "RevLearn Team.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", login.getStudent().getFirstname() + " " + login.getStudent().getLastname());
        content = content.replace("[[password]]", randomCode);

        helper.setText(content, true);
        mailSender.send(message);
        System.out.print("Verification Send...");
    }
}
