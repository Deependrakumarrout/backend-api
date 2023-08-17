package com.realestate.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientRegDto {

    private Long id;
    private String clientName;
    private String clientAddress;
    private String phoneNumber;
    private String email;
    private String gender;
    private String username;
    private String password;


}
