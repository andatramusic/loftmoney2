package com.andatra.loftmoney;

public interface LoginPresenter {
    void attachViewState(LoginView loginView);
    void disposeRequests();
}