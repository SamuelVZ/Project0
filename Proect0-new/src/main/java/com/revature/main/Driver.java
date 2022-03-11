package com.revature.main;

import com.revature.controller.ClientController;
import com.revature.controller.ExceptionController;
import com.revature.controller.TestController;
import com.revature.controller.Controller;
import io.javalin.Javalin;

import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) throws SQLException {
        //TODO 28: create an instance of javalin
        Javalin app = Javalin.create();

        mapControllers (app, new TestController(), new ClientController(), new ExceptionController());

        app.start();


        //TODO 23: test the dao layer
       /* ClientDao clientDao = new ClientDao();
        System.out.println(clientDao.getClientById(1));

        System.out.println(clientDao.getAllClients());
        System.out.println(clientDao.deleteClientById(1));
        System.out.println(clientDao.getAllClients());

        System.out.println(clientDao.updateClient(new Client(2,"HugoUPd", "laicona", 55,"3692581477")));
        System.out.println(clientDao.getAllClients());

        System.out.println(clientDao.addClient(new Client(0,"newNew", "added", 22,"3692581477")));
        System.out.println(clientDao.getAllClients());

        */
    }

    private static void mapControllers(Javalin app, Controller... controllers) {
        for (Controller c: controllers){
            c.mapEndPoints(app);
        }

    }
}
