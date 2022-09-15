package com.example.hrmproject.services;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.hrmproject.entity.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    // To send a simple mail
    @Override
    public String sendMailWithAttachment(EmailDetails emailDetails) {
        // TODO Auto-generated method stub
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Error while sending mail!!!";
        }
    }

    // To send an email with attachment
    @Override
    public String sendSimpleMail(EmailDetails emailDetails) {
        // TODO Auto-generated method stub
        try {
            // creating a simple mail message
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            // setting up necessary details
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setText(emailDetails.getMsgBody());
            simpleMailMessage.setSubject(emailDetails.getSubject());

            // sending the mail
            javaMailSender.send(simpleMailMessage);
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return "Error while Sending Mail";
        }
    }
    
}
