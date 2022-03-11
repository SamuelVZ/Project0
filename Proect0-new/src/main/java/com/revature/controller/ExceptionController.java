package com.revature.controller;

import com.revature.exceptions.ClientNotFoundException;
import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;

//TODO 35: create the class ExceptionController so javalin handles the exceptions, import controller interface
public class ExceptionController implements Controller{
/*TODO 36: create the exceptions that are going to catch the endpoint handlers with the ExceptionHandler
   (so we don't need to use a try-catch on the service layer), so on the service layer all the
   handler we use can catch this exceptions if needed
*/
    private ExceptionHandler clientNotFound = (e, ctx) ->{
        ctx.status(404); //code 404 for not found resources
        ctx.json(e.getMessage());
    };

    private ExceptionHandler clientIdInvalid = (e, ctx) ->{
        ctx.status(400);
        ctx.json(e.getMessage());
    };

    @Override
    public void mapEndPoints(Javalin app) {

        app.exception(ClientNotFoundException.class, clientNotFound);
        app.exception(IllegalArgumentException.class, clientIdInvalid);
    }
}
