package com.example.petstore_api.response;

import com.example.petstore_api.model.Item;
import com.example.petstore_api.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemService {

    @GET("dev/api/item")
    Call<List<Item>> getItem();
}
