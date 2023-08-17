package com.realestate.service.impl;

import com.realestate.entities.ClientReg;
import com.realestate.payload.ClientRegDto;
import com.realestate.repositories.ClientRegRepository;
import com.realestate.service.ClientRegService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientRegServiceImpl implements ClientRegService {

    private ClientRegRepository clientRegRepository;
    private PasswordEncoder passwordEncoder;

    public ClientRegServiceImpl(ClientRegRepository clientRegRepository, PasswordEncoder passwordEncoder) {
        this.clientRegRepository = clientRegRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(ClientRegDto clientRegDto) {
        ClientReg  clientReg = mapToEntity(clientRegDto);
        clientRegRepository.save(clientReg);
    }


    ClientReg mapToEntity(ClientRegDto clientRegDto) {
        ClientReg client = new ClientReg();
        client.setClientAddress(clientRegDto.getClientAddress());
        client.setClientName(clientRegDto.getClientName());
        client.setGender(clientRegDto.getGender());
        client.setEmail(clientRegDto.getEmail());
        client.setPassword(passwordEncoder.encode(clientRegDto.getPassword()));

        client.setUsername(clientRegDto.getUsername());
        client.setPhoneNumber(clientRegDto.getPhoneNumber());

        return client;

    }


}
