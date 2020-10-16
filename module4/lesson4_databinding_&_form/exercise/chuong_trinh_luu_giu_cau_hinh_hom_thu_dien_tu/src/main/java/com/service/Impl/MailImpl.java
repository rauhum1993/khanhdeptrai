package com.service.Impl;

import com.model.Mail;
import com.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailImpl implements MailService {

    private static Mail mail;

    static {

       mail= new Mail("Lao", "5", "false", "hai");
    }

    @Override
    public void save(Mail mail1) {
        mail.setLanguage(mail1.getLanguage()) ;
        mail.setSize(mail1.getSize());
        mail.setSpamFilter(mail1.getSpamFilter());
        mail.setSignature(mail1.getSignature());
    }

    @Override
    public Mail display() {

        return mail;
    }
}
