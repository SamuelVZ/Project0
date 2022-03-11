package com.revature.service;

import com.revature.dao.ClientDao;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.model.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientService {

    private ClientDao clientDao;

    //TODO 31: create the constructor for the Service class(communicates with the Dao layer)
    public ClientService(){
        this.clientDao = new ClientDao();
    }

    public List<Client> getAllClients() throws SQLException {
        return this.clientDao.getAllClients();
    }

    public Client getClientByID(String id) throws SQLException, ClientNotFoundException {
        //TODO 34: check if the input is valid, if not throw a IllegalArgumentException
        try {
            int clientId = Integer.parseInt(id);
            Client c = clientDao.getClientById(clientId);

            //TODO 33: check if the client exist, if not send a message (create a personal exception class)
            if (c == null){
                throw new ClientNotFoundException("The client with the id " + id + " doesn't exist");
            }
            return c;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Id provided is invalid: " + id);
        }



    }
}
