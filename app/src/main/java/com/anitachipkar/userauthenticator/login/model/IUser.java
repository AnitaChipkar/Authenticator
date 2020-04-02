package com.anitachipkar.userauthenticator.login.model;

public interface IUser {

    String getUsername();
    String getPassword();

    int checkUserValidity(String username , String password);
}
