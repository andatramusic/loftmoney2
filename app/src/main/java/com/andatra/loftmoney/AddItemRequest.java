package com.andatra.loftmoney;


class AddItemRequest {

    private String title;
    private String type;
    private int cost;

    public AddItemRequest(final String title, final String type, final int cost) {
        this.title = title;
        this.type = type;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }
}