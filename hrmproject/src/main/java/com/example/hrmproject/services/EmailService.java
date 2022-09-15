package com.example.hrmproject.services;

import com.example.hrmproject.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails emailDetails);

    String sendMailWithAttachment(EmailDetails emailDetails);
}
