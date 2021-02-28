package com.andatra.loftmoney;

import com.google.gson.annotations.SerializedName;

public class RemoteItem {
    @SerializedName("id")
    private String itemId;

    @SerializedName("title")
    private String title;

    @SerializedName("cost")
    private double cost;

    @SerializedName("type")
    private String type;

    @SerializedName("date")
    private String date;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}