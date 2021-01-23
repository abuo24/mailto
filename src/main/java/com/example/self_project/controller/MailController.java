package com.example.self_project.controller;

import com.example.self_project.model.EmailPayload;
import com.example.self_project.model.EmailService;
import org.apache.commons.mail.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/email")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/add")
    public ResponseEntity postMail(@RequestBody EmailPayload mail) {
        HtmlEmail email1 = new HtmlEmail();
        email1.setHostName("smtp.googlemail.com");
        email1.setSmtpPort(587);
        email1.setAuthenticator(new DefaultAuthenticator("videolaribratli@gmail.com", "Vid1bratli_"));
//        email1.setSSLOnConnect(true);
//        email1.setDebug(true);
        email1.setTLS(true);
        email1.setStartTLSEnabled(true);

//        spring.mail.debug=true
//        spring.mail.smtp.auth=true
//        spring.mail.smtp.starttls.enable=true
        Map<String,Object> model = new HashMap<>();
        try {

            email1.setFrom("videolaribratli@gmail.com");
            email1.setSubject(mail.getTitle());
            email1.setHtmlMsg("<html><div><h3>Name: "+mail.getName()+"</h3></div>" +
                    "<div><h3>Email: "+mail.getEmail()+"</h3></div>" +
                    "<div><p>Message: "+mail.getMessage()+"</p></div></html>");
            email1.addTo("obidjoneshmamatov20000719@gmail.com");
            email1.send();
            if (email1 != null) {
                emailService.create(mail);
                model.put("succes", true);
                model.put("message", "send message");
                return ResponseEntity.ok(model);
            }
        } catch (EmailException e) {
            e.printStackTrace();
        }
        model.put("succes", false);
        model.put("message", "not send message");
        return ResponseEntity.ok(model);
    };

}
