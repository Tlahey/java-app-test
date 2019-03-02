package com.java.test.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import javax.xml.ws.http.HTTPException;

import com.java.test.app.exceptions.UserAlreadyExistException;
import com.java.test.app.models.User;
import com.java.test.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/user")
@RestController(value="user")
@Api(value = "User", description = "Actions liés à l'utilisateur", tags = { "User" })
public class UserController {

    @Autowired
    UserService userService;
    
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value="Get user", notes = "DESCRIPTION : xxxxxxxxxxxxxxxxxx", tags = { "User" }, response = User.class)
    @RequestMapping(path="/", method=RequestMethod.GET)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = User.class)
    })
    public User user(
        @ApiParam(required = false, name = "firstName", value = "Prénom")
        @RequestParam String firstName, 
        
        @ApiParam(required = false, name = "lastName", value = "Nom")
        @RequestParam String lastName
    ) {
        User user = new User(counter.incrementAndGet(), firstName, lastName);
        System.out.println(user.toString());
        return user;
    }

    @ApiOperation(value="Create user", notes = "DESCRIPTION : xxxxxxxxxxxxxxxxxx", tags = { "User" }, response = User.class)
    @RequestMapping(path="/", method=RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 201, message = "Success", response = User.class)
    })
    public User createUser(

        @ApiParam(required = true, name = "User", value = "Utilisateur")
        @RequestBody(required = true) User user

    ) {
        // User user = new User(counter.incrementAndGet(), firstName, lastName);

        // TODO: faire une vérification sur l'ID et renvoyer un CONFLICT
        if( userService.get(user.getId()) != null ) {
            throw new UserAlreadyExistException("User id already exist");
        }

        userService.insert(user);  
        
        return user;
    }
}
