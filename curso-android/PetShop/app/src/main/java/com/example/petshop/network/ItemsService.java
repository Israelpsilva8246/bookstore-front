package com.example.petshop.network;

import com.example.petshop.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemsService {

    @GET("/dev/api/item")
    Call<List<Item>> getItems();
}
