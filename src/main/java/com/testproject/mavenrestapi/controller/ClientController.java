package com.testproject.mavenrestapi.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.testproject.mavenrestapi.model.Client;
import com.testproject.mavenrestapi.repository.ClientRepository;

@Repository
@RequestMapping("/client")
public class ClientController {
	
	private final ClientRepository clientRepository;

	public ClientController(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	@PostMapping
    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }
	

}
