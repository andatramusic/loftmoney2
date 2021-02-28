package com.andatra.loftmoney;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements LoginView {

    Button loginButtonView;

    public LoginPresenter loginPresenter = new LoginPresenter() {
        @Override
        public void attachViewState(LoginView loginView) {

        }

        @Override
        public void disposeRequests() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButtonView = findViewById(R.id.loginEnterView);
        loginPresenter.attachViewState(this);

        configureButton();
    }

    @Override
    protected void onPause() {
        loginPresenter.disposeRequests();
        super.onPause();
    }

    private void configureButton() {
    }

    @Override
    public void toggleSending(boolean isActive) {
        loginButtonView.setVisibility(isActive ? View.GONE : View.VISIBLE);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String token) {
        Toast.makeText(getApplicationContext(), "User was logged", Toast.LENGTH_SHORT).show();

        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);
    }
}