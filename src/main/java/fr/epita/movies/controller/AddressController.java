package fr.epita.movies.controller;

import fr.epita.movies.domain.Address;

import fr.epita.movies.repository.AddressRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    private static final Logger LOGGER = LogManager.getLogger(AddressController.class);

    @GetMapping("/address")
    public List<Address> getAllAddress() {
        LOGGER.info("Get All addresses {}", addressRepository.findAll());
        return addressRepository.findAll();
    }
}