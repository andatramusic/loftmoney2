package com.andatra.loftmoney;

public interface EditModeListener {
    void onEditModeChanged(boolean status);
    void onCounterChanged(int newCount);
}