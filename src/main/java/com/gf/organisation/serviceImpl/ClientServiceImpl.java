package com.gf.organisation.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.organisation.entity.Client;
import com.gf.organisation.repository.ClientRepository;
import com.gf.organisation.service.ClientService;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ClientServiceImpl  implements ClientService{
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client createClient(@Valid Client client) {
		return clientRepository.save(client);
	}
	@Override
	public Optional<Client>getClientById(@Valid Long id){
		return clientRepository.findById(id);
	}
	@Override
	public List<Client>getAllClients(){
		return clientRepository.findAll();
	}
	@Override
	public Client updateClient(@Valid Long id, Client client) {
		Client updateClient = clientRepository.save(client);
		if (updateClient !=null) {
			return updateClient;
			
		} else {
			
			throw new RuntimeException("Failed to update client");
		}
		
	}
	@Override
	public Client deleteClient(@Valid Long id) {
		Optional<Client> optionalClient = clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			Client  deleteClient = optionalClient.get();
			clientRepository.deleteById(id);
			return deleteClient;
		
			
		} else {
			return null;

		}
	}

}
