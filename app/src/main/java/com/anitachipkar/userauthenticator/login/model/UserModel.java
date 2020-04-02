package com.anitachipkar.userauthenticator.login.model;


import android.util.Patterns;

/**
 * Pojo class
 */

public class UserModel implements IUser {

    private String username;
    private String password;

    public UserModel(String username , String password)
    {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkUserValidity(String username, String password) {
        if (!isUserNameValid(username))
        {
            return -1;
        }
        else if (!isPasswordValid(password))
        {
            return -2;
        }
        return 0;
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {

        return username != null && Patterns.EMAIL_ADDRESS.matcher(username).matches();
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
