package com.andatra.loftmoney;

public interface LoginView {
    void toggleSending(boolean isActive);
    void showMessage(String text);
    void showSuccess(String token);
}