package com.gc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * The mail manager service
 */
@Service("mailService")
public class MailManager {

	@Autowired
    private MailSender mailSender;
     
    @Autowired
    private SimpleMailMessage preConfiguredMessage;

    /**
     * This method will send compose and send the message 
     * @param to The recipient
     * @param subject The subject
     * @param body The body
     */
    public void sendMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
 
    /**
     * This method will send a pre-configured message
     * @param message The message
     */
    public void sendPreConfiguredMail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
