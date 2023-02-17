package fr.epita.movies.controller;



import fr.epita.movies.domain.Contact;
import fr.epita.movies.repository.ContactRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    private static final Logger LOGGER = LogManager.getLogger(ContactController.class);

    @GetMapping("/contact")
    public List<Contact> getAllContact() {
        LOGGER.info("Get All contacts {}", contactRepository.findAll());
        return contactRepository.findAll();
    }
}