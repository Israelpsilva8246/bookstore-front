package com.example.petshop.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class ItemsResult {

    @Json(name = "results")
    private final List<ItemResponse> resultadoItems;

    public ItemsResult(List<ItemResponse> resultadoItems) {
        this.resultadoItems = resultadoItems;
    }

    public List<ItemResponse> getResultadoItems() {
        return resultadoItems;
    }
}
