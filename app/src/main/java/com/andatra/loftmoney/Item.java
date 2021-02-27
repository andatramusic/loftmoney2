package com.andatra.loftmoney;

public class Item {

    private String title;
    private double cost;
    private boolean isSelected;

    public Item(String title, double cost) {
        this.title = title;
        this.cost = cost;
        this.isSelected = false;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}