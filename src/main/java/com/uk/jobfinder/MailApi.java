package com.uk.jobfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailApi {

    private MailService mailService;

    @Autowired
    public MailApi(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendMail")
    public String sendMail() throws MessagingException {
        mailService.sendMail("mateusz.zagrzejewski@gmail.com",
                "Wygrałeś",
                "<b>10zł</b><br>:P", true);
        return "wysłano";
    }
}
