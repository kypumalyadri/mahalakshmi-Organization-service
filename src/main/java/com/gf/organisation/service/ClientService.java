package com.gf.organisation.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.gf.organisation.entity.Client;

public interface ClientService {
	
	Client createClient(@Valid Client client);
	
	Optional<Client>getClientById(@Valid Long id);
	
	List<Client>getAllClients();
	
	Client updateClient(@Valid Long id, Client client);
	
	Client deleteClient(@Valid Long id);

}
