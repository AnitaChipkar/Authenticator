package com.anitachipkar.userauthenticator.login.presenter;



/**
 * Communicate with views and create presenter for handling functionality and go back to the views
 */
public interface ILoginPresenter {

    void doLogin(String username, String password);

    void setProgressBarVisibility(int visibility);
}
