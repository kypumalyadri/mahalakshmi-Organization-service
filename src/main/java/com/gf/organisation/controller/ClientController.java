package com.gf.organisation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gf.organisation.entity.Client;
import com.gf.organisation.service.ClientService;

@RestController
@RequestMapping(value = "Client")
@CrossOrigin(origins = "*")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/save")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        logger.info("Creating client: {}", client);

        Client createdClient = clientService.createClient(client);

        logger.info("Client created: {}", createdClient);

        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
        logger.info("Getting client by id: {}", id);

        Optional<Client> client = clientService.getClientById(id);

        if (client.isPresent()) {
            logger.info("Client found: {}", client.get());
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            logger.info("Client not found for id: {}", id);
            return new ResponseEntity<>(client, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Client>> getAllClients() {
        logger.info("Getting all clients");

        List<Client> clients = clientService.getAllClients();

        logger.info("Total clients found: {}", clients.size());

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client client) {
        logger.info("Updating client with id {}: {}", id, client);

        Client updatedClient = clientService.updateClient(id, client);

        if (updatedClient != null) {
            logger.info("Client updated: {}", updatedClient);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            logger.info("Failed to update client with id: {}", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        logger.info("Deleting client with id: {}", id);

        Client deletedClient = clientService.deleteClient(id);

        if (deletedClient != null) {
            logger.info("Client deleted: {}", deletedClient);
            return new ResponseEntity<>(deletedClient, HttpStatus.OK);
        } else {
            logger.info("Failed to delete client with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
