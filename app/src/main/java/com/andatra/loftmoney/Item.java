package com.andatra.loftmoney;

public class Item {

    private String title;
    private int cost;

    public Item(final String title, final int cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }
}