package com.realestate.controller;

import com.realestate.payload.ClientRegDto;
import com.realestate.service.ClientRegService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientreg")
public class ClientRegController {

    // http://localhost:8080/api/clientreg/register


    private ClientRegService clientRegService;

    public ClientRegController(ClientRegService clientRegService) {
        this.clientRegService = clientRegService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createClientReg(@RequestBody ClientRegDto clientRegDto) {
        clientRegService.saveUser(clientRegDto);
        return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);

    }
}