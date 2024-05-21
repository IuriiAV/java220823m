package com.telran.org.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private long id;

    private String login;

    private String password;

    private String role;

    public UserDto(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserDto(long id, String login, String role) {
        this.id = id;
        this.login = login;
        this.role = role;
    }

    public UserDto() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
