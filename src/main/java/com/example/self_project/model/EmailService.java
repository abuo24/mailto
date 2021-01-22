package com.example.self_project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public boolean create(EmailPayload email) {

        if (email.getTitle() != null || email.getTitle() != ""
                || email.getEmail() != null || email.getTitle() != ""
                || email.getEmail().contains("@") || email.getMessage() != null || email.getMessage() != ""
                || email.getName() != null) {
            Email email1 = new Email();
            email1.setEmail(email.getEmail());
            email1.setMessage(email.getMessage());
            email1.setTitle(email.getTitle());
            email1.setName(email.getName());
            Email email2 = emailRepository.save(email1);
            if (email2 != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
