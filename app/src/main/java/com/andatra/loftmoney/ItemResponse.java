package com.andatra.loftmoney;
import com.andatra.loftmoney.AddItemRequest;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private List<AddItemRequest> ItemsList;

    public String getStatus() {
        return status;
    }

    public List<AddItemRequest> getItemsList() {
        return ItemsList;
    }
}