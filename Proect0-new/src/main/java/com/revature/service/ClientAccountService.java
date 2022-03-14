package com.revature.service;

import com.revature.dao.ClientAccountDao;
import com.revature.dao.ClientDao;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.model.Client;
import com.revature.model.ClientAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ClientAccountService {

    public static Logger logger = LoggerFactory.getLogger(ClientService.class);

    private ClientAccountDao clientAccountDao;
    private ClientDao clientDao;


    public ClientAccountService() {
        this.clientAccountDao = new ClientAccountDao();
        this.clientDao = new ClientDao();
    }

    //for testing
    public ClientAccountService(ClientAccountDao mockAccountDao) {
        this.clientAccountDao = mockAccountDao;
    }


    public List<ClientAccount> getAllClientAccounts(String clientId) throws SQLException, ClientNotFoundException {
        logger.info("Service layer - get all the accounts of a client");

        try {
        int id = Integer.parseInt(clientId);
        Client c = clientDao.getClientById(id);

        if (c == null){
            logger.warn("Service layer - the client with id: " + clientId + " doesn't exist");
            throw new ClientNotFoundException("The client with the id " + clientId + " doesn't exist");
        }

        return this.clientAccountDao.getAllClientAccountsByClientId(id);


        }catch (NumberFormatException e) {
            logger.warn("Service layer - the client id: " + clientId + " is invalid");
            throw new IllegalArgumentException("Id provided is invalid: " + clientId);
        }
    }
}
