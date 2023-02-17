package fr.epita.movies.controller;

import fr.epita.movies.domain.Role;
import fr.epita.movies.repository.RoleRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;
    private static final Logger LOGGER = LogManager.getLogger(RoleController.class);

    @GetMapping("/role")
    public List<Role> getAllroles() {
        LOGGER.info("Get All roles {}", roleRepository.findAll());
        return roleRepository.findAll();
    }
}