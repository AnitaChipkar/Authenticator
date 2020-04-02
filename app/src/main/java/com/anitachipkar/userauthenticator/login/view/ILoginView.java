package com.anitachipkar.userauthenticator.login.view;


/**
 * Update info from presenter
 */
public interface ILoginView {
    public void onLoginResult(Boolean result , int code);
    public void onSetProgressBarVisibility(int visibility);
    public void onSetUsernameError();
    public  void onSetPasswordError();
}
