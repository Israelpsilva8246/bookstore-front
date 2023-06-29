package com.example.petstore_api.response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = " https://9f39-190-111-131-160.ngrok-free.app/";
    private static Retrofit retrofit = null;


    public static ItemService getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ItemService.class);
    }
}
