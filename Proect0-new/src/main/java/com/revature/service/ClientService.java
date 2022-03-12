package com.revature.service;

import com.revature.dao.ClientDao;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.main.Driver;
import com.revature.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    //TODO 42: create a logger in the service layer

    public static Logger logger = LoggerFactory.getLogger(ClientService.class);


    private ClientDao clientDao;

    //TODO 31: create the constructor for the Service class(communicates with the Dao layer)
    public ClientService(){
        this.clientDao = new ClientDao();
    }


    //TODO 39: create a constructor for testing mock clients so we don't access to the real database
    public ClientService(ClientDao mockDao){
        this.clientDao = mockDao;
    }

    public List<Client> getAllClients() throws SQLException {
        logger.info("Service layer - get all the clients");
        return this.clientDao.getAllClients();
    }



    public Client getClientByID(String id) throws SQLException, ClientNotFoundException {
        logger.info("Service layer to get the client with id: " + id);

        //TODO 34: check if the input is valid, if not throw a IllegalArgumentException
        try {
            int clientId = Integer.parseInt(id);
            Client c = clientDao.getClientById(clientId);

            //TODO 33: check if the client exist, if not send a message (create a personal exception class)
            if (c == null){
                logger.warn("Service layer - the client with id: " + id + " doesn't exist");
                throw new ClientNotFoundException("The client with the id " + id + " doesn't exist");
            }
            logger.info("Service layer - Successful return of the client with id: " + id);
            return c;
        }catch (NumberFormatException e) {
            logger.warn("Service layer - the client id: " + id + " is invalid");
            throw new IllegalArgumentException("Id provided is invalid: " + id);
        }
    }
}
