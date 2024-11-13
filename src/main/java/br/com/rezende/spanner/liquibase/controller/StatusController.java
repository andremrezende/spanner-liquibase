package br.com.rezende.spanner.liquibase.controller;

import br.com.rezende.spanner.liquibase.model.Status;
import br.com.rezende.spanner.liquibase.repository.StatusRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    private final StatusRepository statusRepository;

    StatusController(StatusRepository personRepository) {
        this.statusRepository = personRepository;
    }

    @GetMapping("/status")
    Status create(String name) {
        Status p = new Status();

        p.setName(name);
        statusRepository.save(p);

        return p;
    }
}
