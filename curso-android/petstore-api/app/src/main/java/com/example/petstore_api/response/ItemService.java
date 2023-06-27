package com.example.petstore_api.response;

import com.example.petstore_api.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ItemService {

    @GET("/dev/api/item")
    Call<List<Item>> getItem();

    @POST("/dev/api/item")
    Call<Item> createItem(@Body Item item);
}
