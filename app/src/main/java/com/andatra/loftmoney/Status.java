package com.andatra.loftmoney;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("id")
    private String userId;

    @SerializedName("auth_token")
    private String authToken;

    @SerializedName("status")
    private String status;

    public String getUserId() {
        return userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getStatus() {
        return status;
    }
}