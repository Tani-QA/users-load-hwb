package com.example.users.model;


import java.text.SimpleDateFormat;
import java.util.Date;


public class User {


    private String login;
    private String password;
    private String createdDate;

    public User() {

    }



    public User(String login, String password, String data) {
        this.login = login;
        this.password = password;
        this.createdDate =data;
    }


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedData() {
        Date createDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.createdDate = formatter.format(createDate);
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
