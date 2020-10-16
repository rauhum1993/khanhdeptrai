package com.service;

import com.model.Mail;

import java.util.List;

public interface MailService {
    void save(Mail mail);

    Mail display();
}
