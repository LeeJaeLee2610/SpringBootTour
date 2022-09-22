package com.example.hrmpro.services;

import org.springframework.http.ResponseEntity;

import com.example.hrmpro.model.EmailDetails;

public interface EmailService {
    ResponseEntity<String> sendSimpleMail(EmailDetails emailDetails);
    ResponseEntity<String> sendMailWithAttachment(EmailDetails emailDetails);
}
