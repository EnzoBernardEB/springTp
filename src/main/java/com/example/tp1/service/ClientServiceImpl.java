package com.example.tp1.service;

import com.example.tp1.exception.ResourceNotFoundException;
import com.example.tp1.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("clients")
public class ClientServiceImpl implements ClientService{
    private final List<Client> allClient = new ArrayList<>();

    @Override
    public List<Client> getAllClient() {
        return this.allClient;
    }

    @Override
    public Client getClientById(Long clientId) {
        Client result = this.allClient.stream().filter(client -> client.getId() == clientId).findFirst().get();
        if(result != null) {
            return result;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Client save(Client client) {
        this.allClient.add(client);
        return client;
    }
}
