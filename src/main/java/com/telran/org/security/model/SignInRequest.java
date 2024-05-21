package com.telran.org.security.model;

import lombok.Data;

@Data
public class SignInRequest {

    private String login;

    private String password;
}
