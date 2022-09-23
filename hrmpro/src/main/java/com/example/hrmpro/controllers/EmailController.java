package com.example.hrmpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmpro.model.EmailDetails;
import com.example.hrmpro.services.EmailService;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody EmailDetails details)
    {
        ResponseEntity<String> status = emailService.sendSimpleMail(details);
 
        return status;
    }

    @PostMapping("/sendMailWithAttachment")
    public ResponseEntity<String> sendMailWithAttachment(@RequestBody EmailDetails details)
    {
        ResponseEntity<String> status = emailService.sendMailWithAttachment(details);
 
        return status;
    }
}
