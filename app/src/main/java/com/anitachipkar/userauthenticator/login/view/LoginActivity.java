package com.anitachipkar.userauthenticator.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anitachipkar.userauthenticator.country.view.MainActivity;
import com.anitachipkar.userauthenticator.R;
import com.anitachipkar.userauthenticator.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    LoginPresenter loginPresenter;
    Button buttonLogin;
    EditText username, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialization();


    }


    private void initialization() {

        hideKeyboardOnTouch();
        buttonLogin = findViewById(R.id.buttonLogin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        loginPresenter = new LoginPresenter(this);
        loginPresenter.initUser(username.getText().toString(), password.getText().toString());
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        buttonLogin.setOnClickListener(this);
    }


    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        if (result) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
        } else if (code == -1) {
            onSetUsernameError();

        } else if (code == -2) {
            onSetPasswordError();
        } else {
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        findViewById(R.id.loading).setVisibility(visibility);

    }

    @Override
    public void onSetUsernameError() {
        username.setError(getResources().getString(R.string.invalid_username));

    }

    @Override
    public void onSetPasswordError() {
        password.setError(getResources().getString(R.string.invalid_password));

    }


// hide keyboard on outside touch
    private void hideKeyboardOnTouch() {
        findViewById(R.id.container).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }
// login button click
    @Override
    public void onClick(View view) {
        validate(username.getText().toString(),password.getText().toString());
        loginPresenter.setProgressBarVisibility(View.VISIBLE);
        loginPresenter.doLogin(username.getText().toString(), password.getText().toString());



    }


    // validations for Test
    public String validate(String userName, String password)
    {
        if(userName.equals("user@gmail.com") && password.equals("user12345"))
            return "Login was successful";
        else
            return "Invalid login!";
    }
}
