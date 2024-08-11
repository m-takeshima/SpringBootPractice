package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contact;
import com.example.demo.form.ContactForm;

public interface ContactService {
    void saveContact(ContactForm contactForm);
    List<Contact> findAllContacts();
    Contact findContactById(Long id);
    void updateContact(Long id, ContactForm contactForm);  // 修正
    void deleteContact(Long id);
}
