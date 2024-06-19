package com.swaggerexample.swagger_training.controller;

import com.swaggerexample.swagger_training.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    @Operation(
            description = "Get Users Service",
            responses={
                    @ApiResponse(responseCode = "400",ref = "badRequest"),
                    @ApiResponse(responseCode = "500",ref = "internalServerError"),
                    @ApiResponse(responseCode = "200",ref = "successfulResponse")
            }
    )
    public List<User> getUsers(){
        return User.dummyUsers();
    }

    @PostMapping
    public User addUser(User user){
        return user;
    }

}
