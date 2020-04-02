package com.anitachipkar.userauthenticator.login.presenter;

import android.os.Handler;
import android.os.Looper;
import com.anitachipkar.userauthenticator.login.model.IUser;
import com.anitachipkar.userauthenticator.login.model.UserModel;
import com.anitachipkar.userauthenticator.login.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    private ILoginView iLoginView;
    private IUser user;
    private Handler handler;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        handler = new Handler(Looper.getMainLooper());

    }

    public void initUser(String username, String password) {
        user = new UserModel(username, password);
    }


    @Override
    public void doLogin(String username, String password) {

        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(username, password);
        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);

            }
        }, 5000);

    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);

    }
}
