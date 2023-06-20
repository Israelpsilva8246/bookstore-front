package com.example.petshop.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static ItemsService INSTANCE;

    public static ItemsService getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://a22b-190-111-131-90.ngrok-free.app/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(ItemsService.class);
        }
        return INSTANCE;
    }
}
