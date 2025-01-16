package com.PremierPSpring.PremierPSpring.rest;

import com.PremierPSpring.PremierPSpring.POjO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping(path = "/user")
public interface UserRest {

    @RequestMapping(path = "/signup")
    public ResponseEntity<String> SignUp(@RequestBody(required = true) Map<String,String> requestMap);
}
