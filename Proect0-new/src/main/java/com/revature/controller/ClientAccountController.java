package com.revature.controller;

import com.revature.model.Client;
import com.revature.model.ClientAccount;
import com.revature.service.ClientAccountService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class ClientAccountController implements Controller{

    private ClientAccountService clientAccountService;

    public ClientAccountController() {
        this.clientAccountService = new ClientAccountService();
    }


    //REVIEW THIS ONE FOR THE SELECT AMOUNT HIGHER THAN 200 AND LOWER THAN
    private Handler getAllClientAccounts = (ctx) ->{

        String clientId = ctx.pathParam("client_id");

        List<ClientAccount> clientAccounts = clientAccountService.getAllClientAccounts(clientId);

        ctx.status(200);
        ctx.json(clientAccounts);
    };





    @Override
    public void mapEndPoints(Javalin app) {

        app.get("/clients/{client_id}/accounts", getAllClientAccounts);


    }
}
