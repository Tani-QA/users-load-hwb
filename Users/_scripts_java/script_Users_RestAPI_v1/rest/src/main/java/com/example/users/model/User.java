package com.example.users.model;

// создать сущность пользователя
public class User {
    private Integer id;
    private String login;
    private String password;
    private String createdDate;


    //геттеры и сеттеры
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {

        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

