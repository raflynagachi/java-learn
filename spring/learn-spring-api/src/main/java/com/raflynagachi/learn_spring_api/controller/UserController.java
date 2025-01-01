package com.raflynagachi.learn_spring_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raflynagachi.learn_spring_api.model.RegisterUserRequest;
import com.raflynagachi.learn_spring_api.model.WebResponse;
import com.raflynagachi.learn_spring_api.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> register(@RequestBody RegisterUserRequest req){
        userService.register(req);
        return WebResponse.<String>builder().data("OK").build();
    }
}