package com.example.tp1.service;

import com.example.tp1.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(Long clientId);
    public Client save(Client client);
}
